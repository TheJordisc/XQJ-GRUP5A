package net.xeill.elpuig;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();

        String option=menu.askOption();
        while (! option.equalsIgnoreCase("0")) {
            if (option.equalsIgnoreCase("a")) {
                System.out.println("En construcció");
            } else if (option.equalsIgnoreCase("b")) {
                System.out.println("En construcció");
            } else if (option.equalsIgnoreCase("c")) {
                System.out.println("En construcció");
            } else if (option.equalsIgnoreCase("d")) {
                System.out.println("En construcció");
            }

            menu.show();
            option=menu.askOption();
        }

        System.out.println("A reveure.");
    }
}
