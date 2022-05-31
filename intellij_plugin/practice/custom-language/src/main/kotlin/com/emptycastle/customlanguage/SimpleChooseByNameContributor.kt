package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.util.containers.toArray

class SimpleChooseByNameContributor: ChooseByNameContributor {

    override fun getNames(project: Project, includeNonProjectItems: Boolean): Array<String> {
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project)
        val names: MutableList<String> = mutableListOf<String>()
        for (property: SimpleProperty in properties) {
            val key: String? = property.key
            if (key != null && key.isNotEmpty()) {
                names.add(key)
            }
        }
        return names.toTypedArray()
    }

    override fun getItemsByName(
        name: String,
        pattern: String?,
        project: Project,
        includeNonProjectItems: Boolean
    ): Array<NavigationItem> {
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, name)
        return properties.map { it as NavigationItem }.toTypedArray()
    }
}