package me.danieo.engapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.ui.theme.SecondaryColor
import me.danieo.engapp.ui.theme.TextColor

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    altColors: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = if (altColors) SecondaryColor else PrimaryColor),
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = if (altColors) PrimaryColor else TextColor,
            text = text,
        )
    }
}
