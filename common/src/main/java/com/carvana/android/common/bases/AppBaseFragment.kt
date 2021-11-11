package com.carvana.android.common.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.carvana.android.common.R
import com.carvana.android.common.models.ScreenInfo

abstract class AppBaseFragment : Fragment() {

    /**
     * Describe an instance of [AppBaseFragment]
     */
    abstract val screenInfo: ScreenInfo

    /**
     * Implemented by instance of [AppBaseFragment] to produce it's view
     */
    abstract fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    /**
     * Exposes the App navController down to all fragments
     */
    protected val navController: NavController?
        get() = (activity as? AppBaseActivity)?.navController

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val parentView = inflater.inflate(R.layout.fragment_app_base, container, false)
        val childView = generateView(inflater, container, savedInstanceState)

        val childHost = parentView.findViewById<FrameLayout>(R.id.child_fragment_container)
        childHost.addView(childView)

        return parentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        view?.findViewById<Toolbar>(R.id.app_tool_bar)?.apply {
            setTitle(screenInfo.title)

            if (!screenInfo.isTop) {
                setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
                setNavigationOnClickListener { navController?.popBackStack() }
            }
        }
    }
}