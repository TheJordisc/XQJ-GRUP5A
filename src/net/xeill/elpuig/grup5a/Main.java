package net.xeill.elpuig.grup5a;

import net.xeill.elpuig.grup5a.controller.Consultes;
import net.xeill.elpuig.grup5a.controller.Usuaris;
import net.xeill.elpuig.grup5a.model.ArxiuConsultes;
import net.xeill.elpuig.grup5a.model.ArxiuUsuaris;

import javax.xml.xquery.XQException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws XQException {
        Scanner scanner = new Scanner(System.in);

        GestorBD gestorDB = new GestorBD("192.168.22.153","8080","admin","admin");
        Menu menu = new Menu();
        menu.show();

        String option=menu.askOption();
        while (! option.equalsIgnoreCase("b")) {
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
                                String any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, consultesPresencials, nota;

                                System.out.println("Introdueix un any: ");
                                any=scanner.nextLine();

                                System.out.println("Introdueix un ambit: ");
                                ambit=scanner.nextLine();

                                System.out.println("Introdueix una titularitat: ");
                                titularitat=scanner.nextLine();

                                System.out.println("Introdueix una latitud: ");
                                latitud=scanner.nextLine();

                                System.out.println("Introdueix una longitud: ");
                                longitud=scanner.nextLine();

                                System.out.println("Introdueix un tipus de equipament: ");
                                tipusEquipament=scanner.nextLine();

                                System.out.println("Introdueix un districte: ");
                                districte=scanner.nextLine();

                                System.out.println("Introdueix un equipament: ");
                                equipament=scanner.nextLine();

                                System.out.println("Introdueix un nombre de consultes presencials: ");
                                consultesPresencials=scanner.nextLine();

                                System.out.println("Introdueix una nota [opcional]:");
                                nota=scanner.nextLine();

                                ArxiuConsultes arxiuConsultes = new ArxiuConsultes(any, ambit, titularitat, latitud, longitud, tipusEquipament, districte, equipament, consultesPresencials, nota);
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
                                String queryField,newValue;

                                System.out.println("Introdueix el nom de l'equipament:");
                                queryField=scanner.nextLine();

                                System.out.println("Introdueix el nombre de consultes actualitzat: ");
                                newValue=scanner.nextLine();

                                consultes.updateArxiuConsultes(queryField, newValue);
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

                            while (!subsuboption.equalsIgnoreCase("h")) {
                                String any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, nombreUsuaris;
                                Usuaris usuaris = new Usuaris(gestorDB.getConn());
                                if (subsuboption.equalsIgnoreCase("a")) {
                                    usuaris.queryTotsUsuaris();
                                } else if (subsuboption.equalsIgnoreCase("b")) {
                                    usuaris.querySumaUsuaris();
                                } else if (subsuboption.equalsIgnoreCase("c")) {
                                    usuaris.queryPerEquipament();
                                } else if (subsuboption.equalsIgnoreCase("d")) {
                                    usuaris.queryCompteAmbit();
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

                                    System.out.println("Introdueix un nombre d'usuaris:");
                                    nombreUsuaris=scanner.nextLine();

                                    ArxiuUsuaris arxiuUsuaris = new ArxiuUsuaris(any, ambit, titularitat, latitud, longitud, tipusEquipament, districte, equipament, nombreUsuaris);
                                    usuaris.insertArxiuUsuaris(arxiuUsuaris);

                                } else if (subsuboption.equalsIgnoreCase("f")) {
                                    System.out.println("Introdueix un nom d'equipament: ");
                                    String queryField = scanner.nextLine();
                                    if(usuaris.deleteArxiuUsuaris(queryField)) {
                                        System.out.println("Esborrat correctament.");
                                    } else {
                                        System.out.println("Equipament no trobat");
                                    }

                                } else if (subsuboption.equalsIgnoreCase("g")) {
                                    String queryField,newValue;

                                    System.out.println("Introdueix el nom de l'equipament:");
                                    queryField=scanner.nextLine();

                                    System.out.println("Introdueix el nombre d'usuaris actualitzat: ");
                                    newValue=scanner.nextLine();

                                    usuaris.updateArxiuUsuaris(queryField, newValue);
                                }

                                menu.showConsultes();
                                subsuboption = menu.askOption();
                            }
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
