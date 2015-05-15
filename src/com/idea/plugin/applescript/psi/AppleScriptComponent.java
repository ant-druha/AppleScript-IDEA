package com.idea.plugin.applescript.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 21.04.2015. <p/>
 *
 * Represents base interface for the construct which is a target for variable assignment or any component declaration.
 * Can be variable declaration (global/local variable declaration), variable declaration and initialization (variable
 * in creation statement, property declaration), handler parameter declaration, handler declaration
 */
public interface AppleScriptComponent extends AppleScriptPsiElement, PsiNameIdentifierOwner {

    //todo create AppleScriptComponentType enum and methods to get the component type from class => easier to maintain
    /**
     *
     * @return true if variable defined as global or as a script property
     */
    boolean isGlobal();

    /**
     * todo if variable was earlier declared as a script property but theu used in a set statement -> is not detected as a
     * todo script property  !!! need to check the original element (need to resolve)
     * todo !!! is it really needed ??? !!! to think
     *
     * @return true if this is a scriptObject property
     */
    boolean isScriptProperty();

    /**
     * todo implement each handler as a component ! (currently not so with InterleavedParameters
     *
     * @return true if handler declaration
     */
    boolean isHandler();

    /**
     * @return original declaration of this element. For example variable which was declared as a property but later
     * used in a set statement
     */
    @Nullable
    PsiElement getOriginalDeclaration();

    /**
     * @return true if this is a valueObject property (AppleScript record or application object property)
     */
    boolean isObjectProperty();

    /**
     * Component which is a composite should be always ignored for resolve processing
     *
     * @return true if contains other components (like object property which holds target variable)
     */
    boolean isComposite();

    /**
     * @return whether this component should be picked up for resolve
     */
    boolean isResolveTarget();

    /**
     *
     * @return if this target component is a single variable (not a list or record of variables)<p/>
     * this could be local or global variable declaration or single variable in creation statement
     */
    boolean isVariable();

    @NotNull
    @Override
    GlobalSearchScope getResolveScope();

    @NotNull
    @Override
    SearchScope getUseScope();

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
    PsiElement getNameIdentifier();

    /**
     *
     * @return reference to declared earlier component with the same name or to self if no other components were found
     */
    @Nullable
    @Override
    PsiReference getReference();

    @NotNull
    @Override
    PsiReference[] getReferences();

    /**
     * This should be implemented by all classes implementing targetComponent
     * !!!this is not implemented in abstract component!!!
     *
     * @return componentName class of this element
     */
    @Nullable
    AppleScriptComponentName getComponentName();


    @Nullable
    @Override
    String getName();

    @Nullable
    @Override
    ItemPresentation getPresentation();
}
