package com.carvana.android.common.bases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carvana.android.common.models.AppNavEvent

/**
 * Defines the base application viewModels where global logic can be set to be shared
 */
abstract class AppBaseViewModel : ViewModel() {

    private val navEventHandler: MutableLiveData<AppNavEvent> = MutableLiveData()
//    val navEvent: Single
}


class AppLiveDataEvent<T : Any>(
    initValue: T? = null
) : MutableLiveData<T>() {

    init {
//        initValue?.let { value = it }
    }

    override fun setValue(value: T) {
        super.setValue(value)
    }


}
