package net.xeill.elpuig;

import java.util.Scanner;

public class Menu {
    String option;
    Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("TODO");
    }

    public String askOption() {
        System.out.println("Introdueix opcio: ");
        option= scanner.nextLine();
        return option;
    }
}
