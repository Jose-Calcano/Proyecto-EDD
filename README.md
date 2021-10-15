# Proyecto-EDD

Proyecto 1: Samancito Delivery
Contexto preliminar
En el siguiente proyecto, usted tendrá que realizar una investigación documental que le permita obtener información sobre el contexto del problema. En tal sentido, se sugiere que comience por realizar la siguiente lectura relativa a grafos, pero tome en cuenta que es solo un recurso inicial que debe ser complementado con la búsqueda autónoma de información por parte de los integrantes del equipo de trabajo:
https://drive.google.com/file/d/1Q65Rh-Tx6qwJODUlsmWVfw_-bzqttwiI/view?usp=sharing
Problema
    Ante el auge de los servicios de entregas originado por la cuarentena, un grupo de estudiantes de la Unimet decidió crear una aplicación de delivery. Sin embargo, la competencia contra otras aplicaciones como “Pedidos Ya” y “Yummy” es muy dura.
Los emprendedores unimetanos vieron una oportunidad de mercado al percatarse que los algoritmos de estas empresas son sumamente ineficientes. Gracias a su conocimiento sistémico decidieron contratarlos a ustedes, especialistas en grafos, para generar un sistema que calcule la ruta más corta entre distintos puntos para optimizar los tiempos de entrega y reducir los gastos de gasolina. La naturaleza del problema se puede representar a través de un grafo ponderado y dirigido.
Requerimientos funcionales
1.  General
Cargar archivo: El usuario puede seleccionar a través de JFileChooser un archivo samancito.txt para ser cargado en el sistema, el cual contará con la información necesaria para la creación del grafo,  es decir: restaurantes, platos, clientes, pedidos y caminos. Cuando el usuario cargue un nuevo archivo, el sistema debe enviar un mensaje de alerta indicando al usuario la necesidad de guardar los datos actualmente cargados en memoria. La estructura del archivo de datos (archivo de texto plano) se indicará posteriormente.
Actualizar repositorio:  Esta función permitirá que la información cargada en memoria, referente a los clientes, locales y sus menús. Es decir, los cambios realizados a cualquiera de estos deben de actualizarse en el archivo texto de tal forma que cuando se vuelva a cargar ese archivo contenga  todos los cambios realizados. Al iniciarse el programa por primera vez debe cargarse el archivo de texto dado al final del enunciado (debe de mantener el mismo formato).
Mostrar grafo: El sistema deberá mostrar una representación visual del grafo según la información contenida en la memoria, es decir, los caminos disponibles entre los restaurantes y la información de estos.
Recorrer grafo: Con el fin de conocer todos los nodos que forman parte del grafo, se podrá seleccionar esta opción, la cual mostrará todos los nodos del grafo mediante el recorrido de anchura (BFS) y el recorrido de profundidad (DFS).
Seleccionar rol de usuario: En la ventana inicial del sistema se debe poder seleccionar el rol del usuario, en este caso se contemplarán 3 roles: 
Cliente: Pueden registrarse en el sistema y seleccionar el local donde desean hacer su pedido, junto con los platos que quieran del mismo. 
Driver: Pueden visualizar las órdenes que han realizado los clientes y el sistema les debe mostrar la ruta ideal para el despacho.  
Administrador: Encargado de añadir locales y caminos en el sistema, con sus  respectivos menús. 
2.  Cliente
Nuevo cliente:  Para el registro se solicitan los siguientes datos: nombre, apellido, cédula, dirección. Para la dirección debe seleccionar dos nodos, indicando sus respectivas distancias (elección del usuario). 
Ordenar: A la hora de realizar una orden, el usuario deberá seleccionar el número de cliente correspondiente y el restaurante en el cual desea ordenar. Posteriormente se mostrará el menú y se procederá a seleccionar los platos deseados y la cantidad de los mismos. Finalmente, al confirmar toda la información el pedido se añadirá a la lista de entregas pendientes.
3.  Driver
Realizar entrega: Al seleccionar la opción de driver, el usuario podrá realizar la entrega. Esta opción debe mostrar la lista de pedidos pendientes; el driver seleccionará el pedido que desea entregar y se generará la ruta más corta para que el driver despache la orden. Para calcular la ruta más corta se emplearán los algoritmos de Dijkstra y Floyd-Warshall.
4.  Administrador
Agregar nuevos locales al sistema: Al ingresar como administrador al sistema, se podrán agregar nuevas empresas que utilizarán los servicios de Samancito Delivery. Dicha empresa debe tener su respectivo menú, es decir, una lista de platos. Además, los locales deben anexarse al grafo seleccionando dos nodos y agregando sus respectivas distancias.
Agregar nuevo camino: El administrador podrá hacer más caminos en el grafo, para esto debe seleccionar los nodos que serán unidos y el tamaño de la arista que los conecta.
Agregar platos: Un usuario con el rol de administrador será capaz de agregar nuevos platillos al menú de un restaurante, para esto seleccionará el restaurante y escribirá el nombre del nuevo plato
Eliminar platos: Luego de realizar un estudio de mercado, los locales pueden decidir eliminar un platillo de su menú por las pocas ganancias que genera al establecimiento.
Requerimientos técnicos
La solución debe ser implementada con base en un grafo, que a su vez puede ser implementado mediante una matriz de adyacencia o una lista de adyacencia.
Puede utilizar cualquier otra estructura auxiliar de ser necesario. Sin embargo, NO podrá utilizar librerías para la implementación de las estructuras de datos, solo podrá utilizar librerías para lo relativo a la representación gráfica del grafo.
El programa debe poder representar el grafo correspondiente de manera gráfica. 
La aplicación debe ofrecer una interfaz gráfica al usuario.
El programa debe poder cargar un archivo de texto para la lectura de datos. Para ello, es requerido el uso del componente JFileChooser.
Debe documentar el proyecto con Javadoc.
Junto al programa, cada equipo deberá presentar un Diagrama de clases (arquitectura detallada) que explique la solución obtenida.  
Archivo de texto
Restaurantes
A,Pizpa,Pizza Margarita/Pasticho/Refresco
B,Sótano Siete,Prosciutto Funghi/Pizza Napoletana/Calzone
C,Avila Burgers,Banquito Burger/Papas Fritas/Aros de Cebolla/ Nestea
D,Buffalo Wings,Papitas Kardashian/Burger Homero/Costillas/Agua
E,Holy Chicken,Holy Chicken/Holy Tempeh/Holy Slaw/Holy Chicken Tenders
Clientes
1,Pepe,Gónzales,234354
2,Stephania,Cominos,24574354
3,Andrea,Stanislao,27385643
4,Josefina,La Sifrina,6547584
5,Rosa,Mosa,574543
6,Eduardo,Petardo,4326534
7,Enrique,Manrique,434543
Pedidos
3,A,2-Pizza Margarita/1-Pasticho
6,E,5-Holy Tempeh/1-Holy Chicken Tenders
1,C,9-Banquito Burger/6-Aros de Cebolla
4,B,3-Prosciutto Funghi
7,D,4-Burger Homero/1-Costillas
Rutas
A,1,3
A,2,2
1,C,2
1,5,8
2,E,2
2,4,4
C,5,3
4,3,2
4,B,6
5,B,3
5,E,7
B,6,7
3,7,1
7,D,4
D,B,1
D,6,5
6,5,5
6,C,6
E,1,1
E,A,1

