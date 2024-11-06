package Grafo;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
    public static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Vertice> VerticeMap = new HashMap<String, Vertice>();

    // Agregar una nueva arista
    public void agregarArista(String nomOrigen, String nomDestino, double cost){
        Vertice v = getVertice(nomOrigen);
        Vertice w = getVertice(nomDestino);
        v.adj.add(new Arista(w, cost));
    }


    private Vertice getVertice(String VerticeName){
        Vertice v = VerticeMap.get(VerticeName);
        if(v == null){
            v = new Vertice(VerticeName);
            VerticeMap.put(VerticeName, v);
        }
        return v;
    }

}
