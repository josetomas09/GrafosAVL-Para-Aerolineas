package Arbol;
class NodoAVL {
    int asiento;
    String tripulante;
    int altura;
    NodoAVL izquierdo, derecho;

    public NodoAVL(int asiento, String tripulante) {
        this.asiento = asiento;
        this.tripulante = tripulante;
        this.altura = 1;
    }
}