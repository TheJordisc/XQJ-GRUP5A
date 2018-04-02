package net.xeill.elpuig.grup5a;

import net.xeill.elpuig.grup5a.controller.Consultes;
import net.xeill.elpuig.grup5a.controller.Prestecs;
import net.xeill.elpuig.grup5a.controller.UsosInternet;
import net.xeill.elpuig.grup5a.controller.Usuaris;
import net.xeill.elpuig.grup5a.model.ArxiuConsultes;
import net.xeill.elpuig.grup5a.model.ArxiuUsuaris;
import net.xeill.elpuig.grup5a.model.BibliotequesPrestecs;
import net.xeill.elpuig.grup5a.model.BibliotequesUsosInternet;

import javax.xml.xquery.XQException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws XQException {
        Scanner scanner = new Scanner(System.in);

        GestorBD gestorDB = new GestorBD("localhost","8080","admin","admin");
        Menu menu = new Menu();
        menu.show();

        String option=menu.askOption();
        while (! option.equalsIgnoreCase("b")) {
            if (option.equalsIgnoreCase("a")) {
                menu.showSub();
                String suboption = menu.askOption();

                while (!suboption.equalsIgnoreCase("f")) {

                    // SUBMENU CONSULTES

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

                                if(consultes.updateArxiuConsultes(queryField,newValue)) {
                                    System.out.println("Modificat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }
                            }

                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;

                        // SUBMENU PRESTECS

                    } else if (suboption.equalsIgnoreCase("b")) {
                        menu.showConsultes();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            Prestecs prestecs = new Prestecs(gestorDB.getConn());
                            if (subsuboption.equalsIgnoreCase("a")) {
                                prestecs.queryTotsPrestecs();
                            } else if (subsuboption.equalsIgnoreCase("b")) {
                                prestecs.queryEquipaments100MilPrestecs();
                            } else if (subsuboption.equalsIgnoreCase("c")) {
                                prestecs.querySumaPrestecs2016();
                            } else if (subsuboption.equalsIgnoreCase("d")) {
                                prestecs.queryPrestecsPerDistricte();
                            } else if (subsuboption.equalsIgnoreCase("e")) {
                                String any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, numPrestecs, nota;

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

                                System.out.println("Introdueix un nombre de préstecs: ");
                                numPrestecs=scanner.nextLine();

                                System.out.println("Introdueix una nota [opcional]:");
                                nota=scanner.nextLine();

                                BibliotequesPrestecs bibliotequesPrestecs = new BibliotequesPrestecs(any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, numPrestecs, nota);
                                prestecs.insertBibliotequesPrestecs(bibliotequesPrestecs);

                            } else if (subsuboption.equalsIgnoreCase("f")) {
                                System.out.println("Introdueix un nom d'equipament: ");
                                String queryField = scanner.nextLine();


                                if(prestecs.deleteBibliotequesPrestecs(queryField)) {
                                    System.out.println("Esborrat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }

                            } else if (subsuboption.equalsIgnoreCase("g")) {
                                String queryField,newValue;

                                System.out.println("Introdueix el nom de l'equipament:");
                                queryField=scanner.nextLine();

                                System.out.println("Introdueix el nombre de préstecs actualitzat: ");
                                newValue=scanner.nextLine();

                                if(prestecs.updateBibliotequesPrestecs(queryField,newValue)) {
                                    System.out.println("Modificat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }
                            }

                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                        break;

                        // SUBMENU USOS INTERNET

                    } else if (suboption.equalsIgnoreCase("c")) {
                        menu.showInternet();
                        String subsuboption = menu.askOption();
                        while (!subsuboption.equalsIgnoreCase("h")) {
                            UsosInternet usosInternet = new UsosInternet(gestorDB.getConn());
                            if (subsuboption.equalsIgnoreCase("a")) {
                                usosInternet.queryTotsUsosInternet();
                            } else if (subsuboption.equalsIgnoreCase("b")) {
                                usosInternet.queryEquipaments100MilUsosInternet();
                            } else if (subsuboption.equalsIgnoreCase("c")) {
                                usosInternet.querySumaUsosInternet2016();
                            } else if (subsuboption.equalsIgnoreCase("d")) {
                                usosInternet.queryUsosInternetPerDistricte();
                            } else if (subsuboption.equalsIgnoreCase("e")) {
                                String any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, numUsosInternet, nota;

                                System.out.println("Introdueix un any: ");
                                any = scanner.nextLine();

                                System.out.println("Introdueix un ambit: ");
                                ambit = scanner.nextLine();

                                System.out.println("Introdueix una titularitat: ");
                                titularitat = scanner.nextLine();

                                System.out.println("Introdueix una latitud: ");
                                latitud = scanner.nextLine();

                                System.out.println("Introdueix una longitud: ");
                                longitud = scanner.nextLine();

                                System.out.println("Introdueix un tipus de equipament: ");
                                tipusEquipament = scanner.nextLine();

                                System.out.println("Introdueix un districte: ");
                                districte = scanner.nextLine();

                                System.out.println("Introdueix un equipament: ");
                                equipament = scanner.nextLine();

                                System.out.println("Introdueix un nombre d'usos d'Internet: ");
                                numUsosInternet = scanner.nextLine();

                                System.out.println("Introdueix una nota [opcional]:");
                                nota = scanner.nextLine();

                                BibliotequesUsosInternet bibliotequesUsosInternet = new BibliotequesUsosInternet(any, ambit, titularitat, latitud, longitud, tipusEquipament, equipament, districte, numUsosInternet, nota);
                                usosInternet.insertUsosInternet(bibliotequesUsosInternet);

                            } else if (subsuboption.equalsIgnoreCase("f")) {
                                System.out.println("Introdueix un nom d'equipament: ");
                                String queryField = scanner.nextLine();


                                if (usosInternet.deleteUsosInternet(queryField)) {
                                    System.out.println("Esborrat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }

                            } else if (subsuboption.equalsIgnoreCase("g")) {
                                String queryField, newValue;

                                System.out.println("Introdueix el nom de l'equipament:");
                                queryField = scanner.nextLine();

                                System.out.println("Introdueix el nombre d'usos d'Internet actualitzat: ");
                                newValue = scanner.nextLine();

                                if (usosInternet.updateUsosInternet(queryField, newValue)) {
                                    System.out.println("Modificat correctament.");
                                } else {
                                    System.out.println("Equipament no trobat");
                                }
                            }
                            menu.showConsultes();
                            subsuboption = menu.askOption();
                        }
                            break;

                        // SUBMENU USUARIS

                    } else if (suboption.equalsIgnoreCase("d")) {
                        menu.showUsuaris();
                        String subsuboption = menu.askOption();
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
                                System.out.println("Introdueix un any:");
                                any=scanner.nextLine();

                                System.out.println("Introdueix un ambit:");
                                ambit=scanner.nextLine();

                                System.out.println("Introdueix una titularitat:");
                                titularitat=scanner.nextLine();

                                System.out.println("Introdueix una latitud:");
                                latitud=scanner.nextLine();

                                System.out.println("Introdueix una longitud:");
                                longitud=scanner.nextLine();

                                System.out.println("Introdueix un tipus de equipament:");
                                tipusEquipament=scanner.nextLine();

                                System.out.println("Introdueix un districte:");
                                districte=scanner.nextLine();

                                System.out.println("Introdueix un equipament:");
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
                        break;

                        // SUBMENU VISITES

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
