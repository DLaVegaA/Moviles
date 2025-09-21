import 'package:flutter/material.dart';
import 'package:p1_flutter/screens.dart';    // Importamos nuestras pantallas
import 'package:p1_flutter/navigation.dart';
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        useMaterial3: true,
      ),
      home: const MainScreen(),
    );
  }
}

// Este es el Widget principal, equivalente a tu Composable `MainScreen`
class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  // Estado para recordar qué pantalla está seleccionada (inicia en la primera)
  int _selectedIndex = 0;

  // Lista de los Widgets de cada pantalla
  static const List<Widget> _widgetOptions = <Widget>[
    TextFieldsScreen(),
    ButtonsScreen(),
    SelectionScreen(),
    ListsScreen(),
    InfoScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // El cuerpo de la pantalla cambia según el índice seleccionado
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      // La barra de navegación inferior
      bottomNavigationBar: BottomNavigationBar(
        items: screenItems.map((item) {
          return BottomNavigationBarItem(
            icon: Icon(item.icon),
            label: item.title,
          );
        }).toList(),
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.blue,
        unselectedItemColor: Colors.grey, // Importante para ver los items no seleccionados
        onTap: _onItemTapped,
      ),
    );
  }
}