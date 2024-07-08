package com.rahul.demopoc.data.repository

import com.rahul.demopoc.data.datasource.NetworkApi
import com.rahul.demopoc.data.dto.QRCodeDTO
import com.rahul.demopoc.domain.repository.QRCodeRepository
import javax.inject.Inject

class QRCodeRepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi
): QRCodeRepository {
    override suspend fun getQRCodeDetails(): QRCodeDTO {
      return networkApi.getQRCode()
    }
}