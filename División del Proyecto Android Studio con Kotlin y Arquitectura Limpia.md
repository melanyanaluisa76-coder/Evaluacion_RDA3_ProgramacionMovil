## **División del Proyecto Android Studio con Kotlin y Arquitectura Limpia** 

## **Tema del proyecto** 

Aplicación móvil para estudiantes de la Facultad de Hábitat, Infraestructura y Creatividad, orientada a la digitalización, organización, consulta offline y gestión de apuntes académicos. 

## **Problema identificado** 

Los estudiantes de la facultad dedican tiempo valioso a transcribir apuntes físicos a formato digital. Además, tienen dificultades para mantener sus apuntes organizados y disponibles antes de estudiar, especialmente cuando no cuentan con acceso a internet. A esto se suma la necesidad de gestionar horarios personalizados de sus materias. 

## **Características principales de la aplicación** 

La aplicación contará con las siguientes funcionalidades: 

- **Dashboard reactivo de materias:** uso de `LazyColumn` para listar cursos y mostrar el registro de apuntes. 

- **Digitalizador de apuntes:** uso de la cámara del celular para escanear texto físico y convertirlo en texto digital. 

- **Audio de apuntes:** lectura en voz alta de los apuntes mediante la API nativa de Android Text-toSpeech. 

- **Compartir apuntes offline:** generación de códigos QR con el contenido del apunte digitalizado para compartirlo sin internet. 

- **Gestión de horarios personalizados:** almacenamiento y visualización de horarios de materias. 

- • **Funcionamiento offline:** almacenamiento local mediante Room. 

## **Enfoque de trabajo** 

El proyecto se desarrollará mediante un enfoque de **sprints incrementales por relevo** . 

Esto significa que cada integrante recibirá una versión funcional de la aplicación, agregará una mejora completa e integrada, y entregará una nueva versión funcional al siguiente integrante. 

De esta forma se evita depender de un sprint final de integración, ya que cada sprint debe entregar una aplicación que compile, funcione y mantenga las funcionalidades anteriores. 

1 

## **Flujo general de trabajo** 

```
Integrante 1 → Versión 1 funcional
Integrante 2 → Versión 2 funcional
Integrante 3 → Versión 3 funcional
Integrante 4 → Versión 4 funcional
Integrante 5 → Versión 5 funcional
```

Cada integrante debe cumplir con la siguiente regla: 

Nadie entrega solo código parcial. Cada integrante debe entregar una aplicación funcional, compilable y probada. 

## **Arquitectura general del proyecto** 

El proyecto se desarrollará usando **Kotlin** , **Jetpack Compose** , **MVVM** y **arquitectura limpia** . 

La estructura recomendada es la siguiente: 

```
app/
 └── src/main/java/com/app/apuntes/
      ├── domain/
      │    ├── model/
      │    ├── repository/
      │    └── usecase/
      │
      ├── data/
      │    ├── local/room/
      │    ├── remote/retrofit/
      │    ├── mapper/
      │    └── repository/
      │
      ├── presentation/
      │    ├── navigation/
      │    ├── screens/
      │    ├── components/
      │    └── viewmodel/
      │
      └── core/
           ├── permissions/
           ├── camera/
           ├── tts/
           └── qr/
```

2 

## **Modelos base sugeridos** 

## **Data class Apunte** 

```
dataclassApunte(
valid:Long=0,
valmateriaId:Long,
valtitulo:String,
valcontenido:String,
valfechaCreacion:Long,
valorigen:String="manual",
valsincronizado:Boolean=false
)
```

## **Data class Materia** 

```
dataclassMateria(
valid:Long=0,
valnombre:String,
valdocente:String?=null,
valhorario:String?=null
)
```

## **Estado de interfaz para apuntes** 

```
sealedclassApuntesUiState{
objectLoading:ApuntesUiState()
dataclassSuccess(valapuntes:List<Apunte>):ApuntesUiState()
dataclassError(valmensaje:String):ApuntesUiState()
}
```

