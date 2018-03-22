package net.xeill.elpuig;


import net.xeill.elpuig.grup5a.GestorBD;
import net.xeill.elpuig.grup5a.Menu;
import net.xeill.elpuig.grup5a.controller.Consultes;
import net.xeill.elpuig.grup5a.model.ArxiuConsultes;

import javax.xml.xquery.XQException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws XQException {
        Scanner scanner = new Scanner(System.in);
        String any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, consultesPresencials;

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
                            Consultes consultes = new Consultes(gestorDB.getConn());
                            if (subsuboption.equalsIgnoreCase("a")) {
                                consultes.queryConsultes();
                            } else if (subsuboption.equalsIgnoreCase("b")) {
                                consultes.queryConsultesArxius();
                            } else if (subsuboption.equalsIgnoreCase("c")) {
                                consultes.queryConsultesBiblioteques();
                            } else if (subsuboption.equalsIgnoreCase("d")) {
                                consultes.queryTotsArxius();
                            } else if (subsuboption.equalsIgnoreCase("e")) {


                                System.out.println("Introdueix un any");
                                any=scanner.nextLine();
                                System.out.println("Introdueix un ambit");
                                ambit=scanner.nextLine();
                                System.out.println("Introdueix una titularitat");
                                titularitat=scanner.nextLine();
                                System.out.println("Introdueix una latitud");
                                latitud=scanner.nextLine();
                                System.out.println("Introdueix una longitud");
                                longitud=scanner.nextLine();
                                System.out.println("Introdueix un tipus de equipament");
                                tipusEquipament=scanner.nextLine();
                                System.out.println("Introdueix un districte");
                                districte=scanner.nextLine();
                                System.out.println("Introdueix un equipament");
                                equipament=scanner.nextLine();
                                System.out.println("Introdueix un nombre de consultes presencials");
                                consultesPresencials=scanner.nextLine();

                                ArxiuConsultes arxiuConsultes = new ArxiuConsultes(any, ambit, titularitat, latitud, longitud, tipusEquipament, districte, equipament, consultesPresencials);
                                consultes.insertArxiuConsultes(arxiuConsultes);

                            } else if (subsuboption.equalsIgnoreCase("f")) {
                                System.out.println("Introdueix un nom d'equipament: ");
                                String queryField = scanner.nextLine();


                                if(consultes.deleteArxiuConsultes(queryField)) {
                                    System.out.println("Esborrat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }

                            } else if (subsuboption.equalsIgnoreCase("g")) {
                                //TODO: Pedir dato

                                //consultes.updateArxiuConsultes(sfgsdgfsdgf);
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
