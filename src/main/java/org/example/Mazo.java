package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] pintas = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] simbolos = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] valores = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String pinta : pintas) {
            for (int i = 0; i < simbolos.length; i++) {
                cartas.add(new Carta(pinta, simbolos[i], valores[i]));
            }
        }

        barajar();
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta repartirCarta() {
        return cartas.remove(0);
    }
}
