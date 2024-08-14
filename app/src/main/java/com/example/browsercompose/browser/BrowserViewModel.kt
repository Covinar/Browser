package com.example.browsercompose.browser

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject
import javax.net.ssl.HttpsURLConnection


@HiltViewModel
class BrowserViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun changeSettingsDialogMode() {
        _state.update {
            it.copy(isSettingsDialogMode = state.value.isSettingsDialogMode.not())
        }
    }

    fun initPageUrl(pageUrl: String) {
        isUrlAvailable()
        _state.update {
            it.copy(pageUrl = pageUrl)
        }
    }

    private fun isUrlAvailable() {
        _state.update {
            it.copy(isAvailable = true)
        }
        var code = 0
        viewModelScope.launch(Dispatchers.IO) {
            code = try {
                val url = URL(state.value.pageUrl)
                val connection = url.openConnection() as HttpsURLConnection
                connection.responseCode
            } catch (_: Exception) {
                400
            }
            val isAvailable = code in (200..300)
            withContext(Dispatchers.Main) {
                _state.update {
                    it.copy(isAvailable = isAvailable)
                }
            }
        }
    }

    fun clearCache(context: Context) {
        val dir = context.cacheDir
        if (dir != null && dir.isDirectory) {
            val files = dir.listFiles()
            for (file in files) {
                dir.deleteRecursively()
            }
            dir.deleteRecursively()
        } else if (dir != null && dir.isFile) {
            dir.delete()
        }
    }

    data class State(
        val isSettingsDialogMode: Boolean = false,
        val isNotAvailablePageMode: Boolean = false,
        val pageUrl: String = "https://google.com",
        val isAvailable: Boolean = false
    ) {
        val isDialogOpened: Boolean
            get() = isSettingsDialogMode
    }
}