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
Aquí podríamos seguir el mismo enfoque del problema anterior, pero como ahora tenemos un número dejugadores delimitado entre 2 y 6, y no son muchas combinaciones, lo que haremos será crear tantosconstructores de la clase Game como posibles jugadores.Esto nos obliga por diseño a tener un número correcto de jugadores
Cuando llegamos al constructor para 6 jugadores y ejecutamos el test nos encontramos con que hay un bugen la aplicación.
Lo que está ocurriendo es que los arrays “posiciones”, “monederos” y “enCasillaCastigo” se estáninicializando con un tamaño fijo de 6.
