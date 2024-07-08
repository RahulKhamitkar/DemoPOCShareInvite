package com.rahul.demopoc.data.dto


data class QRCodeDTO(
    val qrCodeLink: String? = "",
    val contentText: String? = "",
    val faqs: List<String>? = emptyList()
)

