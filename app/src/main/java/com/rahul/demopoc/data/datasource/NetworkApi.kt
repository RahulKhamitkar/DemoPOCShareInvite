package com.rahul.demopoc.data.datasource
import com.rahul.demopoc.data.dto.QRCodeDTO
import retrofit2.http.GET
interface NetworkApi {

    @GET("/")
        suspend fun getQRCode(): QRCodeDTO
}