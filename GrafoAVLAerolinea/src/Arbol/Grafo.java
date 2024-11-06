package Arbol;

public class Grafo {
    private int[][] precios;
    private String[] destinos;

    public Grafo() {
        destinos = new String[]{"CORDOBA", "BS AS", "JUJUY", "BARILOCHE", "MISIONES", "SALTA", "TUCUMAN", "SANTA CRUZ"};
        precios = new int[destinos.length][destinos.length];
        inicializarPrecios();
    }

    private void inicializarPrecios() {
        for (int i = 0; i < destinos.length; i++) {
            for (int j = 0; j < destinos.length; j++) {
                precios[i][j] = -1;
            }
        }

        precios[0][1] = 120000; // Córdoba -> Buenos Aires
        precios[0][2] = 80000;  // Córdoba -> Jujuy
        precios[0][3] = 200000; // Córdoba -> Bariloche

        precios[1][0] = 150000; // Buenos Aires -> Córdoba
        precios[1][2] = 120000; // Buenos Aires -> Jujuy
        precios[1][3] = 250000; // Buenos Aires -> Bariloche
        precios[1][4] = 200000; // Buenos Aires -> Misiones
        precios[1][7] = 350000; // Buenos Aires -> Santa Cruz

        precios[2][0] = 75000;  // Jujuy -> Córdoba
        precios[2][1] = 120000; // Jujuy -> Buenos Aires
        precios[2][5] = 55000;  // Jujuy -> Salta
        precios[2][6] = 68000;  // Jujuy -> Tucumán

        precios[3][0] = 220000; // Bariloche -> Córdoba
        precios[3][1] = 350000; // Bariloche -> Buenos Aires
        precios[3][7] = 550000; // Bariloche -> Santa Cruz

        precios[4][1] = 170000; // Misiones -> Buenos Aires

        precios[5][0] = 60000;  // Salta -> Córdoba
        precios[5][1] = 110000; // Salta -> Buenos Aires
        precios[5][2] = 80000;  // Salta -> Jujuy
        precios[5][6] = 60000;  // Salta -> Tucumán

        precios[6][0] = 55000;  // Tucumán -> Córdoba
        precios[6][1] = 1250000; // Tucumán -> Buenos Aires
        precios[6][2] = 20000;  // Tucumán -> Jujuy

        precios[7][1] = 380000; // Santa Cruz -> Buenos Aires
        precios[7][3] = 550000; // Santa Cruz -> Bariloche
    }

    public int obtenerPrecio(String origen, String destino, int ocupacion) {
        int iOrigen = getIndiceDestino(origen);
        int iDestino = getIndiceDestino(destino);
        if (iOrigen == -1 || iDestino == -1 || precios[iOrigen][iDestino] == -1) {
            throw new IllegalArgumentException("Ruta no válida entre " + origen + " y " + destino);
        }
        return calcularPrecio(precios[iOrigen][iDestino], ocupacion);
    }


    private int calcularPrecio(int precioBase, int ocupacion) {
        if (ocupacion >= 100) return (int) (precioBase * 0.6); // 40% descuento
        if (ocupacion >= 70) return (int) (precioBase * 0.8);  // 20% descuento
        if (ocupacion >= 50) return (int) (precioBase * 0.9);  // 10% descuento
        return precioBase; // Sin descuento
    }


    private int getIndiceDestino(String destino) {
        for (int i = 0; i < destinos.length; i++) {
            if (destinos[i].equalsIgnoreCase(destino)) return i;
        }
        return -1;
    }

    public String vueloMasBarato(int origen, int destino, int ocupacion) {
        if (origen < 0 || origen >= destinos.length || destino < 0 || destino >= destinos.length) {
            throw new IllegalArgumentException("Índices de origen o destino no válidos.");
        }
        int precio = obtenerPrecio(destinos[origen], destinos[destino], ocupacion);
        return "El vuelo más barato de " + destinos[origen] + " a " + destinos[destino] + " cuesta: $" + precio;
    }

    public static String getDestino(int indice) {
        String[] destinos = {"CORDOBA", "BS AS", "JUJUY", "BARILOCHE", "MISIONES", "SALTA", "TUCUMAN", "SANTA CRUZ"};
        return destinos[indice];
    }
}
