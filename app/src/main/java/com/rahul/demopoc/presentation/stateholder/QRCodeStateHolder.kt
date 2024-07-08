package com.rahul.demopoc.presentation.stateholder

import com.rahul.demopoc.domain.datamodel.QRCodeDetailsModel

data class QRCodeStateHolder(
    var isLoading: Boolean = false,
    var qrCodeResponseURL: String? = "",
    var errorMessage: String = ""
)
