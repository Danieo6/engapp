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
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.MyAppPreview

@Composable
fun QuizExerciseScreen(navController: NavController) {
    val questionWord = "MY WORD"
    val words = listOf("WORD A", "WORD B", "WORD C", "WORD D")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.quiz_exercise_screen_instruction),
                textAlign = TextAlign.Center,
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = questionWord.uppercase(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
        Column {
            for (word in words) {
                CustomButton(
                    modifier = Modifier.padding(top = 16.dp),
                    text = word.uppercase(),
                    onClick = { /*TODO*/ }
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
        QuizExerciseScreen(rememberNavController())
    }
}
