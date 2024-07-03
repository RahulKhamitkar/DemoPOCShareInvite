package com.rahul.demopoc.domain.usecase

import android.content.Intent

import com.rahul.demopoc.domain.datamodel.ShareData

interface ShareDataUseCase {

    fun getShareIntent(data: ShareData): Intent
}