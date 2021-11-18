package com.carvana.android.explore.fragments.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carvana.android.explore.repositories.UserRepository
import kotlinx.coroutines.launch

class ExploreViewModel(
    private val userRepo: UserRepository
) : ViewModel() {

    fun onGetUserClicked() {
        viewModelScope.launch {
            userRepo.getUser()
        }
    }
}