## **División de sprints por integrantes** 

## **Integrante 1 — Sprint 1: Proyecto base funcional con arquitectura limpia** 

## **Nombre del sprint** 

## **Sprint 1: Estructura base, navegación y datos iniciales** 

3 

## **Objetivo** 

Crear la primera versión funcional de la aplicación, aplicando arquitectura limpia, MVVM, Jetpack Compose y navegación entre pantallas principales. 

## **Qué recibe** 

Este integrante parte desde cero. 

## **Qué debe hacer** 

Debe crear el proyecto en Android Studio usando Kotlin y Jetpack Compose. 

Debe organizar el proyecto en las siguientes capas: 

```
domain
data
presentation
core
```

Debe definir los modelos principales del dominio: 

- `Apunte` 

- `Materia` 

- `Horario` 

- `PerfilEstudiante` 

Debe definir estados de interfaz usando `sealed class` , por ejemplo: 

- `ApuntesUiState` 

- `MateriasUiState` 

- `HorarioUiState` 

Debe implementar la navegación básica usando Navigation Compose. 

Rutas principales sugeridas: 

```
Dashboard
Lista de materias
Lista de apuntes
Detalle de apunte
Perfil
Horario
Escáner
QR
```

En esta primera versión se pueden usar datos simulados para materias y apuntes. 

4 

## **Entregables** 

El integrante debe entregar una aplicación que: 

- Compile correctamente. 

- Abra sin errores. 

- Muestre una pantalla inicial. 

- Permita navegar entre pantallas principales. 

- Tenga modelos principales definidos. 

- Tenga estados de UI definidos. 

- Tenga arquitectura limpia organizada. 

- Use datos simulados para probar la navegación. 

## **Resultado del sprint** 

```
Versión 1: App base navegable con arquitectura limpia y datos simulados.
```

## **Integrante 2 — Sprint 2: Dashboard reactivo de materias y apuntes** 

## **Nombre del sprint** 

## **Sprint 2: Dashboard reactivo y visualización de apuntes** 

## **Objetivo** 

Mejorar la versión anterior agregando un dashboard funcional donde el estudiante pueda visualizar materias y apuntes de forma ordenada usando Jetpack Compose. 

## **Qué recibe** 

Recibe la versión del Integrante 1: 

```
Versión 1: App base navegable con arquitectura limpia y datos simulados.
```

## **Qué debe hacer** 

Debe mejorar la interfaz principal de la aplicación. 

Debe crear un dashboard con: 

- Lista de materias usando `LazyColumn` . 

- Tarjetas visuales para cada materia. 

- Contador de apuntes por materia. 

- Acceso a los apuntes de cada materia. 

- Pantalla de detalle del apunte. 

5 

- Estado de carga. 

- Estado de éxito. 

- Estado de error. 

- Estado vacío cuando no existan apuntes. 

Debe trabajar con ViewModel para manejar el estado de la interfaz. 

Ejemplo: 

```
classDashboardViewModel:ViewModel(){
privateval_uiState=
MutableStateFlow<MateriasUiState>(MateriasUiState.Loading)
valuiState:StateFlow<MateriasUiState>=_uiState
}
```

Debe usar: 

- `StateFlow` 

- `collectAsState()` 

- `LazyColumn` 

- componentes reutilizables en Compose 

Componentes sugeridos: 

```
MateriaCard
ApunteCard
EmptyState
LoadingState
ErrorState
```

También puede agregar una pantalla básica para crear apuntes manualmente. Esto permite que la app tenga interacción antes de integrar Room. 

## **Entregables** 

El integrante debe entregar una aplicación que: 

- Muestre materias en un dashboard. 

- Permita seleccionar una materia. 

- Muestre los apuntes asociados a esa materia. 

- Permita abrir el detalle de un apunte. 

- Maneje estados `Loading` , `Success` y `Error` . 

- Mantenga funcionando la navegación creada en el sprint anterior. 

- Use una interfaz ordenada y clara en Jetpack Compose. 

