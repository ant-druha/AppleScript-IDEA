package com.idea.plugin.applescript.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 21.04.2015. <p/>
 *
 * Represents PSI element which is a definition/declaration
 */
public interface AppleScriptComponent extends AppleScriptNamedElement, PsiNameIdentifierOwner {

  /**
     * todo is it really needed ?
     * @return true if this is a scriptObject property
     */
    boolean isScriptProperty();

    /**
     * @return true if handler declaration
     */
    boolean isHandler();

    /**
     * @return original declaration of this element. For example variable which was declared as a property but later
     * used in a set statement
     * todo check NameDefiner interface in python plugin - looks like similar thing
     */
    @Nullable
    PsiElement getOriginalDeclaration();

    /**
     * @return true if this is a valueObject property (AppleScript record or application object property)
     */
    boolean isObjectProperty();

  /**
     *
     * @return if this target component is a single variable (not a list or record of variables)<p/>
     * this could be local or global variable declaration or single variable in creation statement
     */
    boolean isVariable();

    /**
     * todo to check com.jetbrains.python.psi.PyAssignmentStatement#getTargetsToValuesMapping
     * todo and com.jetbrains.python.psi.impl.PyTargetExpressionImpl#findAssignedValue
     *
     * @return value expression (if any) this component holds
     */
    @Nullable
    AppleScriptExpression findAssignedValue();

    @Nullable
    @Override
    ItemPresentation getPresentation();
}
