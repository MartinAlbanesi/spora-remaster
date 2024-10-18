# Descripción del Producto

### 1 - Welcome

La Pantalla de Bienvenida muestra el logo de la aplicación y ofrece al usuario la opción de iniciar sesión, registrarse o jugar como invitado. En esta pantalla, Champy se presenta y guía al usuario hacia el Árbol Madre, marcando el inicio de la aventura.

- #### 1.1 - Login / Registro

Permite al usuario iniciar sesión o registrarse para guardar el progreso alcanzado en el juego.

- #### 1.2 - Jugar como invitado

Ofrece la opción de ingresar a la aplicación sin necesidad de iniciar sesión o registrarse, aunque el progreso obtenido no se guardará.

### 2 - Inicio

En esta pantalla, podemos ver a Champy junto al Árbol Madre y un sendero que nos conducirá a las diferentes áreas de la aventura. 
Desde los íconos en el inicio, el usuario puede navegar hacia las siguientes funcionalidades y características de la aplicación:

- **Perfil:** Acceso a los detalles de la cuenta y opciones de configuración.
- **Ranking:** Visualización de la posición actual del usuario en comparación con otros jugadores.
- **Misiones Diarias:** Acceso a las misiones diarias que otorgan diversas recompensas.
- **Diario Ecológico:** Centro principal de información donde se acumulan los conceptos aprendidos durante la aventura.
- **Arboleda:** Juego pasivo que permite obtener y plantar semillas, y recolectar oxígeno de los árboles del bosque.

### 3 - Áreas

El Área de la Aventura es el lugar donde se encuentran los niveles y desafíos de la aventura. Cada nivel está compuesto por diferentes minijuegos que deben completarse para ganar el nivel y desbloquear el siguiente. Los temas tratados en los minijuegos varían según el área.
Existen tres áreas en total, pero por ahora solo se presenta la del bosque:

- **Bosque:** Aquí se abordan temas como la deforestación, el reciclaje, la contaminación del aire y los incendios forestales.

Áreas futuras:

- **Lago:** Se tratarán temas como el desperdicio de agua, la contaminación con sustancias tóxicas y los peligros de los plásticos para la fauna acuática.
- **Desierto:** Se enfocará en temas como las energías renovables, la contaminación causada por las petroleras y el daño a la capa de ozono.

A continuación se detallan las características de las áreas:

- #### 3.1 - Niveles

El Nivel es el primer paso en la aventura del usuario. Dentro de cada área, hay una cantidad determinada de niveles, cada uno compuesto por varios minijuegos que deben completarse para avanzar con éxito. Al completar un nivel, se desbloquea el siguiente, hasta finalmente alcanzar el desafío final del área.
Cada nivel cuenta con un sistema de 3 estrellas, donde cada estrella representa una recompensa. 

Estas recompensas se otorgan en función del rendimiento del usuario, que se evalúa mediante la cantidad total de vidas restantes al finalizar el nivel. Este sistema permite verificar el desempeño del usuario y asignar las recompensas correspondientes de manera justa y motivadora.

- #### 3.1.1 - Detalle del Nivel

Al seleccionar un nivel, se abrirá una pantalla que presentará la siguiente información:

- **Estrellas del Nivel:** Se mostrará cuántas estrellas ha acumulado el usuario en este nivel, reflejando su rendimiento anterior.
- **Posibles Recompensas:** Se enumerarán las recompensas disponibles para este nivel, incentivando al usuario a completar el desafío.
- **Nombre del Área:** Se indicará el nombre del área a la que pertenece el nivel, brindando contexto sobre el entorno y los temas tratados.
- **Requisito de Oxígeno:** Se especificará la cantidad de oxígeno que el usuario necesita acumular para poder acceder a este nivel, estableciendo un objetivo claro para la progresión en la aventura.

- #### 3.2 -  Minijuegos

Al ingresar a un nivel, el usuario comenzará con 5 vidas. Estas vidas se irán descontando cada vez que se cometa un error en alguno de los minijuegos. La interfaz incluirá una barra de progreso que indicará cuántos minijuegos quedan por completar para finalizar el nivel, así como un ícono que permitirá salir del nivel en cualquier momento. 

Durante el desarrollo de los minijuegos, Champy estará presente en la pantalla, mostrando diferentes emociones según el desempeño del usuario. Su expresión cambiará al completar correctamente o incorrectamente las actividades. 

Al finalizar el nivel, se presentará el resultado del juego, y se calcularán las estrellas obtenidas en función de la cantidad de vidas que queden. Las estrellas se traducirán en recompensas en oxígeno, que el usuario podrá reclamar. 

Si el usuario no logra obtener la máxima cantidad de estrellas o desea mejorar su rendimiento, tendrá la opción de reiniciar el juego y volver a intentarlo antes de avanzar al siguiente nivel.

