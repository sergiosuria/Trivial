package smellytrivial;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList jugadores = new ArrayList();
    int[] posiciones = new int[6];
    int[] monederos = new int[6];
    boolean[] enCasillaCastigo = new boolean[6];

    LinkedList preguntasCultura = new LinkedList();
    LinkedList preguntasCiencias = new LinkedList();
    LinkedList preguntasDeportes = new LinkedList();
    LinkedList preguntasMusica = new LinkedList();

    int jugadorActual = 0;
    boolean estaSaliendoDeLaCarcel;

    public Game() {
        for (int i = 0; i < 50; i++) {
            preguntasCultura.addLast("Pregunta de Cultura " + i);
            preguntasCiencias.addLast(("Pregunta de Ciencias " + i));
            preguntasDeportes.addLast(("Pregunta de Deportes " + i));
            preguntasMusica.addLast(crearPreguntaMusica(i));
        }
    }

    public Game(String nombreJugador1, String nombreJugador2) {
        agregar(nombreJugador1);
        agregar(nombreJugador2);

    }

    public Game(String nombreJugador1, String nombreJugador2, String nombreJugador3) {
        this(nombreJugador1, nombreJugador2);
        agregar(nombreJugador3);
    }

    public Game(String nombreJugador1, String nombrejugador2, String nombreJugador3, String nombreJugador4) {
        this(nombreJugador1, nombrejugador2, nombreJugador3);
        agregar(nombreJugador4);
    }

    public Game(String nombreJugador1, String nombreJugador2, String nombreJugador3, String nombreJugador4, String nombreJugador5) {
        this(nombreJugador1, nombreJugador2, nombreJugador3, nombreJugador4);
        agregar(nombreJugador5);
    }

    public Game(String nombreJugador1, String nombrejugador2, String nombreJugador3, String nombreJugador4, String nombreJugador5, String nombreJugador6) {
        this(nombreJugador1, nombrejugador2, nombreJugador3, nombreJugador4, nombreJugador5);
        agregar(nombreJugador6);
    }

    public String crearPreguntaMusica(int index) {
        return "Pregunta de Música " + index;
    }

    public boolean esJugable() {
        return (cuantosJugadores() >= 2);
    }

    public boolean agregar(String playerName) {


        jugadores.add(playerName);
        posiciones[cuantosJugadores() - 1] = 0;
        monederos[cuantosJugadores() - 1] = 0;
        enCasillaCastigo[cuantosJugadores() - 1] = false;

        System.out.println(playerName + " se ha unido a la partida");
        System.out.println("Es el jugador número " + jugadores.size());
        return true;
    }

    public int cuantosJugadores() {
        return jugadores.size();
    }

    public void tirarDado(int puntosDado) throws Exception {
        if (!esJugable()) {
            throw new Exception("Debe haber al menos dos jugadores");
        }
            System.out.println(jugadores.get(jugadorActual) + " es el jugador actual");
            System.out.println("Ha sacado un " + puntosDado);

            if (enCasillaCastigo[jugadorActual]) {
                if (puntosDado % 2 != 0) {
                    estaSaliendoDeLaCarcel = true;
                    enCasillaCastigo[jugadorActual] = false;

                } else {
                    System.out.println(jugadores.get(jugadorActual) + " no sale de la casilla de castigo");
                    estaSaliendoDeLaCarcel = false;
                }
            }
        }


    public String nuevaPosicionJugador() {
        return ("La nueva posición de "
                + jugadores.get(jugadorActual)
                + " es "
                + posiciones[jugadorActual]);
    }


    private void hacerPregunta() {
        if (categoriaActual() == "Cultura popular")
            System.out.println(preguntasCultura.removeFirst());
        if (categoriaActual() == "Ciencias")
            System.out.println(preguntasCiencias.removeFirst());
        if (categoriaActual() == "Deportes")
            System.out.println(preguntasDeportes.removeFirst());
        if (categoriaActual() == "Música")
            System.out.println(preguntasMusica.removeFirst());
    }


    private String categoriaActual() {
        if (posiciones[jugadorActual] == 0) return "Cultura popular";
        if (posiciones[jugadorActual] == 4) return "Cultura popular";
        if (posiciones[jugadorActual] == 8) return "Cultura popular";
        if (posiciones[jugadorActual] == 1) return "Ciencias";
        if (posiciones[jugadorActual] == 5) return "Ciencias";
        if (posiciones[jugadorActual] == 9) return "Ciencias";
        if (posiciones[jugadorActual] == 2) return "Deportes";
        if (posiciones[jugadorActual] == 6) return "Deportes";
        if (posiciones[jugadorActual] == 10) return "Deportes";
        return "Música";
    }

    public boolean respuestaCorrecta() {
        if (enCasillaCastigo[jugadorActual]) {
            if (estaSaliendoDeLaCarcel) {
                System.out.println("Respuesta correcta!!!!");
                monederos[jugadorActual]++;
                System.out.println(jugadores.get(jugadorActual)
                        + " ahora tiene "
                        + monederos[jugadorActual]
                        + " monedas doradas.");

                boolean ganador = jugadorHaGanado();
                siguienteTurno();

                return ganador;
            } else {
                siguienteTurno();
                return false;
            }


        } else {

            System.out.println("Respuesta correcta!!!!");
            monederos[jugadorActual]++;
            System.out.println(jugadores.get(jugadorActual)
                    + " ahora tiene "
                    + monederos[jugadorActual]
                    + " monedas doradas.");

            boolean ganador = jugadorHaGanado();
            siguienteTurno();

            return ganador;
        }
    }

    private void siguienteTurno() {
        jugadorActual++;
        if (jugadorActual == jugadores.size()) jugadorActual = 0;
    }

    public boolean respuestaIncorrecta() {
        System.out.println("Respuesta incorrecta");
        System.out.println(jugadores.get(jugadorActual) + " va a la casilla de castigo");
        enCasillaCastigo[jugadorActual] = true;

        siguienteTurno();
        return false;
    }


    private boolean jugadorHaGanado() {
        return (monederos[jugadorActual] == 6);
    }

    public boolean estaEnCarcel(String nombreJugador) {
        int indiceJugador = jugadores.indexOf(nombreJugador);
        return enCasillaCastigo[indiceJugador];
    }
}
