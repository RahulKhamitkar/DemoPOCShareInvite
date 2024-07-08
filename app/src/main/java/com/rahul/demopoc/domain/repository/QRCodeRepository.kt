package com.rahul.demopoc.domain.repository

import com.rahul.demopoc.data.dto.QRCodeDTO

interface QRCodeRepository {
    suspend fun getQRCodeDetails(): QRCodeDTO
}