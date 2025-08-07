package org.example;

import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private Mazo mazo;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
    }

    public void iniciarJuego() {
        // Repartir dos cartas a cada jugador
        for (Jugador jugador : jugadores) {
            jugador.recibirCarta(mazo.repartirCarta());
            jugador.recibirCarta(mazo.repartirCarta());
        }
        // Mostrar la mano de cada jugador
        for (Jugador jugador : jugadores) {
            jugador.mostrarMano();
            System.out.println("Puntaje: " + jugador.calcularPuntaje());
            System.out.println();
        }
    }
}
