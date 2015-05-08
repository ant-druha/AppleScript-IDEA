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
 * Represents base interface for the construct which is a target for variable assignment. Can be variable declaration
 * (global/local variable declaration), variable declaration and initialization (variable in creation statement,
 * property declaration), handler parameter declaration
 */
public interface AppleScriptTargetComponent extends AppleScriptPsiElement , PsiNameIdentifierOwner
//        AppleScriptNamedElement
{

    //todo может и стоит добавить метоы isList, isRecord и переопределить их для листа и записи?
    //todo будет просто влженный targetComponent - обычный в листе - будут имплементироваться каждый своими
    //todo методами
    //todo + можно будет брать valueExpression у всего рекорда или листа
    //todo тогда анноторовать creation statement как targetComponent ?
    //todo а обрабатывать targetComponent уже можно будет какой где потребуется (для структуры или резолва)

    //todo кароч. аннотировать targetList/Record Component как targetComponent и они будут включать просто componentName,
    //todo а не targetComponentName конечным компонентом !

    // todo кажется, логичным сделать tragetList & targetRecord -> targetComponentName, только без имени и
    // todo без nameIdentifier (=null) так они не должны ни во что будут резолвиться и должны просто игнориться
    // todo но некоторые действия с компонетном как target можно будет делать (вынимать список componentName'ов и т.д.)

    /**
     *
     * @return true if variable defined as global or as a script property
     */
    boolean isGlobal();

    /**
     *
     * @return true if this is a property
     */
    boolean isProperty();

    /**
     *
     * @return if this target component is a single variable (not a list or record of variables)<p/>
     * this could be local or global variable declaration or single variable in creation statement
     */
    boolean isVariable();

//    /**
//     *
//     * @return if contains list of variables
//     */
//    boolean isVariableList();
//
//    /**
//     *
//     * @return if contains record of variables
//     */
//    boolean isVariableRecord();

    @NotNull
    @Override
    GlobalSearchScope getResolveScope();

    @NotNull
    @Override
    SearchScope getUseScope();

//    /**
//     *
//     * @return whether the property specifies the parent object <p/>
//     *
//     * todo where to define getParent() call for script object ??
//     */
//    boolean isParentProperty();

    /**
     *
     * @return value (if any) this component holds
     */
    @Nullable
    AppleScriptExpression getValueExpression();

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

//    /**
//     *
//     * @return list of component names this target component has (1 is minimum)
//     * todo: to think if this is a parent property or property with the built in class -> no componentName
//     */
//    @NotNull
//    List<AppleScriptComponentName> getComponentNameList();

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
