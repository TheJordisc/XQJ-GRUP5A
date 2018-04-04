package net.xeill.elpuig.grup5a;

import java.util.Scanner;

public class Menu {
    String option;
    Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("==========    ==========");
        System.out.println("a) Triar XML");
        System.out.println("b) Sortir");
    }

    public void showSub() {
        System.out.println("a) Consultes als arxius i les biblioteques patrimonials de la ciutat de Barcelona");
        System.out.println("b) Préstecs realitzats a les biblioteques de la ciutat de Barcelona");
        System.out.println("c) Usos d'ordinadors i de Wi-Fi a les biblioteques de Barcelona");
        System.out.println("d) Usuaris dels arxius i les biblioteques patrimonials de la ciutat de Barcelona");
        System.out.println("e) Visites a les biblioteques de la ciutat de Barcelona");
        System.out.println("f) Tornar");
    }

    public void showConsultes() {
        System.out.println("a) Consultes presencials (tots els equipaments)");
        System.out.println("b) Consultes presencials (equipaments tipus Arxiu)");
        System.out.println("c) Consultes presencials (equipaments tipus Biblioteca)");
        System.out.println("d) Tota la informació");
        System.out.println("e) Inserció d'entrades");
        System.out.println("f) Eliminació d'entrades");
        System.out.println("g) Modificació de consultes presencials");
        System.out.println("h) Tornar");
    }

    public void showPrestecs() {
        System.out.println("a) Tota la informació");
        System.out.println("b) Equipaments amb més de 100 mil préstecs");
        System.out.println("c) Suma total de préstecs al 2016");
        System.out.println("d) Préstecs per districte");
        System.out.println("e) Inserció d'entrades");
        System.out.println("f) Eliminació d'entrades");
        System.out.println("g) Modificació de préstecs");
        System.out.println("h) Tornar");
    }

    public void showInternet() {
        System.out.println("a) Tota la informació");
        System.out.println("b) Equipaments amb més de 100 mil usos d'Internet");
        System.out.println("c) Suma total d'usos d'Internet al 2016");
        System.out.println("d) Usos d'Internet per districte");
        System.out.println("e) Inserció d'entrades");
        System.out.println("f) Eliminació d'entrades");
        System.out.println("g) Modificació d'usos d'Internet");
        System.out.println("h) Tornar");
    }

    public void showUsuaris() {
        System.out.println("a) Tota la informació");
        System.out.println("b) Usuaris per equipament");
        System.out.println("c) Suma total d'usuaris al 2016");
        System.out.println("d) Quantitat d'àmbits");
        System.out.println("e) Inserció d'entrades");
        System.out.println("f) Eliminació d'entrades");
        System.out.println("g) Modificació d'usuaris");
        System.out.println("h) Tornar");
    }

    public void showVisites() {
        System.out.println("a) Tota la informació");
        System.out.println("b) Equipaments amb més de 100 mil visites");
        System.out.println("c) Suma total de visites al 2016");
        System.out.println("d) Visites per districte");
        System.out.println("e) Inserció d'entrades");
        System.out.println("f) Eliminació d'entrades");
        System.out.println("g) Modificació de visites");
        System.out.println("h) Tornar");
    }


    public String askOption() {
        System.out.println("Introdueix opcio: ");
        option= scanner.nextLine();
        return option;
    }
}
