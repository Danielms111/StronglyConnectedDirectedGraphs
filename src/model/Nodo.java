package model;

import java.util.ArrayList;

public class Nodo<T> {
    private T val;
    private String color;

    private int distance;
    private ArrayList<Nodo<T>> adyacentes;
    private Nodo<T> father;

    public Nodo(T val) {
        this.val = val;
        color = "White";
        adyacentes = new ArrayList<>();
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Nodo<T>> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Nodo<T>> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public Nodo<T> getFather() {
        return father;
    }

    public void setFather(Nodo<T> father) {
        this.father = father;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
