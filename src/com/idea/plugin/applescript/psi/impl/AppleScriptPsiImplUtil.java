package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptPsiImplUtil {


    @NotNull
    public static List<AppleScriptTargetVariable> getTargetVariableListRecursive(@NotNull AppleScriptTargetListLiteral targetList) {
        final List<AppleScriptTargetVariable> componentNames = new ArrayList<AppleScriptTargetVariable>();
            for (AppleScriptTargetVariable targetComponentName : targetList.getTargetVariableList()) {
                componentNames.add(targetComponentName);
            }
        return componentNames;
    }

    @NotNull
    public static List<AppleScriptComponentName> getTargetVariableListRecursive(@NotNull AppleScriptFormalParameterList parameterList) {
        final List<AppleScriptComponentName> componentNames = new ArrayList<AppleScriptComponentName>();
        for (AppleScriptTargetVariable targetComponentName : parameterList.getTargetVariableList()) {
            componentNames.add(targetComponentName.getComponentName());
        }
        return componentNames;
    }

    @NotNull
    public static List<AppleScriptTargetVariable> getTargetVariableListRecursive(@NotNull AppleScriptTargetRecordLiteral targetList) {
        final List<AppleScriptTargetVariable> targetVariables = new ArrayList<AppleScriptTargetVariable>();
        //one level depths:
        List<AppleScriptTargetVariable> thisRecordVariables = targetList.getTargetVariableList();
        List<AppleScriptTargetListLiteral> thisRecordTargetRecords = targetList.getTargetListLiteralList();
        List<AppleScriptTargetRecordLiteral> thisRecordTargetLists = targetList.getTargetRecordLiteralList();
        for (AppleScriptTargetVariable targetComponentName : thisRecordVariables) {
            targetVariables.add(targetComponentName);
        }
        for (AppleScriptTargetListLiteral innerList : thisRecordTargetRecords) {
            List<AppleScriptTargetVariable> varList = innerList.getTargetVariableList();
            for (AppleScriptTargetVariable var : varList) {
                targetVariables.add(var);
            }
        }
        for (AppleScriptTargetRecordLiteral innerRecord : thisRecordTargetLists) {
            List<AppleScriptTargetVariable> varList = innerRecord.getTargetVariableList();
            for (AppleScriptTargetVariable var : varList) {
                targetVariables.add(var);
            }
        }
        return targetVariables;
    }

    @Nullable
    public static AppleScriptPsiElement getAssignmentTarget(@NotNull AppleScriptCreationStatement creationStatement){
        AppleScriptTargetVariable targetVariable = creationStatement.getTargetVariable();
        AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
        AppleScriptTargetRecordLiteral recordLiteral = creationStatement.getTargetRecordLiteral();
        return targetVariable!=null ? targetVariable
                : targetListLiteral!=null ? targetListLiteral
                : recordLiteral!=null ? recordLiteral : null;
    }

    @NotNull
    public static List<AppleScriptComponentName> getTargetVariableListRecursive(@NotNull AppleScriptCreationStatement creationStatement) {
        List<AppleScriptComponentName> result = new ArrayList<AppleScriptComponentName>();
        AppleScriptTargetVariable targetComponentName = creationStatement.getTargetVariable();
        if (targetComponentName != null) {
            result.add(targetComponentName.getComponentName());
            return result;
        }
        AppleScriptTargetListLiteral targetListLiteral = creationStatement.getTargetListLiteral();
        if (targetListLiteral!=null) {
            for (AppleScriptTargetVariable targetVariable : targetListLiteral.getTargetVariableListRecursive()) {
                AppleScriptComponentName componentName = targetVariable.getComponentName();
                if (componentName!=null) {//todo to check
                    result.add(componentName);
                }
            }
            return result;
        }
        AppleScriptTargetRecordLiteral targetRecordLiteral = creationStatement.getTargetRecordLiteral();
        if (targetRecordLiteral!=null) {
            for (AppleScriptTargetVariable targetVariable : targetRecordLiteral.getTargetVariableListRecursive()) {
                AppleScriptComponentName componentName = targetVariable.getComponentName();
                if (componentName!=null) {//todo to check
                    result.add(componentName);
                }
            }
            return result;
//            result.addAll(targetRecordLiteral.getComponentNameList());
//            return result;
        }
        return result;
    }

}
