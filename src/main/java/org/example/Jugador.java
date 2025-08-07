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
    
    public void mostrarManoVisual() {
        System.out.println("Mano de " + nombre + ":");
        if (mano.isEmpty()) {
            System.out.println("Sin cartas");
            return;
        }
        
        // Obtener las líneas de cada carta
        String[] lineasCartas = new String[7];
        for (int i = 0; i < 7; i++) {
            lineasCartas[i] = "";
        }
        
        for (Carta carta : mano) {
            String[] lineasCarta = carta.toVisualString().split("\n");
            for (int i = 0; i < 7; i++) {
                lineasCartas[i] += lineasCarta[i] + " ";
            }
        }
        
        // Imprimir las cartas
        for (String linea : lineasCartas) {
            System.out.println(linea);
        }
    }

    public void limpiarMano() {
        mano.clear();
    }
}
