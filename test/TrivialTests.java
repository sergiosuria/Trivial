import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {
    @Test
    public void true_is_true(){
        Assertions.assertTrue(true);
    }

    @Test
    public void crear_Game(){
        Game trivial = new Game();
    }
    @Test
    public void si_al_principio_saco_un_1_voy_a_casilla_1() throws Exception {
        Game sut = new Game();
        sut.agregar("Maria");
        sut.agregar("Juan");

        sut.tirarDado(1);

        String expected = "La nueva posición de María es 1";

        String actual = sut.nuevaPosicionJugador();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void partida_con_un_jugador_no_es_jugable(){
        Game sut = new Game();
        sut.agregar("Maria");
        boolean actual = sut.esJugable();

        Assertions.assertEquals(false,actual);
    }

    @Test
    public void partida_con_dos_jugadores_si_es_jugable(){
        Game sut = new Game();
        sut.agregar("Maria");
        sut.agregar("Juan");

        boolean actual = sut.esJugable();

        Assertions.assertEquals(true,actual);
    }
    @Test
    public void partida_con_un_jugador_no_puede_tirar_dado() throws Exception{
        Game sut = new Game();
        sut.agregar("Maria");

        Assertions.assertThrows(
                Exception.class,
                ()->sut.tirarDado(1),
                "Debe haber al menos dos jugadores");

    }

    @Test
    public void crear_partida_con_dos_jugadores_es_jugable(){
        Game sut = new Game("Maria","Juan","Pepe", "Carlos");
        boolean actual = sut.esJugable();

        Assertions.assertEquals(true, actual);
    }
}
