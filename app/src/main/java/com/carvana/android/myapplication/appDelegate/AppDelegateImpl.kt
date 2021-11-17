package com.carvana.android.myapplication.appDelegate

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.common.bases.AppNavFeature
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppComponentProvider
import org.koin.core.Koin

/**
 * [AppDelegate] implementer
 */
class AppDelegateImpl(
    private val koin: Koin,
    private val context: Context
) : AppDelegate {

    private val mainAppFlow = MutableLiveData(AppNavFeature())

    override val mainAppNavFlow: LiveData<AppNavFeature>
        get() = mainAppFlow

    override fun navigateTo(feature: AppFeature, bundle: Bundle?) {
        // type of component owning feature
        val componentType = AppComponentProvider.compPublicFaces.map {
            it.getInfo().type
        }.find { component ->
            feature in component.features
        }

        when (feature.isPublic) {
            // if true, delegate to main app component the navigation
            true -> mainAppFlow.value = AppNavFeature(feature, bundle)

            // if true, delegate navigation to component
            false -> {
                val componentPubFace = componentType?.let {
                    AppComponentProvider.getOrInflateComp(it, koin)
                }
                componentPubFace?.navigateTo(feature, bundle)
            }
        }
    }
}
