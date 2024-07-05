package com.rahul.demopoc.data.repository

import android.content.Intent
import com.rahul.demopoc.domain.datamodel.ShareData
import com.rahul.demopoc.domain.usecase.ShareDataUseCase

class ShareDataRepositoryImpl : ShareDataUseCase {
    override fun getShareIntent(data: ShareData): Intent {
        return Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, data.message + data.url)
            putExtra(Intent.EXTRA_TITLE,"Lloyds Banking Share Invite")
            type = "text/plain"
        }
    }
}