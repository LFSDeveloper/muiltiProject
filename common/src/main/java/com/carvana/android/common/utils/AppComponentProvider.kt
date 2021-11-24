package com.carvana.android.common.utils

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppFeature
import org.koin.core.Koin
import java.util.*

/**
 * Defines the App Component provider
 */
object AppComponentProvider {

    /**
     * Holds all the app components public interfaces
     *
     * Note: This does not mean components are inflated/loaded
     */
    private var compPublicFaces: Set<AppCompPublicFace> = setOf()
        private set

    /**
     * Pre-computed field that returns the components that participate as app main
     * entry points
     */
    val mainEntryCompPublicFaces: List<AppCompPublicFace>
        get() = compPublicFaces.filter { it.getInfo().isMainAppEntry }.sortedBy {
            it.getInfo().mainEntry?.order
        }

    /**
     * Computed field that returns the app home component
     */
    private val homeCompPublicFace: AppCompPublicFace
        get() = mainEntryCompPublicFaces.find { it.getInfo().mainEntry?.home == true }
            ?: throw IllegalStateException("There is no home app component")

    /**
     * Computed field that returns all the mandatory components
     * Mandatory: Will be always in memory
     */
    private val mandatoryComponent: List<AppComponent>
        get() = mainEntryCompPublicFaces.mapNotNull { it.getInfo().type } + AppComponent.MainApp

    /**
     * Holds all the loaded components into memory based on a navigation principle
     */
    private val componentStack: Stack<AppComponent> = Stack()

    /**
     * Loads a component into memory from an object graph perspective following
     *
     * a. if component not in stack, do full load and push it into stack
     * b. if component is in stack then remove any component above it
     *
     * @param koin entity to load [component] into
     * @param component to be loaded
     */
    fun loadComponent(koin: Koin, component: AppComponent) {
        loadPublicFaces(koin)

        val isStackEmpty = componentStack.isEmpty()

        when {
            // if true. Component is mandatory and is already loaded
            component in mandatoryComponent && !isStackEmpty -> clearStack(koin)

            // if true. Component is mandatory and needs to be loaded
            component in mandatoryComponent && isStackEmpty -> loadMandatoryComp(koin)

            // if true. Component is at stack top. Do nothing
            !isStackEmpty && componentStack.peek() == component -> return

            // if true, component is already added so clear stack above it
            !isStackEmpty && componentStack.contains(component) -> removeComponentAbove(
                koin, component
            )

            // if true, component can be fully added into stack
            else -> addNewComponent(koin, component)
        }
    }

    fun loadComponent(koin: Koin, feature: AppFeature) {
        val component = compPublicFaces.find {
            feature in it.getInfo().type?.features ?: listOf()
        }?.getInfo()?.type

        component?.let { loadComponent(koin, it) }
    }

    /**
     * Clears the [componentStack] leaving [mandatoryComponent] in it
     */
    private fun clearStack(koin: Koin) {
        // predicate pointing to component to be remove from stack
        val predicate: (AppComponent) -> Boolean = { it !in mandatoryComponent }

        // hold all component that will be removed
        val compToRemove = componentStack.filter(predicate)

        // get objectGraph of all component to remove
        val objectGraphs = compPublicFaces.filter { it.getInfo().type in compToRemove }.map {
            it.getInfo().objectGraph
        }.flatten()

        // unLoad object graphs from koin
        koin.unloadModules(objectGraphs)

        // remove components from stack
        componentStack.removeAll(predicate)
    }

    /**
     * Loads all [mandatoryComponent] into [componentStack]
     */
    private fun loadMandatoryComp(koin: Koin) {
        // mandatory components object graphs
        val objectGraphs = compPublicFaces.filter { it.getInfo().type in mandatoryComponent }.map {
            it.getInfo().objectGraph
        }.flatten()

        // load mandatory components object graphs into koin
        koin.loadModules(objectGraphs)

        // add mandatory components into stack. No need to follow any specific order
        componentStack.addAll(mandatoryComponent)
    }

    /**
     * Removes all component above [component] in stack
     */
    private fun removeComponentAbove(koin: Koin, component: AppComponent) {
        val compIndex = componentStack.indexOf(component)
        if (compIndex != -1) {
            // component to be remove above component index
            val compToRemove = componentStack.subList(compIndex + 1, componentStack.size)

            // object graphs of components to remove
            val objectGraphs = compPublicFaces.filter { it.getInfo().type in compToRemove }.map {
                it.getInfo().objectGraph
            }.flatten()

            // remove object graphs from koin
            koin.unloadModules(objectGraphs)

            // remove components from stack
            componentStack.removeAll(compToRemove)
        }
    }

    /**
     * Adds a new component into stack
     */
    private fun addNewComponent(koin: Koin, component: AppComponent) {
        val objectGraph = compPublicFaces.find {
            it.getInfo().type == component
        }?.getInfo()?.objectGraph

        objectGraph?.let { koin.loadModules(it) }

        componentStack.push(component)
    }

    /**
     * Try load all component public faces (Presentation cards)
     */
    private fun loadPublicFaces(koin: Koin) {
        if (compPublicFaces.isEmpty()) {
            // get all app components presentation cards throughout koin
            val appCompPubFaces: List<AppCompPublicFace> = koin.getAll()
            compPublicFaces = appCompPubFaces.toSet()
        }
    }

    /**
     * Returns a component public face based on a [feature] that it owns if component is already
     * loaded
     */
    fun getComponentFace(feature: AppFeature): AppCompPublicFace? {
        // gets a loaded component if not return null
        val componentType = componentStack.find { feature in it.features } ?: return null

        return compPublicFaces.find { it.getInfo().type == componentType }
    }
}