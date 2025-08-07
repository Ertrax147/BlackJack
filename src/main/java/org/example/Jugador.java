package org.example;


import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> mano;
    private int partidasGanadas;
    private int partidasPerdidas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        for (Carta carta : mano) {
            puntaje += carta.getValor();
        }
        return puntaje;
    }

    public void ganarPartida() {
        partidasGanadas++;
    }

    public void perderPartida() {
        partidasPerdidas++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void mostrarMano() {
        System.out.println("Mano de " + nombre + ":");
        mano.forEach(System.out::println);
    }

    public void limpiarMano() {
        mano.clear();
    }
}
