package org.example;

public class Carta {
    private String pinta;
    private String simbolo;
    private int valor;

    public Carta(String pinta, String simbolo, int valor) {
        this.pinta = pinta;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "pinta='" + pinta + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
