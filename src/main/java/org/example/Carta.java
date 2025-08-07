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

    public String getSimbolo() {
        return simbolo;
    }
    
    public String getPinta() {
        return pinta;
    }
    
    public String toVisualString() {
        String simboloPinta = "";
        switch (pinta) {
            case "Corazones":
                simboloPinta = "C";
                break;
            case "Diamantes":
                simboloPinta = "D";
                break;
            case "Tréboles":
                simboloPinta = "T";
                break;
            case "Picas":
                simboloPinta = "P";
                break;
        }
        
        String simboloCarta = simbolo;
        if (simbolo.length() == 1) {
            simboloCarta = " " + simbolo;
        }
        
        return "┌─────────┐\n" +
               "│ " + simboloCarta + "      │\n" +
               "│         │\n" +
               "│    " + simboloPinta + "    │\n" +
               "│         │\n" +
               "│      " + simboloCarta + " │\n" +
               "└─────────┘";
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
