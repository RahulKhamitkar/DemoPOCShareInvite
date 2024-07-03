package com.rahul.demopoc.data.repository

import android.content.Intent
import com.rahul.demopoc.domain.datamodel.ShareData
import com.rahul.demopoc.domain.usecase.ShareDataUseCase

class ShareDataRepositoryImpl : ShareDataUseCase {
    override fun getShareIntent(data: ShareData): Intent {
        return Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_SUBJECT,"Lloyds Banking Share Invite")
            putExtra(Intent.EXTRA_TEXT, "Lloyds Banking Share Invite"+"\n\n"+data.message + data.url)
            type = "text/plain"
        }
    }
}