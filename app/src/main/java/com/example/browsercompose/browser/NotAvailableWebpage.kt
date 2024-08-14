package com.example.browsercompose.browser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.browsercompose.R

@Composable
fun NotAvailableWebpage(
    modifier: Modifier = Modifier,
    pageName: String
) {
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.not_available_page_title),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.not_available_page_description, pageName),
            textAlign = TextAlign.Center,
            maxLines = 3
        )
    }
    
}