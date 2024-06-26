package org.example;

public class Przedmiot {
    public boolean uzycie = false;
    public int waga, wartosc;
    public Przedmiot(boolean u, int wag, int war)
    {
        uzycie = u;
        waga = wag;
        wartosc = war;
        System.out.printf(" %d           %d\n", waga, wartosc);
    }
    public void set_uzycie_przedmiotu(boolean nowa_wartosc)
    {
        uzycie = nowa_wartosc;
    }

    public double getWartoscDoWaga()
    {
        return ((double) wartosc / waga);
    }
}
