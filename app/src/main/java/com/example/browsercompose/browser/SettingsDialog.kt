package com.example.browsercompose.browser

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.browsercompose.R

@Composable
fun SettingsDialog(
    modifier: Modifier = Modifier,
    onCancelClicked: () -> Unit,
    onAboutClicked: () -> Unit,
    onClearClicked: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable(enabled = false) {  }
    ) {
        Column {
            Divider(
                thickness = 2.dp,
                color = Color.Black
            )
            Text(
                text = stringResource(id = R.string.settings_dialog_title),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = AbsoluteRoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black),
                onClick = {
                    onClearClicked()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.settings_dialog_button1),
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = AbsoluteRoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black),
                onClick = {
                    onAboutClicked()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.settings_dialog_button2),
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = AbsoluteRoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black),
                onClick = {
                    onCancelClicked()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.settings_dialog_button3),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}