package com.rahul.demopoc.presentation.viewmodel

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.demopoc.domain.datamodel.ShareData
import com.rahul.demopoc.domain.usecase.ShareDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(
    private val shareDataUseCase: ShareDataUseCase
) :
    ViewModel() {

    private val _shareIntent = MutableLiveData<Intent>()
    val shareIntent: LiveData<Intent> get() = _shareIntent


    fun prepareShareIntent(message: String, url: String) {
        val data = ShareData(message, url)
        _shareIntent.value = shareDataUseCase.getShareIntent(data)
    }
}