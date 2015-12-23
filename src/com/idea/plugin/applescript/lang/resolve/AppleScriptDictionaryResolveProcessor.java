package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryService;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.psi.*;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.idea.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.idea.plugin.applescript.psi.sdef.impl.AbstractDictionaryConstantSpecifier;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.KeyWithDefaultValue;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.ResolveState;
import com.intellij.util.containers.SortedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Andrey 20.04.2015
 */
public class AppleScriptDictionaryResolveProcessor extends AppleScriptPsiScopeProcessor {

  public static final Key<Boolean> COLLECT_ALL_DECLARATIONS =
          new KeyWithDefaultValue<Boolean>("apple.script.resolve.state.collect.all") {
            @Override
            public Boolean getDefaultValue() {
              return false;
            }
          };
  private static final Logger LOG = Logger.getInstance("#" + AppleScriptDictionaryResolveProcessor.class.getName());

  private final @NotNull Project myProject;
  private final @Nullable DictionaryCompositeElement myElement;
  private final @NotNull String myElementName;
  @NotNull private final SortedList<AppleScriptUseStatement> mySortedUseStatements =
          new SortedList<AppleScriptUseStatement>(new Comparator<AppleScriptUseStatement>() {
            @Override
            public int compare(AppleScriptUseStatement o1, AppleScriptUseStatement o2) {
              return -(o1.getTextOffset() - o2.getTextOffset());
            }
          });
  @NotNull private final List<ApplicationDictionary> collectedDictionaries = new ArrayList<ApplicationDictionary>();
  private DictionaryComponent myResult;
  private boolean foundInUseStatementFlag = false;

  public AppleScriptDictionaryResolveProcessor(@NotNull DictionaryCompositeElement dictionaryElement,
                                               @NotNull String elementName) {
    myElement = dictionaryElement;
    myElementName = elementName;
    myProject = myElement.getProject();
  }

  public AppleScriptDictionaryResolveProcessor(@NotNull Project project, @NotNull String elementName) {
    myProject = project;
    myElementName = elementName;
    myElement = null;
  }

  @Override
  protected boolean doExecute(@NotNull AppleScriptPsiElement element, final @NotNull ResolveState state) {

    if (!(element instanceof ApplicationDictionaryDeclarator)) return true;
    boolean collectAll = state.get(COLLECT_ALL_DECLARATIONS) == Boolean.TRUE;

    if (!collectAll && myElement != null) {
      AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
              .getService(element.getProject(), AppleScriptProjectDictionaryService.class);
      String appName = ((ApplicationDictionaryDeclarator) element).getApplicationName();
      ApplicationDictionary importedDictionary;

      if (appName == null || dictionaryRegistry == null) return true;

      importedDictionary = dictionaryRegistry.getDictionary(appName);
      if (importedDictionary == null) {
        importedDictionary = dictionaryRegistry.createDictionary(appName);
      }
      if (element instanceof AppleScriptUseStatement) {
        AppleScriptUseStatement useStatement = (AppleScriptUseStatement) element;
        mySortedUseStatements.add(useStatement);
        if (useStatement.withImporting()) {
          collectedDictionaries.add(importedDictionary);

          //extract method => set result to the closes application dictionary
          for (AppleScriptUseStatement sortedUseStatement : mySortedUseStatements) {
            if (!sortedUseStatement.withImporting()) continue;

            String currAppName = sortedUseStatement.getApplicationName();
            if (!StringUtil.isEmpty(currAppName)) {
              ApplicationDictionary currentDictionary = dictionaryRegistry.getDictionary(currAppName);
              if (currentDictionary != null) {
                // in case of use statements we should add matching component only from the closest use statement
                // since import statements are sorted as soon as we found first match - it will be the
                // closes use statement
                if (setResult(currentDictionary, myElement)) {
                  //add the flag that term was found in use stmt
                  foundInUseStatementFlag = true;
                  break;
                }
              }
            }
          }
        }

      } else if (!foundInUseStatementFlag) {
        if (importedDictionary != null) {
          collectedDictionaries.add(importedDictionary);
          return !setResult(importedDictionary, myElement);
        }
      }
      return true;
    } else {//collecting all declarations
      AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
              .getService(element.getProject(), AppleScriptProjectDictionaryService.class);
      String appName = ((ApplicationDictionaryDeclarator) element).getApplicationName();
      ApplicationDictionary importedDictionary = null;
      if (appName != null && dictionaryRegistry != null) {
        importedDictionary = dictionaryRegistry.getDictionary(appName);
        if (importedDictionary == null) {
          importedDictionary = dictionaryRegistry.createDictionary(appName);
        }
      }
      if (importedDictionary != null) {
        if (element instanceof AppleScriptUseStatement) {
          AppleScriptUseStatement useStatement = (AppleScriptUseStatement) element;
          mySortedUseStatements.add(useStatement);
          if (useStatement.withImporting()) {
            collectedDictionaries.add(importedDictionary);
          }
        } else {
          collectedDictionaries.add(importedDictionary);
        }
      }
    }
    return true;
  }

  private boolean setResultFromCocoaStandardLibrary(@NotNull DictionaryCompositeElement element) {
    AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
            .getService(element.getProject(), AppleScriptProjectDictionaryService.class);
    if (dictionaryRegistry == null) return false;
    ApplicationDictionary cocoaStandard = dictionaryRegistry.getCocoaStandardTerminology();
    return cocoaStandard != null && setResult(cocoaStandard, element);
  }

  private boolean setResultFromStandardAdditionsLibrary(@NotNull DictionaryCompositeElement element) {
    AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
            .getService(element.getProject(), AppleScriptProjectDictionaryService.class);
    if (dictionaryRegistry == null) return false;
    ApplicationDictionary standardAdditions = dictionaryRegistry.getStandardAdditionsTerminology();
    return standardAdditions != null && setResult(standardAdditions, element);
  }

