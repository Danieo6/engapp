package me.danieo.engapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.R
import me.danieo.engapp.Services
import me.danieo.engapp.game.GameService
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.ExerciseHistory
import me.danieo.engapp.ui.components.MyAppPreview
import kotlin.random.Random

@Composable
fun QuizExerciseScreen(navController: NavController, gameService: GameService) {
    val game = gameService.getCurrentGame()
    var currentTask = game.currentTask

    if (game.currentTask >= game.quizExercises.size) {
        currentTask = game.quizExercises.size - 1
    }

    val exercise = game.quizExercises[currentTask]
    val englishToPolishMode = game.exerciseDirection[currentTask]

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            ExerciseHistory(game)
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.quiz_exercise_screen_instruction),
                textAlign = TextAlign.Center,
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = (if (englishToPolishMode) exercise.questionWord.en else exercise.questionWord.pl).uppercase(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
        Column {
            for (word in exercise.answers) {
                CustomButton(
                    modifier = Modifier.padding(top = 16.dp),
                    text = (if (englishToPolishMode) word.pl else word.en).uppercase(),
                    onClick = {
                        val currentExerciseIndex = gameService.nextTask(word.en == exercise.questionWord.en)

                        if (currentExerciseIndex < 9) {
                            navController.navigate(Screen.QuizExerciseScreen.route)
                        } else {
                            navController.navigate(Screen.ResultsScreen.route)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizExerciseScreenPreview() {
    MyAppPreview {
        val services = Services(LocalContext.current)
        QuizExerciseScreen(rememberNavController(), services.gameService)
    }
}
