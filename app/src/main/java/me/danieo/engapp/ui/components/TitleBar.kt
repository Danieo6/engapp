package me.danieo.engapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import me.danieo.engapp.ui.theme.PrimaryColor

@Composable
fun TitleBar(textId: Int) {
    Text(
        text = stringResource(id = textId),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = PrimaryColor,
    )
}
