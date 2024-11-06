package Arbol;

public class Tripulante {
    private int asiento;
    private String nombre;

    public Tripulante(int asiento, String nombre) {
        this.asiento = asiento;
        this.nombre = nombre;
    }

    public int getAsiento() {
        return asiento;
    }

    public String getNombre() {
        return nombre;
    }
}