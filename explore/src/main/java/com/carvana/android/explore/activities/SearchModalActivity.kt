package com.carvana.android.explore.activities

import android.content.Context
import android.content.Intent
import com.carvana.android.common.bases.AppBaseModalActivity
import com.carvana.android.explore.R

/**
 * Defines the Explore Search Feature as a modal flow
 */
class SearchModalActivity : AppBaseModalActivity() {

    override fun getModalNavGraph(): Int = R.navigation.search_modal_nav_graph

    companion object {

        /**
         * Generates a launch intent to [SearchModalActivity]
         */
        fun getLaunchIntent(context: Context) = Intent(context, SearchModalActivity::class.java)
    }

}