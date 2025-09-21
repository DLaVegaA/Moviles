import 'package:flutter/material.dart';

// --- Pantalla 1: TextFields ---
class TextFieldsScreen extends StatefulWidget {
  const TextFieldsScreen({super.key});

  @override
  State<TextFieldsScreen> createState() => _TextFieldsScreenState();
}

class _TextFieldsScreenState extends State<TextFieldsScreen> {
  final TextEditingController _outlinedController = TextEditingController();
  final TextEditingController _filledController = TextEditingController();
  final TextEditingController _basicController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("TextFields", style: Theme.of(context).textTheme.headlineMedium),
          const Text("Es un componente de interfaz de usuario que permite a los usuarios escribir y editar texto."),
          const SizedBox(height: 16),
          TextField(
            controller: _outlinedController,
            decoration: const InputDecoration(
              labelText: "Escribe algo... (Outlined)",
              border: OutlineInputBorder(),
            ),
          ),
          const SizedBox(height: 16),
          TextField(
            controller: _filledController,
            decoration: const InputDecoration(
              labelText: "Escribe algo... (Filled)",
              border: UnderlineInputBorder(),
            ),
          ),
          const SizedBox(height: 16),
          Container(
            padding: const EdgeInsets.all(12.0),
            color: Colors.grey[200],
            child: TextField(
              controller: _basicController,
              decoration: const InputDecoration.collapsed(
                hintText: "Escribe algo... (Basic)",
              ),
            ),
          ),
        ],
      ),
    );
  }
}

// --- Pantalla 2: Botones ---
class ButtonsScreen extends StatelessWidget {
  const ButtonsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("Botones", style: Theme.of(context).textTheme.headlineMedium),
          const Text("Son componentes que permiten interactuar con la aplicación."),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: () {},
            child: const Text("Soy un Botón Normal"),
          ),
          const SizedBox(height: 16),
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.favorite_border),
          ),
          const SizedBox(height: 16),
          TextButton(
            onPressed: () {},
            child: const Text("Soy un Botón de Texto"),
          ),
        ],
      ),
    );
  }
}

// --- Pantalla 3: Elementos de Selección ---
class SelectionScreen extends StatefulWidget {
  const SelectionScreen({super.key});

  @override
  State<SelectionScreen> createState() => _SelectionScreenState();
}

class _SelectionScreenState extends State<SelectionScreen> {
  bool isChecked = false;
  bool isSwitched = false;
  String? selectedOption = "Opción 1";
  final List<String> radioOptions = ["Opción 1", "Opción 2", "Opción 3"];

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("Elementos de Selección", style: Theme.of(context).textTheme.headlineMedium),
          const Text("Son componentes que permiten a los usuarios elegir una o más opciones."),
          const SizedBox(height: 16),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Checkbox(
                value: isChecked,
                onChanged: (bool? value) {
                  setState(() {
                    isChecked = value!;
                  });
                },
              ),
              const Text("Checkbox"),
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Switch(
                value: isSwitched,
                onChanged: (bool value) {
                  setState(() {
                    isSwitched = value;
                  });
                },
              ),
              const Text("Switch"),
            ],
          ),
          const Text("Elige una opción:"),
          ...radioOptions.map((option) {
            return Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Radio<String>(
                  value: option,
                  groupValue: selectedOption,
                  onChanged: (String? value) {
                    setState(() {
                      selectedOption = value;
                    });
                  },
                ),
                Text(option),
              ],
            );
          }).toList(),
        ],
      ),
    );
  }
}

// --- Pantalla 4: Listas ---
class ListsScreen extends StatelessWidget {
  const ListsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("Listas", style: Theme.of(context).textTheme.headlineMedium),
          const Text("Son la forma de mostrar conjuntos de datos que se pueden desplazar."),
          const SizedBox(height: 16),
          Text("Lista Vertical (ListView)", style: Theme.of(context).textTheme.titleMedium),
          Expanded(
            child: ListView.builder(
              itemCount: 4,
              itemBuilder: (context, index) {
                return ListTile(
                  title: Text("Elemento de la lista #$index"),
                );
              },
            ),
          ),
          const SizedBox(height: 16),
          Text("Lista Horizontal (ListView)", style: Theme.of(context).textTheme.titleMedium),
          SizedBox(
            height: 50,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: 4,
              itemBuilder: (context, index) {
                return Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16.0),
                  child: Center(child: Text("Item #$index")),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}

// --- Pantalla 5: Elementos de Información ---
class InfoScreen extends StatelessWidget {
  const InfoScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("Elementos de Información", style: Theme.of(context).textTheme.headlineMedium),
          const Text("Son componentes no interactivos que presentan datos al usuario."),
          const SizedBox(height: 16),
          const Icon(Icons.home, size: 48),
          const SizedBox(height: 16),
          const CircularProgressIndicator(),
        ],
      ),
    );
  }
}