package com.company;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    zweiteKlasse gehirn;

    @BeforeEach //setup vor jedem Test
    void setUp() {
        gehirn = new zweiteKlasse("danja",8);
    }


    @Test
    @DisplayName("Einmal Multiplikation testen 4mal5")
    void testMultiply() {
        assertEquals(20, gehirn.malmal(4, 5), "Sollte normal 20 ergeben");
    }


    @RepeatedTest(5) //fünfmal geprüft
    @DisplayName("mehrfaches Ausrechenen von 0mal5")
    void testMultiplyWithZero() {
        assertEquals(0, gehirn.malmal(0, 5), "0mal was sollte 0 ergeben");
    }



    public static int[][] data() {
        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } }; //m1 * m2 = expected
    }

    @ParameterizedTest
    @MethodSource(value =  "data") //das ergebnis der methode "data" wird eingefügt
    void testWithStringParameter(int[] data) { //array verwenden
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, gehirn.malmal(m1, m2));
    }


    @ParameterizedTest
    @DisplayName("Input großschreiben-Test")
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase(); //input wird großgeschrieben
        assertEquals(expected, actualValue);
    }



    @ParameterizedTest
    @DisplayName("Es ist nicht -null-")
    @ValueSource(strings = {"Hello", "World"}) //string, int, double
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }



    @ParameterizedTest
    @DisplayName("ArgumentsSource Test hier")
    @ArgumentsSource(Argumenten.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }

    public static class Argumenten implements ArgumentsProvider { //interne Klasse mit static (ohne Objektbildung)

        @Override
        public Stream<? extends Arguments> provideArguments (ExtensionContext context){
            return Stream.of("apple", "banana").map(Arguments::of);
        }

    }


    @Test //HIER ####
    @DisplayName("Name des Tests")
    @Disabled("Nur zur Info hier")
    void methodenname(){
        //Arrange: Startzustand "gegeben";
        gehirn.setCname("Danja");
        gehirn.setCzahl(20);
        //Act: Methodenaufruf
        gehirn.malmal(1,1);
        //Assert: erzieltes Ergebnis erreicht?;
        assertEquals("danja", gehirn.getCname()); //assertTrue, assertNotNull;
    }


    @DisplayName("get Cname Test")
    @Test
    void getCname(){

        zweiteKlasse m = new zweiteKlasse("danja",1);

        assertEquals("danja", m.getCname());

    }

    @DisplayName("get Czahl Test")
    @Test
    void getCzahl(){

        zweiteKlasse m = new zweiteKlasse("danja",1);

        assertEquals(1, m.getCzahl(), 0.001);

    }

    @DisplayName("ist gehirn.i = 5? \uD83D\uDE31")
    @Test
    public void test1() {

        //assertTrue(gehirn.i == 5) ; //t.i ist 5 --> true
        //assertTrue(zweiteKlasse.methode(eingabe,eingabe) == Ausgabe) berechnung soll dem Ergebnis entsprechen
        assertEquals(5, gehirn.i); //t.i entspricht 5 --> true


    }



    @AfterEach
    void cleanUpAll() {
        System.out.println("cleanUpAll()");
        //server.close();
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("cleanUp()");
    }

}