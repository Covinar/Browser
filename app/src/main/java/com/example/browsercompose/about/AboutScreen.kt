package com.example.browsercompose.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.browsercompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    onCloseClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            AboutTopBar(
                onCloseClicked = {
                    onCloseClicked()
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(it)
                    .align(Alignment.Center),
                text = stringResource(id = R.string.mudita),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
    }

}