Consideraciones
Los proyectos podrán ser sometidos a defensa, es decir, el facilitador convocará al equipo para una revisión.
Los equipos de trabajo deberán utilizar GitHub para el control de versiones y facilitar el trabajo en equipo de manera remota. De esta forma, podrán comenzar a crear su portafolio de trabajos, elemento que puede ser importante a la hora de buscar trabajo. En el registro se deberá reflejar la participación activa y significativa de los integrantes.
Los proyectos que no tengan interfaz gráfica, serán calificados con 0 (cero).
Los proyectos que sean iguales o parecidos, serán calificados con 0 (cero).
Los programas que “no corran”, serán calificados con 0 (cero).
Los equipos pueden tener como máximo 3 personas.
Criterios de evaluación
Funcionalidad: Capacidad para proporcionar las funcionalidades que satisfacen las necesidades explícitas e implícitas bajo unas ciertas condiciones. (60%)
Adecuación: El programa ofrece todas funcionalidades que respondan a las necesidades, tanto explícitas (contenidas en el documento descriptivo del proyecto) como implícitas; entendiendo como necesidades implícitas, aquellas que no estando descritas en el documento, surgen como resultado de un concienzudo análisis del problema planteado y que aseguran el correcto funcionamiento del programa.
Exactitud: El programa genera los resultados o efectos correctos o acordados, con el grado necesario de precisión.
Fiabilidad: Capacidad para mantener un nivel especificado de prestaciones cuando se usa bajo ciertas condiciones.
Madurez: El programa no presenta fallas originadas por errores de programación, análisis o diseño. (10%)
Tolerancia a fallos: El programa responde adecuadamente al manejo inadecuado del usuario; es decir, mantiene su correcto funcionamiento aun cuando el usuario introduzca datos erróneos o manipule inadecuadamente las interfaces de usuario. (10%)
Usabilidad: Capacidad del proyecto para ser entendido, aprendido, usado y al mismo tiempo, ser atractivo para el usuario, cuando se usa bajo condiciones específicas.
Comprensibilidad: El programa ofrece una interfaz de fácil comprensión, facilitando su aprendizaje y correcta utilización. El programa emite mensajes de alerta cuando se introducen valores erróneos. Existen elementos informativos que indican al usuario como operar el programa. (5%)
Capacidad de ser atractivo: El diseño de la interfaz de usuario, esto es: disposición de controles, esquema de colores, utilización de cajas de diálogo y demás elementos gráficos; es atractivo para el usuario. (5%)
Eficiencia: Capacidad para proporcionar prestaciones apropiadas, relativas a la cantidad de recursos usados, bajo condiciones determinadas.
Estructuras de datos: Utiliza eficientemente las estructuras de datos para la solución del problema. (10%)
