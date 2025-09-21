import 'package:flutter/material.dart';

// Una clase simple para definir la estructura de cada pantalla en la barra de navegación
class ScreenItem {
  final String title;
  final IconData icon;

  ScreenItem(this.title, this.icon);
}

// La lista de nuestras pantallas, equivalente a la sealed class 'Screen'
final List<ScreenItem> screenItems = [
  ScreenItem("TextFields", Icons.edit),
  ScreenItem("Botones", Icons.play_arrow),
  ScreenItem("Selección", Icons.check_circle),
  ScreenItem("Listas", Icons.list),
  ScreenItem("Info", Icons.info),
];