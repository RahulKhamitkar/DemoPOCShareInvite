package com.rahul.demopoc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.demopoc.domain.usecase.QRCodeUseCase
import com.rahul.demopoc.presentation.stateholder.QRCodeStateHolder
import com.rahul.demopoc.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QRCodeViewModel @Inject constructor(
    private val qrCodeUseCase: QRCodeUseCase
) : ViewModel() {

    private val _qrCodeResponse = MutableStateFlow(QRCodeStateHolder())
    var qrCodeResponse = _qrCodeResponse.asStateFlow()

    init {
        getURL()
    }

    private fun getURL() = viewModelScope.launch(Dispatchers.IO) {
        qrCodeUseCase().collect {
            when (it) {
                is ResponseState.Loading -> {
                    _qrCodeResponse.value = QRCodeStateHolder(isLoading = true)
                }

                is ResponseState.Success -> {
                    _qrCodeResponse.value =
                        QRCodeStateHolder(qrCodeResponseURL = "https://www.qrstuff.com/images/default_qrcode.png")
                }

                is ResponseState.Error -> {
                    _qrCodeResponse.value =
                        QRCodeStateHolder(qrCodeResponseURL = "https://www.qrstuff.com/images/default_qrcode.png")
                /*Needs to revert the error part*/
//                    _qrCodeResponse.value = QRCodeStateHolder(errorMessage = "Error")
                }
            }
        }
    }

}