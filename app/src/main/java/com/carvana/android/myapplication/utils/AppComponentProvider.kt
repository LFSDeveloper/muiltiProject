package com.carvana.android.myapplication.utils

import com.carvana.android.common.utils.AppCompPublicFace
import org.koin.core.Koin
import org.koin.core.module.Module
import java.lang.IllegalStateException

/**
 * Defines the App Component provider
 */
object AppComponentProvider {

    private val appModules: List<Module>
        get() = listOf()

    /**
     * Holds all the app components that are currently loaded in DI at minimum
     */
    private val loadedComponents: MutableSet<AppCompPublicFace> = mutableSetOf()

    /**
     * Holds all the app components public interfaces
     *
     * Note: This does not mean components are inflated/loaded
     */
    var appComponents: Set<AppCompPublicFace> = setOf()
        private set

    /**
     * Pre-computed field that returns the app components that participated as app main
     * entry points
     */
    val mainEntryComponents: List<AppCompPublicFace>
        get() = appComponents.filter { it.getDetails().mainEntryPoint != null }.sortedBy {
            it.getDetails().mainEntryPoint?.order
        }

    /**
     * Returns the app home component
     */
    val homeEntryComponent: AppCompPublicFace
        get() = mainEntryComponents.find { it.getDetails().mainEntryPoint?.home != null }
            ?: throw IllegalStateException("There is no home app component")

    /**
     * Inflates an specific component
     */
    fun inflateComponent(koin: Koin, component: AppCompPublicFace) {
        // load component into DI framework
        koin.loadModules(component.getDetails().objectGraph)

        // add loaded component into the ones loaded
        loadedComponents.add(component)
    }

    /**
     * Remove a loaded component from memory
     */
    fun removeComponent(koin: Koin, component: AppCompPublicFace) {
        // tells if intended component to remove is not main entry point
        val isNotEntryComp = component.getDetails().type !in mainEntryComponents.map {
            it.getDetails().type
        }

        // do the removal only if component is within set and not an entry point
        if (loadedComponents.contains(component) && isNotEntryComp) {
            koin.unloadModules(component.getDetails().objectGraph)
            loadedComponents.remove(component)
        }
    }

    /**
     * Inflate the app components that represent app main Entry Points
     */
    fun inflateMainEntries(koin: Koin) {
        // if appComponents is not empty do nothing (return)
        appComponents.takeIf { it.isEmpty() } ?: return

        // get all app components presentation cards thought koin
        val appComponentInterfaces: List<AppCompPublicFace> = koin.getAll()
        appComponents = appComponentInterfaces.toSet()

        // load main entry components object graphs into Koin
        mainEntryComponents.forEach {
            inflateComponent(koin, it)
        }

        // add app DI object graph
        koin.loadModules(appModules)
    }
}