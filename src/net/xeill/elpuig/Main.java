package net.xeill.elpuig;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();

        String option=menu.askOption();
        while (! option.equalsIgnoreCase("0")) {
            if (option.equalsIgnoreCase("a")) {
                menu.showSub();
                String suboption = menu.askOption();

                while (!suboption.equalsIgnoreCase("f")) {
                    if (suboption.equalsIgnoreCase("a")) {
                        menu.showConsultes();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;
                    } else if (suboption.equalsIgnoreCase("b")) {
                        menu.showPrestecs();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;
                    } else if (suboption.equalsIgnoreCase("c")) {
                        menu.showInternet();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;
                    } else if (suboption.equalsIgnoreCase("d")) {
                        menu.showUsuaris();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;
                    } else if (suboption.equalsIgnoreCase("e")) {
                        menu.showVisites();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;
                    }
                }

            }

            menu.show();
            option=menu.askOption();
        }

        System.out.println("A reveure.");
    }
}
