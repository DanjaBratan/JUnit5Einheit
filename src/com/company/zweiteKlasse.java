package com.company;

public class zweiteKlasse {

    private double czahl;
    private String cname;
    int i = 5; //die eingentliche Ausgabe
    String j = "4";


    public zweiteKlasse(String cname, double czahl) {

        this.cname = cname; //name wird zu dem Objekt geordnet
        this.czahl = czahl; //zahl wird zu dem Objekt geordnet

        int ergebnis = malmal(3,6);
        System.out.print(ergebnis);
    }


    public String getCname() { //abfragen des namens
        return cname;
    }

    public void setCname(String name) { //setze den Namen
        this.cname = cname;
    }

    public double getCzahl() { //abfragen der Zahl
        return czahl;
    }

    public void setCzahl(int zahl) { //setze die Zahl
        this.czahl = czahl;
    }

    public int malmal(int a, int b) {
        return a * b;
    }
}
