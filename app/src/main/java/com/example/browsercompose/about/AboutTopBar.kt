package com.example.browsercompose.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.browsercompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutTopBar(
    onCloseClicked: () -> Unit
) {

    Column() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.about_screen_title),
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    shape = AbsoluteRoundedCornerShape(8.dp),
                    onClick = {
                        onCloseClicked()
                    }
                )
                {
                    Text(
                        text = stringResource(id = R.string.about_screen_top_bat_action),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
    }

}