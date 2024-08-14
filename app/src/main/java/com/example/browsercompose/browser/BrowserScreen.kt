package com.example.browsercompose.browser

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowserScreen(
    viewModel: BrowserViewModel = hiltViewModel(),
    onAboutClicked: () -> Unit
) {

    val state = viewModel.state.collectAsState()
    val url = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            BrowserTopBar(
                onSearchQuery = {
                    url.value = "https://$it"
                    viewModel.initPageUrl("https://$it")
                },
                onCloseClicked = {

                },
                onSettingsClicked = {
                    viewModel.changeSettingsDialogMode()
                },
                isDialogOpened = state.value.isDialogOpened
            )
        }
    ) {
        Box() {
            if (state.value.isAvailable) {
                AndroidView(
                    modifier = Modifier.padding(it),
                    factory = { context ->
                        WebView(context).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                            webViewClient = WebViewClient()
                            settings.javaScriptEnabled = true
                        }
                    },
                    update = { webView ->
                        webView.loadUrl(url.value)
                    }
                )
            } else {
                NotAvailableWebpage(
                    modifier = Modifier.padding(it),
                    pageName = url.value
                )
            }

            if (state.value.isSettingsDialogMode) {
                SettingsDialog(
                    modifier = Modifier
                        .padding(it)
                        .align(Alignment.BottomCenter),
                    onCancelClicked = {
                        viewModel.changeSettingsDialogMode()
                    },
                    onAboutClicked = {
                        onAboutClicked()
                    },
                    onClearClicked = {
                        viewModel.clearCache(context)
                    }
                )
            }
        }
    }
}