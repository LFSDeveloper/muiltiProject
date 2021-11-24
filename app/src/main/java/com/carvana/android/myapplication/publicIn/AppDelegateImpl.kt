package com.carvana.android.myapplication.publicIn

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
        // load component
        AppComponentProvider.loadComponent(koin, feature)

        when (feature.isPublic) {
            // if true, delegate to main app component the navigation
            true -> mainAppFlow.value = AppNavFeature(feature, bundle)

            // if true, delegate navigation to component
            false -> {
                val componentFace = AppComponentProvider.getComponentFace(feature)
                componentFace?.navigateTo(feature, bundle)
            }
        }
    }
}
