package org.example;

import static org.example.GlobalneDane.lowerBound;
import static org.example.GlobalneDane.upperBound;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ProblemTest {
    Problem problem;

    @BeforeEach
    void setUp() {
        problem = new Problem();
    }

    @Test
    void testSprawdzeniePrzyZbytMalejIlosciMiejsca() {
        Przedmiot przedmiot0 = new Przedmiot(false, 7, 5);
        Przedmiot przedmiot1 = new Przedmiot(false, 10, 2);
        Przedmiot przedmiot2 = new Przedmiot(false, 8, 6);
        Przedmiot przedmiot3 = new Przedmiot(false, 7, 4);

        problem.lista_przedmiotow.add(przedmiot0);
        problem.lista_przedmiotow.add(przedmiot1);
        problem.lista_przedmiotow.add(przedmiot2);
        problem.lista_przedmiotow.add(przedmiot3);
        problem.liczba_przedmiotow = 4;

        problem.Solve(5);

        assertEquals(0, problem.spakowane_przedmioty.size());
    }

    @Test
    void testDodawaniePrzedmiotow() {
        Przedmiot przedmiot0 = new Przedmiot(false, 3, 5);
        Przedmiot przedmiot1 = new Przedmiot(false, 2, 2);
        Przedmiot przedmiot2 = new Przedmiot(false, 3, 6);
        Przedmiot przedmiot3 = new Przedmiot(false, 5, 4);

        problem.lista_przedmiotow.add(przedmiot0);
        problem.lista_przedmiotow.add(przedmiot1);
        problem.lista_przedmiotow.add(przedmiot2);
        problem.lista_przedmiotow.add(przedmiot3);
        problem.liczba_przedmiotow = 4;

        problem.Solve(5);

        assertEquals(2, problem.spakowane_przedmioty.size());
    }

    @Test
    void testPoprawnosciDzialaniaPakowania() {
        Przedmiot przedmiot0 = new Przedmiot(false, 3, 5);
        Przedmiot przedmiot1 = new Przedmiot(false, 2, 2);
        Przedmiot przedmiot2 = new Przedmiot(false, 3, 6);
        Przedmiot przedmiot3 = new Przedmiot(false, 5, 4);

        problem.lista_przedmiotow.add(przedmiot0);
        problem.lista_przedmiotow.add(przedmiot1);
        problem.lista_przedmiotow.add(przedmiot2);
        problem.lista_przedmiotow.add(przedmiot3);
        problem.liczba_przedmiotow = 4;

        problem.Solve(8);

        assertEquals(3, problem.spakowane_przedmioty.size());
        assertEquals(8,problem.zajete_miejsce);
        assertEquals(14,problem.laczna_wartosc_przed);
    }

    @Test
    void testLosowaniaWartosci(){
        Problem problem = new Problem(10,2);
        for(int i = 0; i < 10; i++){
            assertTrue(problem.lista_przedmiotow.get(i).wartosc <= upperBound);
            assertTrue(problem.lista_przedmiotow.get(i).wartosc >= lowerBound);
            assertTrue(problem.lista_przedmiotow.get(i).waga <= upperBound);
            assertTrue(problem.lista_przedmiotow.get(i).waga >= lowerBound);
        }
    }
}
