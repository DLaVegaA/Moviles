package com.example.p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.p1.ui.theme.P1Theme // Asegúrate que el nombre de tu tema sea correcto
import com.example.p1.TextFieldsScreen // O la ruta completa si está en un subpaquete
import com.example.p1.ButtonsScreen
import com.example.p1.SelectionScreen
import com.example.p1.ListsScreen
import com.example.p1.InfoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P1Theme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // 1. Lista de todas nuestras pantallas
    val screens = listOf(
        Screen.TextFields,
        Screen.Buttons,
        Screen.Selection,
        Screen.Lists,
        Screen.Info
    )

    // 2. Estado para recordar qué pantalla está seleccionada
    var currentScreen: Screen by remember { mutableStateOf(Screen.TextFields) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    NavigationBarItem(
                        label = { Text(screen.title) },
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        // 3. Marca como seleccionado si la ruta coincide con la pantalla actual
                        selected = currentScreen.route == screen.route,
                        // 4. Al hacer clic, actualiza el estado a la nueva pantalla
                        onClick = { currentScreen = screen }
                    )
                }
            }
        }
    ) { innerPadding ->
        // 5. El contenido principal de la pantalla
        Box(modifier = Modifier.padding(innerPadding)) {
            // Un `when` decide qué Composable de pantalla mostrar basado en el estado
            when (currentScreen) {
                Screen.TextFields -> TextFieldsScreen()
                Screen.Buttons -> ButtonsScreen()
                Screen.Selection -> SelectionScreen()
                Screen.Lists -> ListsScreen()
                Screen.Info -> InfoScreen()
            }
        }
    }
}