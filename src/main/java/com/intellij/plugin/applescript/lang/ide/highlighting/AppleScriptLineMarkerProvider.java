package com.intellij.plugin.applescript.lang.ide.highlighting;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryService;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.psi.AppleScriptApplicationReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class AppleScriptLineMarkerProvider extends RelatedItemLineMarkerProvider {

  @Override
  protected void collectNavigationMarkers(@NotNull PsiElement element,
                                          @NotNull Collection<? super RelatedItemLineMarkerInfo> result) {
    if (element instanceof AppleScriptApplicationReference) {
      PsiElement leafNode = PsiTreeUtil.firstChild(element);
      if (leafNode == null) return;
      AppleScriptProjectDictionaryService dictionaryService = ServiceManager.getService(element.getProject(),
          AppleScriptProjectDictionaryService.class);
      AppleScriptApplicationReference appRef = (AppleScriptApplicationReference) element;
      String appName = appRef.getApplicationName();
      if (dictionaryService == null || StringUtil.isEmpty(appName)) return;
      ApplicationDictionary dictionary = dictionaryService.getDictionary(appName);
      if (dictionary == null /*|| dictionary.getApplicationBundle() == null*/) return;

      NavigationGutterIconBuilder<PsiElement> builder =
          NavigationGutterIconBuilder.create(dictionary.getIcon(0)).
              setTargets(dictionary).setTooltipText("Navigate to application dictionary file");
      result.add(builder.createLineMarkerInfo(leafNode));

    }
  }
}
