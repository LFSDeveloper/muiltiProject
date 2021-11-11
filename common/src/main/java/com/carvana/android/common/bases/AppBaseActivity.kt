package com.carvana.android.common.bases

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

abstract class AppBaseActivity: AppCompatActivity() {

    /**
     * Provides access to the app navController to all children.
     * Note: Fragments can access this thru this activity
     */
    abstract val navController: NavController?
}