## **Resultado del sprint** 

```
Versión 2: App con dashboard reactivo, materias y apuntes visibles.
```

6 

## **Integrante 3 — Sprint 3: Persistencia local con Room, horarios y Retrofit** 

## **Nombre del sprint** 

## **Sprint 3: Funcionamiento offline, horarios personalizados y Retrofit** 

## **Objetivo** 

Convertir la app en una aplicación útil sin internet, guardando apuntes, materias y horarios en Room. Además, integrar Retrofit para consumir información educativa desde una API REST. 

## **Qué recibe** 

Recibe la versión del Integrante 2: 

```
Versión 2: App con dashboard reactivo y navegación funcional.
```

## **Qué debe hacer** 

Debe reemplazar los datos simulados por almacenamiento local real usando Room. 

Debe crear entidades como: 

```
ApunteEntity
MateriaEntity
HorarioEntity
```

Debe crear DAOs: 

```
ApunteDao
MateriaDao
HorarioDao
```

Debe crear la base de datos local: 

```
@Database(
entities=[
ApunteEntity::class,
MateriaEntity::class,
HorarioEntity::class
],
version=1
)
```

7 

```
abstractclassAppDatabase:RoomDatabase(){
abstractfunapunteDao():ApunteDao
abstractfunmateriaDao():MateriaDao
abstractfunhorarioDao():HorarioDao
}
```

Debe implementar repositorios concretos en la capa `data` . 

Ejemplo: 

```
classApunteRepositoryImpl(
privatevalapunteDao:ApunteDao
):ApunteRepository{
overridesuspendfunobtenerApuntes():List<Apunte>{
returnapunteDao.obtenerApuntes().map{it.toDomain()}
}
}
```

Debe crear mappers para transformar datos entre la capa local y la capa de dominio. 

Ejemplos: 

```
ApunteEntity.toDomain()
Apunte.toEntity()
MateriaEntity.toDomain()
Materia.toEntity()
```

También debe implementar la gestión básica de horarios personalizados: 

- Crear horario de una materia. 

- Mostrar horario en pantalla. 

- Editar horario. 

- Guardar horario localmente. 

Además, debe configurar Retrofit para consumir una API REST con información educativa. 

La API puede utilizarse para obtener: 

- Recursos recomendados. 

- Información académica. 

- Consejos de estudio. 

- Datos de ejemplo para materias. 

- Información educativa complementaria. 

Las llamadas de red deben realizarse con corrutinas para no bloquear el hilo principal. 

8 

## **Entregables** 

El integrante debe entregar una aplicación que: 

- Guarde apuntes localmente. 

- Guarde materias localmente. 

- Guarde horarios personalizados. 

- Funcione sin internet. 

- Mantenga el dashboard conectado a datos reales. 

- Tenga Retrofit configurado para consumir una API REST. 

- Use corrutinas para operaciones de base de datos y red. 

- Mantenga funcionando las funcionalidades de los sprints anteriores. 

## **Resultado del sprint** 

```
Versión 3: App offline con Room, horarios personalizados y Retrofit.
```

## **Integrante 4 — Sprint 4: Digitalizador de apuntes con cámara y ML Kit** 

## **Nombre del sprint** 

## **Sprint 4: Escaneo de apuntes físicos y reconocimiento de texto** 

## **Objetivo** 

Agregar la función principal del proyecto: permitir que el estudiante use la cámara del celular para digitalizar apuntes físicos y guardarlos como apuntes digitales. 

## **Qué recibe** 

Recibe la versión del Integrante 3: 

```
Versión 3: App offline con Room, horarios y datos persistentes.
```

## **Qué debe hacer** 

Debe implementar la pantalla de escaneo de apuntes. 

Debe trabajar con: 

- Permisos de cámara. 

- Captura de imagen. 

- Procesamiento con ML Kit Text Recognition. 

- Extracción del texto reconocido. 

- Pantalla de edición del texto reconocido. 

9 

• Guardado del apunte en Room. 

