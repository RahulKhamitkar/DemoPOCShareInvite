package com.rahul.demopoc.domain.usecase

import com.rahul.demopoc.data.mapper.toQCodeDetails
import com.rahul.demopoc.domain.datamodel.QRCodeDetailsModel
import com.rahul.demopoc.domain.repository.QRCodeRepository
import com.rahul.demopoc.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class QRCodeUseCase @Inject constructor(
    private val qrCodeRepository: QRCodeRepository
) {

    operator fun invoke(): Flow<ResponseState<QRCodeDetailsModel>> = flow {
        try {
            emit(ResponseState.Loading())
            val qrCodeDetails = qrCodeRepository.getQRCodeDetails().toQCodeDetails()
            emit(ResponseState.Success(qrCodeDetails))

        } catch (e: retrofit2.HttpException) {
            emit(ResponseState.Error(e.localizedMessage ?: "Something Went Wrong"))
        } catch (e: IOException) {
            emit(ResponseState.Error(e.localizedMessage ?: "Something Went Wrong"))
        }
    }
}