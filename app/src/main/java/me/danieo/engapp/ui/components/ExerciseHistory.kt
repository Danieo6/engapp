package me.danieo.engapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import me.danieo.engapp.game.Game
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.ui.theme.SecondaryColor

@Composable
fun ExerciseHistory(game: Game) {
    val exerciseStates = game.quizExercises.map { exercise -> exercise.isCorrect }
    val screenWidth = LocalConfiguration.current.screenWidthDp - 100
    val factor = LocalConfiguration.current.densityDpi / 160
    val circleRadius = 24.dp.value
    val offset = (screenWidth - (circleRadius * exerciseStates.size)) / exerciseStates.size

    Canvas(
        modifier = Modifier.fillMaxWidth().height(32.dp)
    ) {
        for ((i, exerciseState) in exerciseStates.withIndex()) {
            if (game.currentTask == i) {
                drawCircle(
                    color = PrimaryColor,
                    radius = circleRadius + 2,
                    center = Offset(((circleRadius * 2 + offset) * i) * factor , 0f),
                )
                drawCircle(
                    color = SecondaryColor,
                    radius = circleRadius,
                    center = Offset(((circleRadius * 2 + offset) * i) * factor , 0f),
                )
            } else {
                drawCircle(
                    color =
                    if (exerciseState == true)
                        PrimaryColor
                    else if (exerciseState == false)
                        Color(0xFFA52727)
                    else
                        SecondaryColor
                    ,
                    radius = circleRadius,
                    center = Offset(((circleRadius * 2 + offset) * i) * factor , 0f),
                )
            }
        }
    }
}
