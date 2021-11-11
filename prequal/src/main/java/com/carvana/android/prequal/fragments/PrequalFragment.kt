package com.carvana.android.prequal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carvana.android.prequal.R

/**
 * Represents the Prequal Component Landing Screen
 */
class PrequalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prequal, container, false)
        return view
    }
}