- ##### 3.2.1 - Detalle de los Minijuegos

Los minijuegos son una parte fundamental de la experiencia del usuario en la aventura, proporcionando un enfoque divertido y educativo sobre temas ambientales.
A continuación se describen las mecánicas de cada tipo de minijuego:

- Quiz: Se presenta una pregunta relacionada con los temas del área del nivel actual y cuatro posibles respuestas. El usuario selecciona una respuesta, que se valida como correcta o incorrecta. Si es correcta, se pinta de verde y Champy celebra con un salto. Si es incorrecta, se pinta de rojo, se descuenta una vida y Champy se muestra triste, indicando cuál era la respuesta correcta. Tras verificar la respuesta, se habilita un botón para continuar.
- Quiz de Imágenes: Similar al Quiz, pero se muestra una ilustración relacionada con la temática del área junto con una pregunta y cuatro respuestas. La validación y los resultados siguen el mismo proceso que el Quiz.
- Relacionar los Conceptos: Se presenta una consigna, una palabra clave y seis posibles respuestas. El usuario selecciona tres opciones y, al confirmar, se validan las respuestas. Si el usuario elige las tres respuestas correctas, se habilita un botón para continuar. Si selecciona al menos una respuesta incorrecta, se pierde una vida y se avanza al siguiente minijuego.

Estos minijuegos están diseñados para ser educativos y entretenidos, fomentando el aprendizaje a través de la interacción y el juego, mientras se mantiene un seguimiento del progreso del usuario mediante la gestión de vidas y recompensas.

- #### 3.3 - Desafíos

El Desafío está diseñado para ser una experiencia interactiva que fomenta la participación del usuario tanto en el juego como en la vida real. Al ingresar al desafío, se presentará al usuario una lista de objetos que debe escanear utilizando la cámara de su dispositivo.

Cuando el usuario reconozca uno de los objetos en la lista, este se marcará como completado y aparecerá una breve descripción del objeto. Esta descripción incluirá información relevante sobre sus niveles de contaminación, su tiempo de degradación y consejos sobre cómo reciclarlo adecuadamente.

Una vez que el usuario haya completado todos los elementos de la lista, se le otorgará una recompensa significativa, que en este caso será un nuevo árbol semillero. Este enfoque no solo mejora la interactividad del juego, sino que también educa al usuario sobre la importancia del reciclaje y el cuidado del medio ambiente.

### 4 - Perfil

Si el usuario está registrado, esta sección mostrará los datos de la cuenta, el avatar del usuario y los logros obtenidos. Si no está registrado, aparecerá un mensaje incentivando al usuario a registrarse para guardar su progreso.

- #### 4.1 - Logros

Se mostrarán todos los logros que el usuario ha alcanzado a medida que progresa en la aventura.

- #### 4.2 - Opciones

Aquí se presentan las opciones de configuración de la aplicación, que incluyen las siguientes secciones:

- **Editar Perfil:** Apartado donde el usuario puede modificar los datos de su cuenta, como el nombre de usuario, avatar, correo electrónico y contraseña.
- **Notificaciones:** Sección para gestionar las diversas notificaciones de la aplicación, que incluyen alertas sobre recompensas del árbol, misiones diarias, recordatorios del juego, y la opción de desactivar todas las notificaciones.
- **Soporte:** Apartado que incluye un formulario para que el usuario complete su solicitud sobre cualquier problema o consulta relacionada con la aplicación. Se incluirá una lista de tipos de solicitud, un campo para el título o asunto que identifique el problema, y un espacio para detallar la consulta.
- **Sobre Nosotros:** Sección que proporciona información sobre todos los integrantes del equipo, incluyendo nombre, apellido, foto, correo electrónico y redes sociales.

### 5 - Ranking

El Ranking es la sección donde se lleva a cabo la competencia principal entre los usuarios de la aplicación. Los usuarios compiten por un lugar en el tablero de posiciones, buscando acumular la mayor cantidad de oxígeno posible de manera semanal. Los tres primeros lugares recibirán recompensas, mientras que los demás competidores no obtendrán nada.
En esta sección, se podrá visualizar:

- **Nombre de usuario:** El nombre que cada competidor ha elegido para ser identificado en el ranking.
- **Avatar:** La imagen que representa a cada usuario en la tabla de posiciones.
- **Cantidad de oxígeno acumulada:** La cantidad total de oxígeno que cada usuario ha obtenido durante la semana.
- **Cantidad de árboles plantados:** Número de árboles que el usuario ha plantado en la arboleda.
- **Posición actual en el Ranking:** La ubicación del usuario en la tabla de posiciones, reflejando su rendimiento en comparación con otros competidores.

