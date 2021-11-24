package com.carvana.android.myapplication.publicIn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.common.R
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.common.utils.dsl.appComponent
import com.carvana.android.myapplication.di.mainAppModule
import com.carvana.android.myapplication.di.networkSpecModule
import com.carvana.android.myapplication.di.viewModelModule

class MainAppInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = appComponent {
        id = R.id.MainApp_id
        type = AppComponent.MainApp
        objectGraph = listOf(viewModelModule, mainAppModule, networkSpecModule)
    }

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? = null
}