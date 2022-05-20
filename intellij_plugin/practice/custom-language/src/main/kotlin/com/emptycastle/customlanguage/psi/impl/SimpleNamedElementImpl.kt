package com.emptycastle.customlanguage.psi.impl

import com.emptycastle.customlanguage.psi.SimpleNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class SimpleNamedElementImpl(node: ASTNode): ASTWrapperPsiElement(node), SimpleNamedElement