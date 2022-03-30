# Trivial

## Problema 0

Extraemos el codigo duplicado a un unico metodo "nuevaPosicionJugador" al que llamamos desde ambos sitios.
Creamos test unitario "si_al_principio_saco_un_1_voy_a_casilla_1"

## Problema 1
En el código ya existe un
método “esJugable” que
comprueba si hay más de 2 
jugadores.Creamos 2 tests 
para ese método, y desde 
“tirar dado” hacemos la 
comprobación y si solo hay
1 jugadordevolvemos una 
excepción. También hacemos un test para verificar el lanzamiento de la excepción

## Problema 2
Aquí podríamos seguir el mismo enfoque del problema anterior, pero como ahora tenemos un número de jugadores delimitado entre 2 y 6, y no son muchas combinaciones, lo que haremos será crear tantos constructores de la clase Game como posibles jugadores. Esto nos obliga por diseño a tener un número correcto de jugadores.
Cuando llegamos al constructor para 6 jugadores y ejecutamos el test nos encontramos con que hay un bug en la aplicación.
Lo que está ocurriendo es que los arrays “posiciones”, “monederos” y “enCasillaCastigo” se están inicializando con un tamaño fijo de 6.

## Problema 3
Un jugador va a la cárcel cuando falla una pregunta. Vamos a verificarlo con un test.
No tenemos ningún método que nos indique si dado un jugador, éste está en la cárcel, así que vamos a crear mediante TDD.
Ahora hacemos un nuevo test para verificar que el jugador sale de la cárcel tras sacar un número impar en la tirada.
Ahora tenemos que ir a la clase Game y cambiar en “enCasillaCastigo[jugadorActual] = true” por un false.

##Problema 4
Los nombres y contenidos de variables y funciones que indican si un jugador ha ganado eran incorrectos o retorcidos. Arreglamos la manera de llamar a las funciones y variables para invertir la logica y lo verificamos con los tests.

## Problema 5
Extraemos el metodo repetido y le ponemos el nombre "siguienteTurno" para evitar la redundancia

