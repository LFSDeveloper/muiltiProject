package com.carvana.android.myapplication.utils

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.myapplication.di.mainAppModules
import com.carvana.android.myapplication.di.viewModels
import org.koin.core.Koin
import org.koin.core.module.Module

/**
 * Defines the App Component provider
 */
object AppComponentProvider {

    private val appModules: List<Module>
        get() = listOf(viewModels, mainAppModules)

    /**
     * Holds all the app components that are currently loaded in DI at minimum
     */
    private val loadedComponents: MutableSet<AppCompPublicFace> = mutableSetOf()

    /**
     * Holds all the app components public interfaces
     *
     * Note: This does not mean components are inflated/loaded
     */
    var compPublicFaces: Set<AppCompPublicFace> = setOf()
        private set

    /**
     * Pre-computed field that returns the app components that participated as app main
     * entry points
     */
    val mainEntryCompPublicFaces: List<AppCompPublicFace>
        get() = compPublicFaces.filter { it.getInfo().isMainAppEntry }.sortedBy {
            it.getInfo().mainEntry?.order
        }

    /**
     * Returns the app home component
     */
    private val homeCompPublicFace: AppCompPublicFace
        get() = mainEntryCompPublicFaces.find { it.getInfo().mainEntry?.home == true }
            ?: throw IllegalStateException("There is no home app component")

    /**
     * Inflates an specific component
     */
    private fun inflateComponent(koin: Koin, component: AppCompPublicFace) {
        // load component into DI framework
        koin.loadModules(component.getInfo().objectGraph)

        // add loaded component into the ones loaded
        loadedComponents.add(component)
    }

    /**
     * Remove a loaded component from memory
     */
    fun removeComponent(koin: Koin, component: AppComponent) {
        val compPublicFace = loadedComponents.find { it.getInfo().type == component }

        // tells if intended component to remove is not main entry point
        val isNotEntryComp = compPublicFace?.getInfo()?.type !in mainEntryCompPublicFaces.map {
            it.getInfo().type
        }

        // do the removal only if component is within set and not an entry point
        if (loadedComponents.contains(compPublicFace) && isNotEntryComp) {
            compPublicFace?.getInfo()?.objectGraph?.let { koin.unloadModules(it) }
            loadedComponents.remove(compPublicFace)
        }
    }

    /**
     * Inflate the app components that represent app main Entry Points
     */
    fun inflateMainEntries(koin: Koin) {
        // if appComponents is not empty do nothing (return)
        compPublicFaces.takeIf { it.isEmpty() } ?: return

        // get all app components presentation cards thought koin
        val appCompPubFaces: List<AppCompPublicFace> = koin.getAll()
        compPublicFaces = appCompPubFaces.toSet()

        // load main entry components object graphs into Koin
        mainEntryCompPublicFaces.forEach {
            inflateComponent(koin, it)
        }

        // add app DI object graph
        koin.loadModules(appModules)
    }

    /**
     * Returns a component information only after it gets inflates if is not
     *
     * @param type of component from where info is need it
     * @param koin instance where component [type] object graph will be inflated
     *
     * @return the component [type] public Interface
     */
    fun getOrInflateComp(type: AppComponent, koin: Koin): AppCompPublicFace {
        val compPublicFace = compPublicFaces.find { it.getInfo().type == type }
            ?: throw IllegalStateException("Component $type is missing a Public Face")

        return when {
            loadedComponents.contains(compPublicFace) -> compPublicFace

            else -> {
                koin.loadModules(compPublicFace.getInfo().objectGraph)
                loadedComponents.add(compPublicFace)
                compPublicFace
            }
        }
    }

}