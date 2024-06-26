package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(" Podaj liczbe przedmiotow : ");
        int l_przedmiotow = scanner.nextInt();
        System.out.printf(" Enter the seed : ");
        int seed = scanner.nextInt();
        System.out.printf(" Podaj pojemnosc plecaka: ");
        int C = scanner.nextInt();
        Problem problem1 = new Problem(l_przedmiotow, seed);
        problem1.Solve(C);
    }
}