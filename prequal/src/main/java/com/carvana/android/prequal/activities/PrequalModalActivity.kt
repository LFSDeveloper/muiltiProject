package com.carvana.android.prequal.activities

import android.content.Context
import android.content.Intent
import com.carvana.android.common.bases.AppBaseModalActivity
import com.carvana.android.prequal.R

/**
 * Define the prequal modal flow
 */
class PrequalModalActivity : AppBaseModalActivity() {

    override fun getModalNavGraph(): Int = R.navigation.prequal_nav_graph

    companion object {

        /**
         * Produces a launching intent targeting this [PrequalModalActivity]
         */
        fun getIntent(context: Context) = Intent(context, PrequalModalActivity::class.java)
    }
}