El flujo esperado es: 

```
Abrir cámara
Capturar imagen
Reconocer texto con ML Kit
Mostrar resultado
Permitir editar el texto
Guardar como apunte
Ver el apunte en el dashboard
```

Debe crear pantallas como: 

```
ScannerScreen
ResultadoOCRScreen
EditarApunteScreen
```

Debe manejar estados como: 

```
Esperando captura
Procesando imagen
Texto reconocido
Error de lectura
Guardado exitoso
```

Debe considerar errores como: 

- Permiso de cámara denegado. 

- Imagen borrosa. 

- Texto no reconocido. 

- Fallo al guardar. 

- Cámara no disponible. 

## **Entregables** 

El integrante debe entregar una aplicación que: 

- Abra la cámara. 

- Permita capturar una imagen. 

- Reconozca texto usando ML Kit. 

- Muestre el texto reconocido. 

- Permita editar el texto antes de guardarlo. 

- Guarde el apunte en Room. 

- Muestre el nuevo apunte en el dashboard. 

- Mantenga funcionando las funcionalidades de los sprints anteriores. 

10 

```
Versión 4: App con digitalizador de apuntes físicos mediante cámara y OCR.
```

## **Resultado del sprint** 

## **Integrante 5 — Sprint 5: Audio de apuntes y compartición offline por QR** 

## **Nombre del sprint** 

## **Sprint 5: Accesibilidad y compartición offline** 

## **Objetivo** 

Mejorar la app agregando lectura de apuntes en voz alta y compartición offline mediante códigos QR. 

## **Qué recibe** 

Recibe la versión del Integrante 4: 

```
Versión 4: App con OCR, Room, dashboard y horarios.
```

## **Qué debe hacer** 

Debe agregar dos funcionalidades principales: 

1. Audio de apuntes con Text-to-Speech. 

- Compartición offline mediante códigos QR. 

2. 

## **Parte 1: Audio de apuntes con Text-to-Speech** 

Debe usar la API nativa de Android Text-to-Speech. 

Debe agregar en la pantalla de detalle del apunte: 

- Botón para escuchar apunte. 

- Botón para detener lectura. 

- Lectura del título y contenido. 

- Manejo de texto vacío. 

- Liberación del recurso Text-to-Speech cuando ya no se use. 

Servicio sugerido: 

```
classTextToSpeechManager{
funhablar(texto:String)
```

11 

```
fundetener()
funliberar()
}
```

El flujo esperado es: 

```
Abrir detalle de apunte
Presionar botón escuchar
La app lee el contenido
El estudiante puede detener el audio
```

## **Parte 2: Compartir apuntes offline con QR** 

Debe permitir generar un código QR con el contenido de un apunte. 

Debe crear pantallas como: 

```
GenerarQrScreen
EscanearQrScreen
ResultadoQrScreen
```

El flujo esperado es: 

```
Seleccionar apunte
Presionar compartir por QR
Generar código QR
Otro estudiante escanea el QR
La app recupera el texto
El texto puede guardarse como nuevo apunte
```

Debe usar ML Kit Barcode Scanning para leer códigos QR. 

También debe controlar el caso de apuntes demasiado largos: 

```
El apunte es demasiado largo para compartirlo por QR. Divide el contenido o
resume el texto.
```

## **Entregables** 

El integrante debe entregar una aplicación que: 

- Lea apuntes en voz alta. 

- Permita detener la lectura. 

- Genere QR a partir de un apunte. 

12 

- Escanee QR usando ML Kit Barcode Scanning. 

- Permita guardar el texto recibido como apunte. 

- Mantenga funcionamiento offline. 

- Mantenga funcionando todas las funcionalidades anteriores. 

## **Resultado del sprint** 

```
Versión 5: App completa con audio, QR, OCR, Room, horarios y dashboard.
```

## **Tabla resumen de los sprints incrementales** 

