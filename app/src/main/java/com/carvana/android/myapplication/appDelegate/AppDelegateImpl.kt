package com.carvana.android.myapplication.appDelegate

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.common.models.AppFeature
import com.carvana.android.myapplication.utils.AppComponentProvider
import org.koin.core.Koin

/**
 * [AppDelegate] implementer
 */
class AppDelegateImpl(
    private val koin: Koin,
    private val context: Context
) : AppDelegate {

    private val mainAppFlow = MutableLiveData(AppFeature.ExploreHome)

    override val mainAppNavFlow: LiveData<AppFeature>
        get() = mainAppFlow

    override fun navigateTo(feature: AppFeature) {
        // type of component owning feature
        val componentType = AppComponentProvider.compPublicFaces.map {
            it.getDetails().type
        }.find { component ->
            feature in component.features
        }

        // tell if the component type belongs to one of the main entry components
        val isCompMainEntry = componentType in AppComponentProvider.mainEntryCompPublicFaces.map {
            it.getDetails().type
        }

        when (isCompMainEntry) {
            // if true, delegate to main app component
            true -> mainAppFlow.value = feature

            // if true, delegate navigation to component
            false -> {
                val componentPubFace = componentType?.let {
                    AppComponentProvider.getOrInflateComp(it, koin)
                }
                componentPubFace?.navigateTo(feature)
            }
        }
    }
}