### 6 - Misiones Diarias

Las Misiones Diarias permiten a los usuarios obtener pequeñas recompensas al completar objetivos en la aventura. Estas misiones se reinician diariamente. Al presionar sobre el ícono de Misiones, el usuario podrá ver los detalles de las misiones activas junto con un temporizador que indica el tiempo restante hasta el reinicio.
Cada misión se visualiza con los siguientes elementos:

- **Ícono:** Representa gráficamente la misión para facilitar su identificación.
- **Texto del objetivo:** Describe claramente lo que se necesita completar para la misión.
- **Barra de progreso:** Muestra el avance del usuario en la misión, permitiendo saber cuánto falta para completarla.
- **Recompensa:** Indica lo que el usuario recibirá al completar la misión.

La complejidad de la misión y el tiempo requerido para completarla determinarán la calidad de las recompensas otorgadas. Una vez que se complete una misión, esta se deshabilitará y no estará disponible nuevamente hasta que se reinicien todas las misiones al día siguiente.

### 7 - Biblioteca de Mushy

La Biblioteca de Mushy es el centro de información de la aplicación, donde se acumulan los conceptos aprendidos durante la aventura. Aquí, el usuario podrá revisar los temas tratados en los niveles y desafíos, así como los datos obtenidos en la arboleda. La Biblioteca de Mushy se divide en las siguientes secciones:

- **Estante de Libros** Aquí se presentan los conceptos y lecciones aprendidas en los niveles y desafíos de la aventura, separados por áreas y temas. Cada libro contiene información detallada sobre el tema tratado, incluyendo imágenes, gráficos y datos relevantes.
- **Diario Ecológico** En esta sección, se recopilan los datos y las estadísticas del usuario, como la cantidad total de árboles plantados, la cantidad de semillas obtenidas, el total de niveles completados, el tiempo jugado y la posición en el ranking.

### 8 - Arboleda

La Arboleda es el juego pasivo de la aplicación, diseñado para incentivar a los usuarios a continuar utilizando la plataforma, incluso cuando no pueden progresar en la aventura o después de haberla completado. 
Esta sección está compuesta por:

- **Fila de árboles semilleros:** Estos árboles proporcionan semillas cada cierto tiempo, lo que se puede visualizar mediante una barra de progreso.
- **Matriz de árboles del bosque:** Encargados de generar oxígeno diariamente.
- **Botón de oxígeno diario:** Permite al usuario reclamar el oxígeno acumulado.

A continuación, se detallan los diferentes conceptos de la Arboleda:

- #### 8.1 - Árbol Madre

El Árbol Madre es el árbol semillero por defecto que aparecerá primero en la arboleda. Este árbol otorgará semillas a intervalos regulares, los cuales se pueden visualizar en una barra de progreso. Las semillas pueden ser reclamadas y plantadas en una posición aleatoria de la matriz de árboles del bosque, donde comenzarán a crecer. Es el único árbol que permanecerá en la arboleda de forma indefinida.

- #### 8.2 - Árbol Semillero

El Árbol Semillero cumple la misma función que el Árbol Madre. Puede obtenerse al completar un desafío en un área o como recompensa por ocupar una de las tres primeras posiciones en el Ranking. Cada árbol semillero pertenece a uno de los diferentes tipos de árboles de su área y otorgará semillas del mismo tipo. Una vez que ha otorgado una cierta cantidad de semillas, el árbol semillero muere y desaparece de la arboleda, permitiendo así la aparición de nuevos árboles semilleros al completar desafíos nuevamente.

- #### 8.3 - Semilla

La Semilla se obtiene a partir de los árboles semilleros. Después de ser reclamadas, estas semillas pueden ser plantadas en un lugar aleatorio de la matriz de árboles del bosque y tendrán el mismo tipo de árbol que el árbol semillero del cual provienen.

- #### 8.4 - Árbol del Bosque

El Árbol del Bosque surge de las semillas otorgadas por los árboles semilleros. Hereda el tipo de árbol de la semilla y proporciona oxígeno diario que el usuario puede reclamar. Una vez que ha otorgado una cantidad específica de oxígeno, muere y desaparece de la arboleda. Los árboles del bosque atraviesan tres etapas de crecimiento antes de comenzar a otorgar oxígeno:

1. Brote: Es la primera etapa del árbol. Se visualizará un pequeño brote en el lugar donde fue plantado y comenzará el temporizador de crecimiento.
2. Mediano: En esta segunda etapa, se visualizará un pequeño árbol o arbusto, representando un árbol en pleno crecimiento.
3. Adulto: La tercera y última etapa del árbol. Se mostrará con una imagen del tipo de árbol al que pertenece y comenzará a otorgar oxígeno diariamente.
