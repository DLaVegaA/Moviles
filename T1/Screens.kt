package com.example.p1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Pantalla 1: TextFields
@Composable
fun TextFieldsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("TextFields", style = MaterialTheme.typography.headlineMedium)
        Text("Es un componente de interfaz de usuario que permite a los usuarios escribir y editar texto. " +
                "Es el elemento fundamental para crear formularios, barras de búsqueda, campos de inicio de sesión o cualquier lugar donde se necesite que el usuario ingrese información.")
        Spacer(modifier = Modifier.height(16.dp))
        var text by remember { mutableStateOf("") }
        OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Escribe algo...(OutlinedTextField)") })

        Spacer(modifier = Modifier.height(16.dp))
        var text2 by remember { mutableStateOf("") }
        TextField(value = text2, onValueChange = { text2 = it }, label = { Text("Escribe algo...(TextField)") })

        Spacer(modifier = Modifier.height(16.dp))
        var text3 by remember { mutableStateOf("") }
        Box(
            modifier = Modifier.background(Color.LightGray, RoundedCornerShape(8.dp))
                .padding(12.dp)
        ) {
            BasicTextField(
                value = text3,
                onValueChange = { text3 = it }
            )

            if (text3.isEmpty()) {
                Text("Escribe algo...(BasicTextField)")
            }
        }
    }
}

// Pantalla 2: Botones
@Composable
fun ButtonsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Botones", style = MaterialTheme.typography.headlineMedium)
        Text("Son componentes de interfaz de usuario que permiten a los usuarios interactuar con la aplicación. " +
                "Son uno de los elementos más importantes ya que permiten la interacción en cualquier apliación.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Acción */ }) {
            Text("Soy un Botón Normal")
        }

        Spacer(modifier = Modifier.height(16.dp))
        IconButton(onClick = { /* Acción */ }) {
            Icon(Icons.Default.FavoriteBorder, contentDescription = "Botón de Ícono")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { /* Acción */ }) {
            Text("Soy un Botón de Texto")
        }
    }
}

// Pantalla 3: Elementos de Selección
@Composable
fun SelectionScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Elementos de Selección", style = MaterialTheme.typography.headlineMedium)
        Text("Son componentes que permiten a los usuarios elegir una o más opciones de un conjunto." +
                "Son esenciales para configuraciones, filtros o cualquier formulario donde el usuario deba tomar decisiones.")
        Spacer(modifier = Modifier.height(16.dp))
        var isChecked by remember { mutableStateOf(false) }
        var isSwitched by remember { mutableStateOf(false) }
        var radioOptions = listOf("Opción 1", "Opción 2", "Opción 3")
        var selectedOption by remember { mutableStateOf(radioOptions[0]) }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
            Text("Checkbox")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = isSwitched, onCheckedChange = { isSwitched = it })
            Text("Switch")
        }

        Text("Elige una opción:")
        radioOptions.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { selectedOption = option }
                )
                Text(option)
            }
        }
    }
}

// Pantalla 4: Listas
@Composable
fun ListsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Listas (LazyColumn)", style = MaterialTheme.typography.headlineMedium)
        Text("Son la forma de mostrar conjuntos de datos que se pueden desplazar vertical u horizontalmente.")

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(4) { index ->
                Text("Elemento de la lista (LazyColumn) #$index", modifier = Modifier.padding(16.dp))
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(4) { index ->
                Text("Elemento de la lista (LazyRow) #$index", modifier = Modifier.padding(16.dp))
                Divider()
            }
        }
    }
}

// Pantalla 5: Elementos de Información
@Composable
fun InfoScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Elementos de Información", style = MaterialTheme.typography.headlineMedium)
        Text("Son componentes de la interfaz que le presentan datos al usuario. " +
                "A diferenciaa de los botones o los campos de texto, no son interactivos." +
                "Algunos ejemplos son: Text(Como esta información), Icon y CircularProgressIndicator.")

        Spacer(modifier = Modifier.height(16.dp))
        Icon(Icons.Default.Home, contentDescription = "Ícono de ejemplo")

        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator()
    }
}