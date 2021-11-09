package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    void getCname(){
        zweiteKlasse m = new zweiteKlasse("danja",1);
        assertEquals("danja", m.getCname());
    }


    @Test
    void getCzahl(){
        zweiteKlasse m = new zweiteKlasse("danja",1);
        assertEquals(1, m.getCzahl(), 0.001);
    }


    private final zweiteKlasse t = new zweiteKlasse("danja",8);

    @Test
    public void test1() {

        assertTrue(t.i == 5) ; //t.i ist 5 --> true
        //assertTrue(zweiteKlasse.methode(eingabe,eingabe) == Ausgabe) berechnung soll dem Ergebnis entsprechen
        assertEquals(5, t.i); //t.i entspricht 5 --> true

    }



    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }
}