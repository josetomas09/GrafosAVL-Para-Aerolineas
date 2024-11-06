package Arbol;

import java.util.Random;

public class Vuelo {
    private int origen;
    private int destino;
    private ArbolAVL tripulacion;
    private int ocupacion;

    public Vuelo(int origen, int destino) {
        this.origen = origen;
        this.destino = destino;
        this.tripulacion = new ArbolAVL();
        this.ocupacion = 0;
    }

    public void registrarTripulante(String nombreTripulante) {
        Random rand = new Random();
        int asiento = rand.nextInt(100) + 1;
        tripulacion.insertar(asiento, nombreTripulante);
        ocupacion += 10;
    }

    public String obtenerVueloMasBarato() {
        Grafo grafo = new Grafo();
        return grafo.vueloMasBarato(origen, destino, ocupacion);
    }

    public void imprimirTripulantes() {
        System.out.println("Tripulantes del vuelo de " + Grafo.getDestino(origen) + " a " + Grafo.getDestino(destino) + ":");
        tripulacion.imprimirTripulantes();
    }

    public int getOcupacion() {
        return ocupacion;
    }
}
