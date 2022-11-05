package model;

import model.Nodo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo<T> {
    private ArrayList<Nodo<T>> grafo;

    public ArrayList<Nodo<T>> getGrafo() {
        return grafo;
    }

    public void setGrafo(ArrayList<Nodo<T>> grafo) {
        this.grafo = grafo;
    }

    public Grafo() {
        grafo = new ArrayList<>();
    }

    public void addElement(T val) {
        grafo.add(new Nodo<T>(val));
    }

    public void addAdjacency(T val1, T val2) {
        Nodo<T> a = search(val1);
        Nodo<T> b = search(val2);

        if (a != null && b != null) {
            Nodo<T> c = search(val1);
            Nodo<T> d = search(val2);
            c.getAdyacentes().add(d);
        }
    }

    public Nodo<T> search(T element) {
        for (Nodo<T> g : grafo) {
            if (g.getVal().equals(element)) {
                return g;
            }
        }
        return null;
    }

    public boolean Bfs(T element) {
        Nodo<T> nodo = search(element);
            for (Nodo u : grafo) {
                u.setColor("White");
                u.setDistance(0);
                u.setFather(null);
            }
        nodo.setColor("Gray");
        nodo.setDistance(0);
        nodo.setFather(null);
        Queue<Nodo<T>> queueNodos = new LinkedList<>();
        queueNodos.add(nodo);
        while (!queueNodos.isEmpty()) {
            Nodo<T> nodoCola = queueNodos.poll();
            for (Nodo<T> v : nodoCola.getAdyacentes()) {
                if (v.getColor().equalsIgnoreCase("White")) {
                    v.setColor("Gray");
                    v.setDistance(nodoCola.getDistance() + 1);
                    v.setFather(nodoCola);
                    queueNodos.add(v);
                }
            }
            nodoCola.setColor("Black");
        }
        for (Nodo<T> g : grafo) {
            if (g.getColor().equalsIgnoreCase("White")) {
                return false;
            }
        }
        return true;
    }

    public boolean stronglyConnected(){
        for (Nodo<T> u : grafo) {
            if (!Bfs(u.getVal())){
                return false;
            }
        }
        return true;
    }

}
