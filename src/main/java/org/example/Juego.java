package org.example;

import java.util.List;
import java.util.Scanner;

public class Juego {
    private List<Jugador> jugadores;
    private Mazo mazo;
    private Jugador dealer;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.mazo = new Mazo();
        this.dealer = new Jugador("Dealer");
    }

    public void iniciarJuego() {
        // Repartir dos cartas a cada jugador
        for (Jugador jugador : jugadores) {
            jugador.recibirCarta(mazo.repartirCarta());
            jugador.recibirCarta(mazo.repartirCarta());
        }
        // Repartir dos cartas al dealer
        dealer.recibirCarta(mazo.repartirCarta());
        dealer.recibirCarta(mazo.repartirCarta());
        // Mostrar la mano de cada jugador
        for (Jugador jugador : jugadores) {
            jugador.mostrarMano();
            System.out.println("Puntaje: " + jugador.calcularPuntaje());
            System.out.println();
        }
        // Mostrar la mano del dealer
        dealer.mostrarMano();
        System.out.println("Puntaje: " + dealer.calcularPuntaje());
        System.out.println();
        
        // Turno de los jugadores
        turnoJugadores();
        
        // Turno del dealer
        turnoDealer();
        
        // Determinar ganadores
        determinarGanadores();
    }
    
    public void turnoJugadores() {
        Scanner scanner = new Scanner(System.in);
        
        for (Jugador jugador : jugadores) {
            System.out.println("=== Turno de " + jugador.getNombre() + " ===");
            
            while (jugador.calcularPuntaje() < 21) {
                jugador.mostrarMano();
                System.out.println("Puntaje actual: " + jugador.calcularPuntaje());
                System.out.print("¿Quieres pedir carta? (s/n): ");
                String respuesta = scanner.nextLine().toLowerCase();
                
                if (respuesta.equals("s") || respuesta.equals("si")) {
                    Carta nuevaCarta = mazo.repartirCarta();
                    jugador.recibirCarta(nuevaCarta);
                    System.out.println("Nueva carta: " + nuevaCarta);
                    
                    if (jugador.calcularPuntaje() > 21) {
                        System.out.println("¡Te pasaste de 21! Puntaje: " + jugador.calcularPuntaje());
                        break;
                    }
                } else {
                    System.out.println("Te plantas con " + jugador.calcularPuntaje() + " puntos.");
                    break;
                }
            }
            System.out.println();
        }
    }
    
    public void turnoDealer() {
        System.out.println("=== Turno del Dealer ===");
        dealer.mostrarMano();
        System.out.println("Puntaje actual: " + dealer.calcularPuntaje());
        
        while (dealer.calcularPuntaje() < 17) {
            Carta nuevaCarta = mazo.repartirCarta();
            dealer.recibirCarta(nuevaCarta);
            System.out.println("Dealer pide carta: " + nuevaCarta);
            System.out.println("Nuevo puntaje: " + dealer.calcularPuntaje());
        }
        
        if (dealer.calcularPuntaje() > 21) {
            System.out.println("¡Dealer se pasó de 21! Puntaje: " + dealer.calcularPuntaje());
        } else {
            System.out.println("Dealer se planta con " + dealer.calcularPuntaje() + " puntos.");
        }
        System.out.println();
    }
    
    public void determinarGanadores() {
        System.out.println("=== RESULTADOS ===");
        int puntajeDealer = dealer.calcularPuntaje();
        
        for (Jugador jugador : jugadores) {
            int puntajeJugador = jugador.calcularPuntaje();
            System.out.println(jugador.getNombre() + ": " + puntajeJugador + " puntos");
            
            if (puntajeJugador > 21) {
                System.out.println("❌ " + jugador.getNombre() + " se pasó de 21 - PIERDE");
                jugador.perderPartida();
            } else if (puntajeDealer > 21) {
                System.out.println("✅ " + jugador.getNombre() + " GANA (Dealer se pasó)");
                jugador.ganarPartida();
            } else if (puntajeJugador > puntajeDealer) {
                System.out.println("✅ " + jugador.getNombre() + " GANA");
                jugador.ganarPartida();
            } else if (puntajeJugador < puntajeDealer) {
                System.out.println("❌ " + jugador.getNombre() + " PIERDE");
                jugador.perderPartida();
            } else {
                System.out.println("🤝 " + jugador.getNombre() + " EMPATA");
            }
            System.out.println();
        }
        
        System.out.println("Dealer: " + puntajeDealer + " puntos");
    }
}
