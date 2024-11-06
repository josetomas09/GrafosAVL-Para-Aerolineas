import Arbol.Vuelo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vuelo vueloCordobaBsAs = new Vuelo(0, 1); // Córdoba -> Buenos Aires
        Vuelo vueloBsAsJujuy = new Vuelo(1, 2); // Buenos Aires -> Jujuy

        vueloCordobaBsAs.registrarTripulante("Juan Pérez");
        vueloCordobaBsAs.registrarTripulante("Ana Gómez");

        vueloBsAsJujuy.registrarTripulante("Luis Fernández");

        vueloCordobaBsAs.imprimirTripulantes();

        System.out.println(vueloCordobaBsAs.obtenerVueloMasBarato());

        System.out.println(vueloBsAsJujuy.obtenerVueloMasBarato());
    }
}