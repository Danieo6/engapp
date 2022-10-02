package me.danieo.engapp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.R
import me.danieo.engapp.Services
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.components.TitleBar
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.ui.theme.SecondaryColor
import me.danieo.engapp.ui.theme.TextColor
import me.danieo.engapp.user.UserService

@Composable
fun LevelButton(text: String, selectedLevel: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
        .size(
            width = 60.dp,
            height = 52.dp,
        )
        .padding(horizontal = 4.dp)
        .border(
            1.dp,
            if (text == selectedLevel) PrimaryColor else SecondaryColor,
            RoundedCornerShape(12.dp),
        ),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = SecondaryColor,
            contentColor = if (text == selectedLevel) PrimaryColor else TextColor,
        ),
        onClick = onClick,
    ) {
        Text(text)
    }
}

@Composable
fun SettingsScreen(navController: NavController, userService: UserService) {
    val nameField = remember { mutableStateOf(TextFieldValue()) }
    val selectedLevel = remember { mutableStateOf("A1") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        TitleBar(textId = R.string.settingsscreen_title)

        Column {
            Column {
                Text(
                    text = stringResource(id = R.string.settingsscreen_name_field),
                    fontWeight = FontWeight.Bold,
                )
                OutlinedTextField(
                    value = nameField.value,
                    onValueChange = { nameField.value = it },
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = SecondaryColor,
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor = PrimaryColor,
                    ),
                )
            }
            Column(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.settingsscreen_name_language_level),
                    fontWeight = FontWeight.Bold,
                )
                Row(
                    modifier = Modifier.padding(8.dp),
                ) {
                    LevelButton(
                        text = "A1",
                        selectedLevel = selectedLevel.value,
                        onClick = { selectedLevel.value = "A1" },
                    )
                    LevelButton(
                        text = "A2",
                        selectedLevel = selectedLevel.value,
                        onClick = { selectedLevel.value = "A2" },
                    )
                    LevelButton(
                        text = "B1",
                        selectedLevel = selectedLevel.value,
                        onClick = { selectedLevel.value = "B1" },
                    )
                }
            }
        }

        CustomButton(
            textResourceId = R.string.settingsscreen_reset_profile,
            onClick = {
                userService.deleteUserProfile()
            },
        )

        CustomButton(
            textResourceId = R.string.settingsscreen_save,
            onClick = {
                userService.saveSettings(nameField.value.text, selectedLevel.value)
                navController.navigate(Screen.HomeScreen.route)
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    MyAppPreview {
        val services = Services(LocalContext.current)
        SettingsScreen(rememberNavController(), services.userService)
    }
}
