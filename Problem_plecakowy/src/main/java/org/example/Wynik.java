package org.example;

import java.util.List;

public class Wynik {
    public int wynik_wag;
    public int wynik_wartosci;
    public List<Integer> wynik_nr_przedmiotow;

    public Wynik(List<Integer> spakowane_przed, int laczna_war, int laczna_wag)
    {
        wynik_wag = laczna_wag;
        wynik_wartosci = laczna_war;
        wynik_nr_przedmiotow = spakowane_przed;
    }

    @Override
    public String toString()
    {
        return String.format(" Laczna waga przedmiotow: %d \n Laczna wartosc przedmiotow: %d \n Numery spakowanych przedmiotow: %s",
                wynik_wag, wynik_wartosci, wynik_nr_przedmiotow);
    }
}
