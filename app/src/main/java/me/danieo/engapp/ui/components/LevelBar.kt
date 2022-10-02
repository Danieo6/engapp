package me.danieo.engapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.danieo.engapp.R
import me.danieo.engapp.ui.theme.PrimaryColor

@Composable
fun LevelBar(level: Int, currentXp: Int, nextLevelXp: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.levelbar_level, level),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor,
        )
        LinearProgressIndicator(
            progress = currentXp.toFloat() / nextLevelXp.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .height(10.dp)
                .clip(CircleShape),
        )
    }
}
