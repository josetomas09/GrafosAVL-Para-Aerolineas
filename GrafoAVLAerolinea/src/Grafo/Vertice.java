package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    public String name;
    public List<Arista> adj;
    public double dist;

    public Vertice(String nm){
        name = nm;
        adj = new ArrayList<>();
        reset();
    }
    public void reset(){
        dist = Grafo.INFINITY;
    }
}
