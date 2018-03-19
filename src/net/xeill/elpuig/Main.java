package net.xeill.elpuig;

import javax.xml.xquery.XQException;

public class Main {

    public static void main(String[] args) throws XQException {
        GestorBD gestorDB = new GestorBD("192.168.22.153","8080","admin","admin");
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
                            if (subsuboption.equalsIgnoreCase("a")) {
                                gestorDB.query1Consultes();
                            } else if (subsuboption.equalsIgnoreCase("b")) {
                                gestorDB.query2Consultes();
                            } else if (subsuboption.equalsIgnoreCase("c")) {
                                gestorDB.query3Consultes();
                            } else if (subsuboption.equalsIgnoreCase("d")) {
                                gestorDB.query4Consultes();
                            }

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
        gestorDB.tancarSessio();
    }
}
