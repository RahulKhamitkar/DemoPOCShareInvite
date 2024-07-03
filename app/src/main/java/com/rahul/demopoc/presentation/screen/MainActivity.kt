package com.rahul.demopoc.presentation.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rahul.demopoc.presentation.viewmodel.ShareViewModel
import com.rahul.demopoc.ui.theme.DemoPOCTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.res.stringResource
import com.rahul.demopoc.R

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ShareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoPOCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShareScreen(viewModel)
                }
            }
        }

        viewModel.shareIntent.observe(this) { intent ->
            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }
}

@Composable
fun ShareScreen(viewModel: ShareViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val inviteText = stringResource(id = R.string.invite_text)
        val url = stringResource(id = R.string.invite_url)
        Button(onClick = { viewModel.prepareShareIntent(inviteText, url) }) {
            Text("Share the Invite")
        }
    }
}
