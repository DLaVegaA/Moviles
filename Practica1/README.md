# Práctica 1: "Instalación y Funcionamiento de los Entornos Móviles"

El código corresponde a dos versiones de una misma aplicación móvil simple, diseñada para servir como un catálogo o demostración de componentes de interfaz de usuario (UI). Una versión está desarrollada con Flutter (archivos .dart) y la otra con Jetpack Compose para Android nativo (archivos .kt).

La funcionalidad central de la aplicación es presentar cinco pantallas distintas, cada una enfocada en un grupo de componentes de UI. La navegación entre estas pantallas se realiza a través de una barra de navegación inferior.

Las cinco pantallas son:

1. TextFields: Muestra diferentes tipos de campos de entrada de texto.

2. Botones: Exhibe varios estilos de botones (normales, de ícono, de texto).

3. Selección: Presenta elementos de selección como checkboxes, switches y radio buttons.

4. Listas: Demuestra cómo crear listas de elementos que se pueden desplazar vertical y horizontalmente.

5. Info: Muestra componentes de información no interactivos como íconos e indicadores de progreso.

### Análisis de la Implementación en Flutter
La versión de Flutter está estructurada en tres archivos principales: main.dart, navigation.dart y screens.dart.

* navigation.dart: Este archivo define la estructura de datos para los elementos de la barra de navegación. Contiene una clase simple ScreenItem que almacena el título y el ícono de cada pantalla. Luego, crea una lista global llamada screenItems que contiene las cinco pantallas a mostrar.

* screens.dart: Aquí se construye la interfaz de usuario para cada una de las cinco pantallas. Cada pantalla es un Widget (algunos StatelessWidget y otros StatefulWidget para manejar interacciones). Por ejemplo, la pantalla de "Selección" es un StatefulWidget para poder gestionar el estado de si un checkbox está marcado o no. Se utilizan widgets estándar de Flutter como TextField, ElevatedButton, Checkbox, Switch, Radio, ListView.builder, Icon y CircularProgressIndicator. Para los campos de texto, se usa un TextEditingController para gestionar su contenido.

* main.dart: Es el punto de entrada de la aplicación. Configura la MaterialApp y define el widget principal, MainScreen, que es un StatefulWidget. Este widget gestiona el estado de la navegación, manteniendo un _selectedIndex (un número entero) para saber qué pantalla está activa. El Scaffold contiene una BottomNavigationBar que se construye dinámicamente a partir de la lista screenItems. Cuando el usuario toca un ícono, la función _onItemTapped actualiza el índice usando setState(), lo que provoca que el cuerpo (body) del Scaffold se reconstruya para mostrar el widget de la pantalla correspondiente.

### Análisis de la Implementación en Jetpack Compose
La versión de Jetpack Compose está estructurada en MainActivity.kt, Navigation.kt y Screens.kt.

* Navigation.kt: Este archivo define las pantallas de la aplicación de una manera más estructurada y segura en tipos, utilizando una sealed class llamada Screen. Cada pantalla es un object que hereda de Screen y contiene su propia ruta, título e ícono. Este enfoque garantiza que solo se puedan usar las pantallas definidas.

* Screens.kt: Contiene las funciones Composable que dibujan la interfaz de usuario para cada una de las cinco pantallas. Son el equivalente a los widgets de Flutter. Se utilizan composables de Material 3 como OutlinedTextField, Button, IconButton, Checkbox, Switch, RadioButton, LazyColumn (para listas eficientes), Icon y CircularProgressIndicator. La gestión del estado se realiza de forma declarativa dentro de cada composable usando remember { mutableStateOf(...) }, lo que permite que la UI se actualice automáticamente cuando el valor del estado cambia.

* MainActivity.kt: Es la actividad principal y el punto de entrada de la aplicación. Aquí se encuentra el composable MainScreen, que organiza la estructura general. Utiliza un Scaffold que contiene una NavigationBar en la parte inferior. El estado de la pantalla actual se gestiona con una variable currentScreen que se inicializa con remember. La barra de navegación se crea recorriendo la lista de objetos de la sealed class Screen, y el NavigationBarItem correspondiente a la pantalla actual se marca como selected. Al hacer clic en un ícono, el estado currentScreen se actualiza, lo que hace que el contenido dentro del Scaffold se "recomponga". Un bloque when se encarga de llamar al composable de la pantalla correcta según el valor de currentScreen.

## ¿Cómo probar la app?

### Para Probar la Versión de Flutter
1. Abre el Proyecto: Abre la carpeta del proyecto de Flutter (p1_flutter o como la hayas llamado) en un editor de código como VS Code o en Android Studio.

2. Abre una Terminal: Dentro del editor, abre una nueva terminal.

3. Ejecuta la App: Asegúrate de tener un emulador corriendo o un dispositivo físico conectado y luego ejecuta el siguiente comando: flutter run

4. Verificación: La aplicación se instalará y se abrirá en tu dispositivo/emulador. Deberías ver la pantalla principal con la barra de navegación inferior. Toca cada uno de los íconos (TextFields, Botones, Selección, Listas, Info) para verificar que el contenido de la pantalla cambie correctamente.

### Para Probar la Versión de Jetpack Compose

1. Abre el Proyecto: Abre la carpeta del proyecto de Android (p1 o como la hayas llamado) con Android Studio.

2. Sincroniza el Proyecto: Espera a que Android Studio termine de sincronizar y construir el proyecto (puedes ver el progreso en la barra inferior).

3. Ejecuta la App: Asegúrate de tener un emulador de Android configurado o un dispositivo físico conectado. Luego, haz clic en el botón de Play en la barra de herramientas superior.

4. Verificación: La aplicación se instalará y se abrirá. Al igual que en la versión de Flutter, prueba la barra de navegación inferior para asegurarte de que cada ícono te lleve a la pantalla de componentes correspondiente.

## Capturas de pantalla

### Flutter

![Screenshot_20250921_172055](https://github.com/user-attachments/assets/6ff041b2-5712-4711-bf8a-c081a008f841)
![Screenshot_20250921_172113](https://github.com/user-attachments/assets/59167163-5de5-4aa2-bf1e-9f561c1ad4c2)
![Screenshot_20250921_172122](https://github.com/user-attachments/assets/c1732dfd-bc9b-4006-a28e-e55778c8c76d)
![Screenshot_20250921_172127](https://github.com/user-attachments/assets/c14fb1e5-a4cb-408c-8a53-26d55f02d336)
![Screenshot_20250921_172131](https://github.com/user-attachments/assets/43eb3a58-cebf-4130-a424-e4c77bc75149)

### Andriod Studio

![Screenshot_20250921_172150_P1](https://github.com/user-attachments/assets/6104ba99-e225-4219-a8c0-f06eeebc427d)
![Screenshot_20250921_172154_P1](https://github.com/user-attachments/assets/4df6bb9d-87f1-4e84-bc6f-2bbfb1a8c471)
![Screenshot_20250921_172201_P1](https://github.com/user-attachments/assets/068868db-a41e-4c3c-9a64-70fa5856186f)
![Screenshot_20250921_172205_P1](https://github.com/user-attachments/assets/f75bfcb1-b19b-4610-a257-a8f9d2d2c084)
![Screenshot_20250921_172209_P1](https://github.com/user-attachments/assets/3f0a3444-2f5c-4449-bbae-598757a1ac9c)

## Dificultades

