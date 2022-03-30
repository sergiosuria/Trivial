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

        String expected = "La nueva posición de Maria es 0";

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
        Game sut = new Game("Maria","Juan","Pepe", "Carlos", "Lara", "Yo");
        boolean actual = sut.esJugable();

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void un_jugador_que_falla_va_a_la_carcel() throws Exception{
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);
        sut.respuestaIncorrecta();

        boolean actual = sut.estaEnCarcel("Maria");

        Assertions.assertTrue(actual);

    }
    @Test
    public void un_jugador_en_la_carcel_que_acierta_sale_de_la_carcel() throws Exception{
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);
        sut.respuestaIncorrecta();

        sut.tirarDado(1);
        sut.respuestaCorrecta();

        sut.tirarDado(1);

        boolean actual = sut.estaEnCarcel("Maria");

        Assertions.assertFalse(actual);
    }
    @Test
    public void con_respuesta_incorrecta_nunca_se_gana() throws Exception{
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);

        boolean esGanador = sut.respuestaIncorrecta();

        Assertions.assertFalse(esGanador);
    }

    @Test
    public void estando_en_la_carcel_nunca_se_gana() throws Exception{
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);
        sut.respuestaIncorrecta();
        sut.tirarDado(1);
        sut.respuestaCorrecta();
        boolean esGanador = sut.respuestaCorrecta();
        Assertions.assertFalse(esGanador);

    }

    @Test
    public  void si_no_estoy_en_la_carcel_y_tengo_menos_de_6_monedas_no_gano() throws Exception{
        Game sut = new Game("Maria", "Juan");
        sut.tirarDado(1);
        boolean esGanador = sut.respuestaCorrecta();
        Assertions.assertFalse(esGanador);

    }

    @Test
    public void si_no_estoy_en_la_carcel_y_tengo_6_monedas_gano() throws Exception{
        Game sut = new Game("Maria", "Juan");
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);

        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertTrue(esGanador);


    }

    private void AciertaMaria_FallaJuan(Game sut) throws Exception {
        sut.tirarDado(1);
        sut.respuestaCorrecta();

        sut.tirarDado(1);
        sut.respuestaIncorrecta();
    }
    private void FallaMaria_FallaJuan(Game sut) throws Exception {
        sut.tirarDado(1);
        sut.respuestaIncorrecta();

        sut.tirarDado(1);
        sut.respuestaIncorrecta();
    }

    @Test
    public void si_estoy_saliendo_de_la_carcel_y_tengo_6_monedas_gano() throws Exception{
        Game sut = new Game("Maria", "Juan");
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        AciertaMaria_FallaJuan(sut);
        FallaMaria_FallaJuan(sut);

        sut.tirarDado(1);
        boolean esGanador = sut.respuestaCorrecta();

        Assertions.assertTrue(esGanador);
    }
}
