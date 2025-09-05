package com.example.p1

import androidx.compose.material.icons.Icons // Es bueno tenerlo para la estructura general
import androidx.compose.material.icons.automirrored.filled.List // Importación correcta para List auto-reflejado
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object TextFields : Screen("textfields", "TextFields", Icons.Filled.Edit)
    object Buttons : Screen("buttons", "Botones", Icons.Filled.PlayArrow)
    object Selection : Screen("selection", "Selección", Icons.Filled.CheckCircle)
    object Lists : Screen("lists", "Listas", Icons.AutoMirrored.Filled.List) // Uso correcto
    object Info : Screen("info", "Info", Icons.Filled.Info)
}