|Integrante|Versión que<br>recibe|Mejora que implementa|Versión que<br>entrega|
|---|---|---|---|
|Integrante<br>1|Proyecto vacío|Arquitectura limpia, navegación, modelos,<br>estados y datos simulados|Versión 1<br>funcional|
|Integrante<br>2|Versión 1|Dashboard reactivo, materias, apuntes y<br>detalle|Versión 2<br>funcional|
|Integrante<br>3|Versión 2|Room, persistencia ofine, horarios y Retroft|Versión 3<br>funcional|
|Integrante<br>4|Versión 3|Cámara, OCR y guardado de apuntes<br>digitalizados|Versión 4<br>funcional|
|Integrante<br>5|Versión 4|Text-to-Speech, generación y escaneo de QR|Versión 5<br>funcional|



## **Control de versiones recomendado en GitHub** 

Se recomienda trabajar con una rama por sprint. 

```
main
 ├── sprint-1-base
 ├── sprint-2-dashboard
 ├── sprint-3-room-retrofit
 ├── sprint-4-ocr
 └── sprint-5-audio-qr
```

Cada rama debe salir de la versión anterior. 

El flujo sería: 

13 

```
sprint-1-base → main
sprint-2-dashboard sale de main → main
sprint-3-room-retrofit sale de main → main
sprint-4-ocr sale de main → main
sprint-5-audio-qr sale de main → main
```

También se recomienda crear etiquetas por versión: 

```
v1-base
v2-dashboard
v3-offline-room
v4-ocr
v5-audio-qr
```

## **Condiciones mínimas de entrega por sprint** 

Cada integrante debe entregar: 

`1. App compilando correctamente.` 

`2. Funcionalidad anterior intacta.` 

`3. Nueva funcionalidad integrada.` 

`4. Pruebas manuales realizadas.` 

`5. README actualizado.` 

`6. Capturas o video corto de evidencia.` 

`7. Rama integrada a main.` 

## **Ficha individual de entrega por sprint** 

Cada integrante debe completar una ficha como la siguiente: 

```
Nombre del sprint:
Versión recibida:
Problema que mejora:
Funcionalidad implementada:
Capas modificadas:
Clases principales creadas:
Pruebas realizadas:
Versión entregada:
```

14 

## **Ejemplo de ficha individual** 

```
Nombre del sprint: Sprint 4 - Digitalizador de apuntes
Versión recibida: v3-offline-room
Problema que mejora: reduce el tiempo de transcripción manual de apuntes
físicos.
```

```
Funcionalidad implementada: reconocimiento de texto desde cámara usando ML
Kit.
Capas modificadas: core, data y presentation.
Clases principales creadas: ScannerScreen, ResultadoOCRScreen,
TextRecognitionManager.
Pruebas realizadas: captura de imagen, reconocimiento de texto, edición y
guardado local.
Versión entregada: v4-ocr.
```

## **Flujo final esperado de la aplicación** 

```
El estudiante abre la app.
Visualiza sus materias en el dashboard.
Selecciona una materia.
Visualiza los apuntes asociados.
Escanea un apunte físico con la cámara.
La app convierte el texto físico en texto digital.
El estudiante edita y guarda el apunte.
El apunte queda disponible offline.
El estudiante puede escucharlo usando Text-to-Speech.
El estudiante puede compartirlo mediante QR.
Otro estudiante puede escanear el QR y guardar el apunte.
```

## **Justificación del enfoque incremental** 

El desarrollo por sprints incrementales permite que cada integrante trabaje sobre una versión funcional del proyecto y no sobre partes aisladas. Esto reduce el riesgo de errores al momento de integrar, ya que cada sprint debe entregar una aplicación completa, compilable y probada. Además, este enfoque permite evidenciar claramente el aporte individual de cada estudiante, porque cada versión representa una mejora concreta sobre la anterior. De esta manera, el proyecto avanza de forma ordenada desde una app base hasta una aplicación completa con dashboard, almacenamiento offline, horarios personalizados, digitalización de apuntes, lectura por voz y compartición mediante códigos QR. 

15 

