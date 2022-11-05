package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

    private Grafo<String> directedGrafo;

    private void setUp1() {
        directedGrafo = new Grafo();
    }

    @Test
    public void test1() {
        directedGrafo = new Grafo();

        directedGrafo.addElement("a");
        directedGrafo.addElement("b");
        directedGrafo.addElement("c");
        directedGrafo.addElement("d");
        directedGrafo.addElement("e");

        directedGrafo.addAdjacency("a", "c");
        directedGrafo.addAdjacency("c", "d");
        directedGrafo.addAdjacency("d", "e");
        directedGrafo.addAdjacency("e", "d");
        directedGrafo.addAdjacency("d", "b");
        directedGrafo.addAdjacency("b", "a");
        assertTrue(directedGrafo.stronglyConnected());
    }

    @Test
    public void test2(){
        setUp1();
        directedGrafo.addElement("u");
        directedGrafo.addElement("s");
        directedGrafo.addElement("i");

        directedGrafo.addAdjacency("s", "i");

        assertFalse(directedGrafo.stronglyConnected());
    }

    @Test
    public void test3(){
        setUp1();
        directedGrafo.addElement("a");
        directedGrafo.addElement("b");
        directedGrafo.addElement("c");
        directedGrafo.addElement("d");

        directedGrafo.addAdjacency("a", "b");
        directedGrafo.addAdjacency("b", "c");
        directedGrafo.addAdjacency("c", "d");
        directedGrafo.addAdjacency("d", "a");

        assertTrue(directedGrafo.stronglyConnected());
    }
}