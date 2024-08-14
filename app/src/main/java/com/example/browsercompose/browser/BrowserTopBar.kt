package com.example.browsercompose.browser

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.browsercompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowserTopBar(
    isDialogOpened: Boolean,
    onSearchQuery: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSettingsClicked: () -> Unit
) {

    var url by remember { mutableStateOf("") }

    Column() {
        TopAppBar(
            title = {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = url,
                    textStyle = TextStyle(fontWeight = FontWeight.Bold),
                    onValueChange = {
                        url = it
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.browser_top_bar_title_hint))
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    maxLines = 1,
                    keyboardActions = KeyboardActions {
                        onSearchQuery(url)
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )
            },
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(20.dp)
                        .height(20.dp)
                        .clickable { if (!isDialogOpened) onCloseClicked() },
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null
                )
            },
            actions = {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { if (!isDialogOpened) onSettingsClicked() },
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null
                )
            }
        )
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
    }
}