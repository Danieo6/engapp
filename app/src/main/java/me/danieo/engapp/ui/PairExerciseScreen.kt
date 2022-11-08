package me.danieo.engapp.ui

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.MyApp
import me.danieo.engapp.R
import me.danieo.engapp.Services
import me.danieo.engapp.game.GameService
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.ExerciseHistory
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.ui.theme.SecondaryColor
import me.danieo.engapp.ui.theme.TextColor

@Composable
fun PairExerciseScreen(navController: NavController, gameService: GameService) {
    gameService.startNew()
    val game = gameService.getCurrentGame()
    val wordPairs = listOf(
        Pair("Orange", "Pomarańcza"),
        Pair("Fridge", "Lodówka"),
        Pair("Dog", "Pies"),
        Pair("Car", "Samochód"),
    )
    val englishToPolishMode = true
    val firstSelected = remember { mutableStateOf("") }
    val secondSelected = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            ExerciseHistory(game)
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.pair_exercise_screen_instruction),
                textAlign = TextAlign.Center,
            )
        }
        Column {
            for (pair in wordPairs) {
                Row {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 12.dp)
                            .height(82.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (firstSelected.value == pair.first) PrimaryColor else SecondaryColor
                        ),
                        border = BorderStroke(1.dp, PrimaryColor),
                        onClick = {
                            firstSelected.value = pair.first
                        },
                    ) {
                        Text(
                            text = pair.first.uppercase(),
                            color = if (firstSelected.value == pair.first) TextColor else PrimaryColor,
                        )
                    }
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                            .height(82.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = if (secondSelected.value == pair.second) PrimaryColor else SecondaryColor
                        ),
                        border = BorderStroke(1.dp, PrimaryColor),
                        onClick = {
                            secondSelected.value = pair.second
                            println(secondSelected)
                        },
                    ) {
                        Text(
                            text = pair.second.uppercase(),
                            color = if (secondSelected.value == pair.second) TextColor else PrimaryColor,
                        )
                    }
                }
                Spacer(
                    modifier = Modifier.height(24.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier.size(1.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PairExercisePreview() {
    val services = Services(LocalContext.current)
    MyAppPreview {
        PairExerciseScreen(rememberNavController(), services.gameService)
    }
}
