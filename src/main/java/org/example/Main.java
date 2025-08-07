package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Cristopher");
        Jugador jugador2 = new Jugador("Ertrax");
        List<Jugador> jugadores = new java.util.ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Juego juego = new Juego(jugadores);
        juego.iniciarJuego();
    }
}