package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptPsiImplUtil {


    @NotNull
    public static List<AppleScriptComponentName> getComponentNameList(@NotNull AppleScriptTargetListLiteral targetList) {
        final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
            for (AppleScriptTargetComponentName targetComponentName : targetList.getTargetComponentNameList()) {
                componentNames.add(targetComponentName.getComponentName());
            }
        return componentNames;
    }

    @NotNull
    public static List<AppleScriptComponentName> getComponentNameList(@NotNull AppleScriptFormalParameterList parameterList) {
        final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
        for (AppleScriptTargetComponentName targetComponentName : parameterList.getTargetComponentNameList()) {
            componentNames.add(targetComponentName.getComponentName());
        }
        return componentNames;
    }

    @NotNull
    public static List<AppleScriptComponentName> getComponentNameList(@NotNull AppleScriptTargetRecordLiteral targetList) {
        final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
        for (AppleScriptTargetComponentName targetComponentName : targetList.getTargetComponentNameList()) {
            componentNames.add(targetComponentName.getComponentName());
        }
        return componentNames;
    }

    @Nullable
    public static AppleScriptPsiElement getTargetComponent(@NotNull AppleScriptCreationStatement creationStatement){
        AppleScriptTargetComponentName targetComponentName = creationStatement.getTargetComponentName();
        AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
        AppleScriptTargetRecordLiteral recordLiteral = creationStatement.getTargetRecordLiteral();
        return targetComponentName!=null ? targetComponentName
                : targetListLiteral!=null ? targetListLiteral
                : recordLiteral!=null ? recordLiteral : null;
    }

    @NotNull
    public static List<AppleScriptComponentName> getComponentNameList(@NotNull AppleScriptCreationStatement creationStatement) {
        List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
        AppleScriptTargetComponentName targetComponentName = creationStatement.getTargetComponentName();
        if (targetComponentName != null) {
            result.add(targetComponentName.getComponentName());
            return result;
        }
        AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
        if (targetListLiteral!=null) {
            result.addAll(targetListLiteral.getComponentNameList());
            return result;
        }
        AppleScriptTargetRecordLiteral recordLiteral = creationStatement.getTargetRecordLiteral();
        if (recordLiteral!=null) {
            result.addAll(recordLiteral.getComponentNameList());
            return result;
        }
        return result;
    }

//    @NotNull
//    public static List<AppleScriptComponentName> getTargetComponentNameList(@NotNull AppleScriptTargetCompositeComponent compositeTarget) {
//        PsiElement firstChild = compositeTarget.getFirstChild();
//        final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
//        if (firstChild instanceof AppleScriptTargetListLiteral) {
//            AppleScriptTargetListLiteral targetList = (AppleScriptTargetListLiteral) firstChild;
//            for (AppleScriptTargetComponentName targetComponentName : targetList.getTargetComponentNameList()) {
//                componentNames.add(targetComponentName.getComponentName());
//            }
////              return targetList.getTargetComponentNameList();
//        } else if (firstChild instanceof AppleScriptTargetRecordLiteral) {
//            AppleScriptTargetRecordLiteral targetList = (AppleScriptTargetRecordLiteral) firstChild;
//            targetList.getTargetComponentNameList();
//        }
//        return componentNames;
////          compositeTarget.getTargetComponentNameList();
//    }

}
