package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.*;
import static org.example.GlobalneDane.lowerBound;
import static org.example.GlobalneDane.upperBound;


public class Problem {
    public int liczba_przedmiotow;
    public List<Przedmiot> lista_przedmiotow = new ArrayList<>();
    public int laczna_wartosc_przed, zajete_miejsce;
    public List<Integer> spakowane_przedmioty = new ArrayList<>();
    private java.util.Comparator<Object> Comparator;

    public Problem(){}

    public Problem(int l_przed, int seed)
    {
        liczba_przedmiotow = l_przed;
        System.out.printf("Dostępne przedmioty:\n");
        System.out.printf("Waga      Wartosc\n");
        Random random = new Random(seed);
        for (int i = 0; i < l_przed; i++)
        {
            lista_przedmiotow.add(new Przedmiot(false, random.nextInt(lowerBound,upperBound), random.nextInt(1,10)));
        }
    }

    public Wynik Solve(int pojemnosc)
    {
        lista_przedmiotow.sort(java.util.Comparator.comparingDouble(Przedmiot::getWartoscDoWaga).reversed());
        System.out.printf("\n\nPosegregowane przedmioty:\n");
        System.out.printf("Nr przedmiotu      Waga      Wartosc      Stosunek war/wag\n");
        int w, war;
        double stosunek;

        // wyświetlanie puli przedmiotów
        for (int i = 0; i < liczba_przedmiotow; i++) {
            w = lista_przedmiotow.get(i).waga;
            war = lista_przedmiotow.get(i).wartosc;
            stosunek = lista_przedmiotow.get(i).getWartoscDoWaga();
            System.out.printf("      %d             %d           %d               %.2f\n", i, w, war, stosunek);
        }


        // wkładanie przedmiotów do plecaka
        for(int i = 0; i < liczba_przedmiotow; i++)
        {
            while (lista_przedmiotow.get(i).waga <= (pojemnosc - zajete_miejsce))
            {
                laczna_wartosc_przed += lista_przedmiotow.get(i).wartosc;
                zajete_miejsce += lista_przedmiotow.get(i).waga;
                spakowane_przedmioty.add(i);
                lista_przedmiotow.get(i).set_uzycie_przedmiotu(true);
            }
        }

        Wynik wynik = new Wynik(spakowane_przedmioty, laczna_wartosc_przed, zajete_miejsce);
        System.out.printf(wynik.toString());
        return wynik;
    }
}
