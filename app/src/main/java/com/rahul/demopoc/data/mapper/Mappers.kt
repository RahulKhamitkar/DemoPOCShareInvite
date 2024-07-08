package com.rahul.demopoc.data.mapper

import com.rahul.demopoc.data.dto.QRCodeDTO
import com.rahul.demopoc.domain.datamodel.QRCodeDetailsModel

fun QRCodeDTO.toQCodeDetails() = QRCodeDetailsModel(
    QRCode = this.qrCodeLink,
    contentString = this.contentText,
    faqs = this.faqs
)