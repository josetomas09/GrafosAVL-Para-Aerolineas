package Arbol;

public class ArbolAVL {
    private Nodo raiz;

    private class Nodo {
        Tripulante tripulante;
        Nodo izquierdo;
        Nodo derecho;
        int altura;

        public Nodo(Tripulante tripulante) {
            this.tripulante = tripulante;
            this.izquierdo = this.derecho = null;
            this.altura = 1;
        }
    }

    public void insertar(int asiento, String nombre) {
        Tripulante nuevoTripulante = new Tripulante(asiento, nombre);
        raiz = insertar(raiz, nuevoTripulante);
    }

    private Nodo insertar(Nodo nodo, Tripulante tripulante) {
        if (nodo == null) {
            return new Nodo(tripulante);
        }

        if (tripulante.getAsiento() < nodo.tripulante.getAsiento()) {
            nodo.izquierdo = insertar(nodo.izquierdo, tripulante);
        } else if (tripulante.getAsiento() > nodo.tripulante.getAsiento()) {
            nodo.derecho = insertar(nodo.derecho, tripulante);
        } else {
            return nodo;
        }

        actualizarAltura(nodo);
        return balancear(nodo);
    }

    private Nodo balancear(Nodo nodo) {
        int factorBalance = obtenerFactorBalance(nodo);

        if (factorBalance > 1) {
            if (obtenerFactorBalance(nodo.izquierdo) >= 0) {
                return rotacionDerecha(nodo);
            }
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (factorBalance < -1) {
            if (obtenerFactorBalance(nodo.derecho) <= 0) {
                return rotacionIzquierda(nodo);
            }
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    // Rotación simple a la derecha
    private Nodo rotacionDerecha(Nodo nodo) {
        Nodo nuevoRaiz = nodo.izquierdo;
        nodo.izquierdo = nuevoRaiz.derecho;
        nuevoRaiz.derecho = nodo;
        actualizarAltura(nodo);
        actualizarAltura(nuevoRaiz);
        return nuevoRaiz;
    }

    // Rotación simple a la izquierda
    private Nodo rotacionIzquierda(Nodo nodo) {
        Nodo nuevoRaiz = nodo.derecho;
        nodo.derecho = nuevoRaiz.izquierdo;
        nuevoRaiz.izquierdo = nodo;
        actualizarAltura(nodo);
        actualizarAltura(nuevoRaiz);
        return nuevoRaiz;
    }

    private int obtenerFactorBalance(Nodo nodo) {
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }

    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private void actualizarAltura(Nodo nodo) {
        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));
    }

    // Imprimir los tripulantes in-order
    public void imprimirTripulantes() {
        imprimirInOrden(raiz);
    }

    // Imprimir los tripulantes en orden
    private void imprimirInOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.izquierdo);
            System.out.println("Asiento: " + nodo.tripulante.getAsiento() + " - Nombre: " + nodo.tripulante.getNombre());
            imprimirInOrden(nodo.derecho);
        }
    }
}