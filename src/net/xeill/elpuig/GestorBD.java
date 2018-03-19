package net.xeill.elpuig;

import net.xqj.exist.ExistXQDataSource;

import javax.xml.xquery.*;
import java.util.*;

public class GestorBD {
    private XQConnection conn;
    Scanner scanner;

    public GestorBD(String serverName, String port, String user, String password) {
        XQDataSource xqDataSource = new ExistXQDataSource();
        try {
            xqDataSource.setProperty("serverName",serverName);
            xqDataSource.setProperty("port",port);
            this.conn = xqDataSource.getConnection(user,password);
        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    public void tancarSessio() throws XQException {
        conn.close();
        System.out.println("A reveure.");
    }

    public void query1Consultes() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes\n" +
                "        return concat(\"Equipament: \", $a/Equipament/text(),\". Consultes presencials: \", $a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query1Result.next()) {
            System.out.println(query1Result.getItemAsString(null));
        }
    }

    public void query2Consultes() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[TipusEquipament=\"Arxius\"]\n" +
                "        return concat(\"Equipament: \", $a/Equipament/text(),\". Consultes presencials: \", $a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query2Result.next()) {
            System.out.println(query2Result.getItemAsString(null));
        }
    }

    public void query3Consultes() throws XQException {
        //solo las bibliotecas

        XQExpression query3 = conn.createExpression();
        XQResultSequence query3Result = query3.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[TipusEquipament=\"Biblioteques\"]\n" +
                "return concat($a/Equipament/text(),\",\",$a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query3Result.next()) {
            String[] result = query3Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Consultes: " + result[1]);
            System.out.println("---");
        }


    }

    public void query4Consultes() throws XQException {
        XQExpression query4 = conn.createExpression();
        XQResultSequence query4Result = query4.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes\n" +
                "         return concat($a/Equipament/text(),\",\",$a/Districte/text(),\",\",$a/TipusEquipament/text(),\",\",$a/Any/text(),\",\",$a/Ambit/text(),\n" +
                "               \",\",$a/Titularitat/text(),\",\",$a/Latitud/text(),\",\",$a/Longitud/text(),\",\",$a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query4Result.next()) {
            String[] result = query4Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Districte: " + result[1]);
            System.out.println("Tipus equipament: " + result[2]);
            System.out.println("Any: " + result[3]);
            System.out.println("Àmbit: " + result[4]);
            System.out.println("Titularitat: " + result[5]);
            System.out.println("Latitud: " + result[6]);
            System.out.println("Longitud: " + result[7]);
            System.out.println("Consultes presencials: " + result[8]);
            System.out.println("---");
        }
    }

    public void insertCommand(){

    }

    public void updateCommand(){

    }

    public void deleteCommand(){

    }
}