  private boolean setResult(@NotNull ApplicationDictionary importedDictionary,
                            @NotNull DictionaryCompositeElement element) {
    DictionaryComponent res = null;
    if (element instanceof AppleScriptCommandHandlerCall) {
      res = importedDictionary.findCommand(myElementName);
    } else if (element instanceof AppleScriptDictionaryClassName) {
      res = importedDictionary.findClass(myElementName);
    } else if (element instanceof AppleScriptDictionaryPropertyName) {
      res = importedDictionary.findProperty(myElementName);
    } else if (element instanceof AbstractDictionaryConstantSpecifier) {
      res = importedDictionary.findEnumerator(myElementName);
    } else if (element instanceof AppleScriptDictionaryClassIdentifierPlural) {
      res = importedDictionary.findClassByPluralName(myElementName);
    } else {
      LOG.warn("WARNING: unknown dictionary reference element: " + element.getClass().getName());
    }
    if (res != null) {
      myResult = res;
      return true;
    }
    return false;
  }

  @Nullable
  @Override
  public <T> T getHint(@NotNull Key<T> hintKey) {
    return null;
  }

  @Override
  public void handleEvent(@NotNull Event event, @Nullable Object associated) {

  }

  public DictionaryComponent getMyResult() {
    if (myResult == null && myElement != null) {
      // myResult == null means that there were no terms found in <tell>/<using terms>/<use> statements in script ->
      // then we are searching in CocoaStandard (available for any scriptable app) and if there were no <use>
      // statements, searching in StandardAdditions
      if (!setResultFromCocoaStandardLibrary(myElement) && mySortedUseStatements.size() == 0) {
        setResultFromStandardAdditionsLibrary(myElement);
      }
    }
    return myResult;
  }

  @NotNull
  public List<DictionaryComponent> getFilteredResult() {
    List<DictionaryComponent> result = new ArrayList<DictionaryComponent>();
    boolean filterStdCocoaTerminologyFlag = false; //if there was at least one dictionary from a real app imported
    AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
            .getService(myProject, AppleScriptProjectDictionaryService.class);
    for (ApplicationDictionary collectedDictionary : collectedDictionaries) {
      collectAllComponentsFromDictionary(collectedDictionary, result, filterStdCocoaTerminologyFlag);//was false??
      filterStdCocoaTerminologyFlag = filterStdCocoaTerminologyFlag
              || !collectedDictionary.getName().equals(ApplicationDictionary.STANDARD_ADDITIONS_LIBRARY);
    }
    if (dictionaryRegistry != null) {
      appendResultsIfNeeded(result, myProject, mySortedUseStatements.size() > 0,
              collectedDictionaries.contains(dictionaryRegistry.getStandardAdditionsTerminology()),
              filterStdCocoaTerminologyFlag);
    }
    return result;
  }

  private static void appendResultsIfNeeded(@NotNull Collection<DictionaryComponent> result,
                                            @NotNull Project project,
                                            boolean areThereUseStatements,
                                            boolean filterStandardAdditions, boolean filterCocoaStandard) {
    AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
            .getService(project, AppleScriptProjectDictionaryService.class);
    if (dictionaryRegistry == null) return;
    if (!filterStandardAdditions && !areThereUseStatements) {
      ApplicationDictionary stdAdditions = dictionaryRegistry.getStandardAdditionsTerminology();
      collectAllComponentsFromDictionary(stdAdditions, result, false);
    }
    if (!filterCocoaStandard) {
      ApplicationDictionary cocoaStandardTerminology = dictionaryRegistry.getCocoaStandardTerminology();
      collectAllComponentsFromDictionary(cocoaStandardTerminology, result, false);
    }
  }

  public static void collectAllComponentsFromDictionary(@Nullable ApplicationDictionary importedDict,
                                                        @NotNull Collection<DictionaryComponent> dictionaryComponents,
                                                        boolean withCocoaStdLibFiltering) {
    if (importedDict == null) return;
    if (withCocoaStdLibFiltering) {
      AppleScriptProjectDictionaryService dictionaryRegistry = ServiceManager
              .getService(importedDict.getProject(), AppleScriptProjectDictionaryService.class);
      ApplicationDictionary cocoaStandard = null;
      if (dictionaryRegistry != null) {
        cocoaStandard = dictionaryRegistry.getCocoaStandardTerminology();
      }
      if (cocoaStandard != null) {
        for (DictionaryEnumerator dicConst : importedDict.getDictionaryEnumeratorMap().values()) {
          if (cocoaStandard.findEnumerator(dicConst.getName()) == null) {
            dictionaryComponents.add(dicConst);
          }
        }
        for (AppleScriptClass clz : importedDict.getDictionaryClassMap().values()) {
          if (cocoaStandard.findClass(clz.getName()) == null) {
            dictionaryComponents.add(clz);
          }
        }
        for (AppleScriptCommand cmd : importedDict.getAllCommands()) {
          if (cocoaStandard.findCommand(cmd.getName()) == null) {
            dictionaryComponents.add(cmd);
          }
        }
        for (AppleScriptPropertyDefinition prop : importedDict.getDictionaryPropertyMap().values()) {
          if (cocoaStandard.findCommand(prop.getName()) == null) {
            dictionaryComponents.add(prop);
          }
        }
      }
    } else {
      dictionaryComponents.addAll(importedDict.getDictionaryEnumeratorMap().values());
      dictionaryComponents.addAll(importedDict.getDictionaryPropertyMap().values());
      dictionaryComponents.addAll(importedDict.getDictionaryClassMap().values());
      dictionaryComponents.addAll(importedDict.getAllCommands());
    }
  }
}
