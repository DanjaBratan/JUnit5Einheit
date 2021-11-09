package com.company;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    zweiteKlasse gehirn;

    @BeforeEach //setup vor dem Test
    void setUp() {
        gehirn = new zweiteKlasse("danja",8);
    }


    @Test
    @DisplayName("Einmal Multiplikation testen 4mal5")
    void testMultiply() {
        assertEquals(20, gehirn.malmal(4, 5),
                "Sollte normal 20 ergeben");
    }


    @RepeatedTest(5) //fünfmal geprüft
    @DisplayName("mehrfaches Ausrechenen von 0mal5")
    void testMultiplyWithZero() {
        assertEquals(0, gehirn.malmal(0, 5), "0mal was sollte 0 ergeben");
    }



    public static int[][] data() {
        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }

    @ParameterizedTest
    @MethodSource(value =  "data") //das ergebnis der methode "data" wird eingefügt
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, gehirn.malmal(m1, m2));
    }


    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }


    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"}) //string, int, double
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }


    //@Test
    // void methodenname(){
        // Arrange: Startzustand "gegeben"
        // String erwartet = "Danja";
        // Act: Methodenaufruf
        // names.add("Danja");
        // Assert: erzieltes Ergebnis erreicht?
        // assertEquals("danja", m.getCname()); assertTrue, assertNotNull
        //
    //}



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


    //private final zweiteKlasse t = new zweiteKlasse("danja",8);

    @Test
    public void test1() {

        //assertTrue(gehirn.i == 5) ; //t.i ist 5 --> true

        //assertTrue(zweiteKlasse.methode(eingabe,eingabe) == Ausgabe) berechnung soll dem Ergebnis entsprechen
        assertEquals(5, gehirn.i); //t.i entspricht 5 --> true


    }






    @AfterEach
    void tearDown() {

    }
}