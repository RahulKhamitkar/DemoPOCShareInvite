package com.rahul.demopoc.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.rahul.demopoc.R
import com.rahul.demopoc.presentation.viewmodel.QRCodeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRCodeScreen(
    viewModel: QRCodeViewModel = hiltViewModel(),
    scope: CoroutineScope,
    sheetState: SheetState,
    onCloseClick: () -> Unit
) {
    val result by viewModel.qrCodeResponse.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
            .wrapContentSize(align = Alignment.BottomCenter),
        verticalArrangement = Arrangement.Bottom,

        ) {

        TitleWithIcon() {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                onCloseClick()
            }
        }

        Divider(
            modifier = Modifier.padding(top = 15.dp)
        )

        Text(
            text = "Scan this QR Code",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 15.dp),
            style = TextStyle(
                fontSize = 25.sp
            )
        )
        QRCodeWithText(result.qrCodeResponseURL)
        FAQ()
    }
}

@Composable
fun TitleWithIcon(onClose: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            val imageModifier = Modifier
                .size(40.dp)
            Image(
                painter = painterResource(id = R.drawable.lloyds_icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )

            Text(
                text = "Scan QR Code",
                modifier = Modifier
                    .padding(start = 14.dp, top = 5.dp)
                    .testTag("ScanQRCode"),
                color = Color.Black
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_close_24),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    onClose()
                },
            alignment = Alignment.TopEnd,

            )
    }
}

@Composable
fun QRCodeWithText(qrCodeResponseURL: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = qrCodeResponseURL,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_downloading),
            error = painterResource(id = R.drawable.ic_error),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .testTag("QRCodeImage"),
            contentScale = ContentScale.Inside
        )
        val smallScreenAdaptedParagraph =
            LineBreak.Paragraph.copy(strategy = LineBreak.Strategy.Simple)

        Text(
            text = stringResource(id = R.string.scan_text),
            modifier = Modifier
                .padding(4.dp)
                .testTag("textContent"),
            style = TextStyle.Default.copy(
                lineBreak = smallScreenAdaptedParagraph
            )
        )
    }
}

@Composable
fun FAQ() {
    Divider(
        modifier = Modifier.padding(top = 20.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "FAQs")
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_down_24),
            contentDescription = null
        )
    }
    Divider()
}
