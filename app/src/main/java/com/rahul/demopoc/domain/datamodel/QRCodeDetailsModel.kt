package com.rahul.demopoc.domain.datamodel

data class QRCodeDetailsModel(
    val QRCode: String? = "",
    val contentString: String? = "",
    val faqs: List<String>? = null
)
