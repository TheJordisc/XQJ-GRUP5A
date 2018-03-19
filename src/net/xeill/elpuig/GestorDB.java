package net.xeill.elpuig;

import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.*;
import java.util.*;

public class GestorDB {
    private XQConnection conn;
    Scanner scanner;

    public GestorDB() throws XQException {
        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        conn = xqs.getConnection("admin","admin");
    }

    public void tancarSessio() throws XQException {
        conn.close();
        System.out.println("A reveure.");
    }

    public void query1(){

        //for $a in doc("arxius-consultes_.xml")/xml/arxius-consultes
        //return concat("Equipament: ", $a/Equipament/text(),". Consultes presencials: ", $a/ConsultesPresencialsSalesDeConsulta/text())
    }

    public void query2(){
        //solo los arxius
        //for $a in doc("arxius-consultes_.xml")/xml/arxius-consultes[TipusEquipament="Arxius"]
        //return concat("Equipament: ", $a/Equipament/text(),". Consultes presencials: ", $a/ConsultesPresencialsSalesDeConsulta/text())
    }

    public void query3(){
        //solo las bibliotecas
        //for $a in doc("arxius-consultes_.xml")/xml/arxius-consultes[TipusEquipament="Biblioteques"]
        //return concat("Equipament: ", $a/Equipament/text(),". Consultes presencials: ", $a/ConsultesPresencialsSalesDeConsulta/text())
    }

    public void query4(){
       // for $a in doc("arxius-consultes_.xml")/xml/arxius-consultes
       // return concat("Equipament: ", $a/Equipament/text()," Districte: ", $a/Districte/text()," Tipus equipament: ", $a/TipusEquipament/text()," Any: ", $a/Any/text()," Ambit: ", $a/Ambit/text(),
         //       " Titularitat: ", $a/Titularitat/text(), " Latitud: ", $a/Latitud/text(), " Longitud: ", $a/Longitud/text(), " Consultes presencials: ", $a/ConsultesPresencialsSalesDeConsulta/text())
    }

    public void insertCommand(){

    }

    public void updateCommand(){

    }

    public void deleteCommand(){

    }
}
