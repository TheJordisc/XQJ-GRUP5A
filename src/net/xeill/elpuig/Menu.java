package net.xeill.elpuig;

import java.util.Scanner;

public class Menu {
    String option;
    Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("a) Triar XML");
        System.out.println("b) Sortir");
    }

    public void showSub() {
        System.out.println("a) Consultes");
        System.out.println("b) Préstecs");
        System.out.println("c) Usos Internet");
        System.out.println("d) Usuaris");
        System.out.println("e) Visites");
        System.out.println("f) Tornar");
    }

    public void showConsultes() {
        System.out.println("a) Query 1");
        System.out.println("b) Query 2");
        System.out.println("c) Query 3");
        System.out.println("d) Query 4");
        System.out.println("e) Inserció");
        System.out.println("f) Eliminació");
        System.out.println("g) Modificació");
        System.out.println("h) Tornar");
    }

    public void showPrestecs() {
        System.out.println("a) Query 1");
        System.out.println("b) Query 2");
        System.out.println("c) Query 3");
        System.out.println("d) Query 4");
        System.out.println("e) Inserció");
        System.out.println("f) Eliminació");
        System.out.println("g) Modificació");
        System.out.println("h) Tornar");
    }

    public void showInternet() {
        System.out.println("a) Query 1");
        System.out.println("b) Query 2");
        System.out.println("c) Query 3");
        System.out.println("d) Query 4");
        System.out.println("e) Inserció");
        System.out.println("f) Eliminació");
        System.out.println("g) Modificació");
        System.out.println("h) Tornar");
    }

    public void showUsuaris() {
        System.out.println("a) Query 1");
        System.out.println("b) Query 2");
        System.out.println("c) Query 3");
        System.out.println("d) Query 4");
        System.out.println("e) Inserció");
        System.out.println("f) Eliminació");
        System.out.println("g) Modificació");
        System.out.println("h) Tornar");
    }

    public void showVisites() {
        System.out.println("a) Query 1");
        System.out.println("b) Query 2");
        System.out.println("c) Query 3");
        System.out.println("d) Query 4");
        System.out.println("e) Inserció");
        System.out.println("f) Eliminació");
        System.out.println("g) Modificació");
        System.out.println("h) Tornar");
    }


    public String askOption() {
        System.out.println("Introdueix opcio: ");
        option= scanner.nextLine();
        return option;
    }
}
