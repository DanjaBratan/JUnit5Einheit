package com.company;

public class zweiteKlasse {

    private double czahl;
    private String cname;
    int i = 5; //die eingentliche Ausgabe
    String j = "4";


    public zweiteKlasse(String cname, double czahl) {

        this.cname = cname; //name wird zu dem Objekt geordnet
        this.czahl = czahl; //zahl wird zu dem Objekt geordnet

    }


    public String getCname() { //abfragen des namens
        return cname;
    }

    public void setCname() { //setze den Namen
        this.cname = cname;
    }

    public double getCzahl() { //abfragen der Zahl
        return czahl;
    }

    public void setCzahl() { //setze die Zahl
        this.czahl = czahl;
    }
}
