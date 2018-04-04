package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.BibliotequesVisites;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class Visites {
    XQConnection conn;

    public Visites(XQConnection conn) {
        this.conn=conn;
    }


    public void queryTotesVisites() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites\n" +
                "order by xs:integer($a/Visites/text()) descending\n" +
                "return concat($a/Equipament/text(),\",\",$a/Districte/text(),\",\",$a/TipusEquipament/text(),\",\",$a/Any/text(),\",\",$a/Ambit/text(),\n" +
                "               \",\",$a/Titularitat/text(),\",\",$a/Latitud/text(),\",\",$a/Longitud/text(),\",\",$a/Visites/text(),\",\",$a/Nota/text())");

        while (query1Result.next()) {
            String[] stringArray = query1Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + stringArray[0]);
            System.out.println("Districte: " + stringArray[1]);
            System.out.println("Tipus d'equipament: " + stringArray[2]);
            System.out.println("Any: " + stringArray[3]);
            System.out.println("Àmbit: " + stringArray[4]);
            System.out.println("Titularitat: " + stringArray[5]);
            System.out.println("Latitud: " + stringArray[6]);
            System.out.println("Longitud: " + stringArray[7]);
            System.out.println("Visites: " + stringArray[8]);

            String nota;
            if (stringArray.length < 10) {
                nota = "(No hi ha cap nota)";
            } else {
                nota = stringArray[9];
            }

            System.out.println("Nota: " + nota);

            System.out.println("----------------------------------");
        }
    }

    public void queryEquipaments100MilVisites() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites\n" +
                "where $a/Visites >= 100000\n" +
                "order by $a/Visites descending\n" +
                "return concat($a/Equipament/text(),\",\", $a/Visites/text())");
        while (query2Result.next()) {
            String[] result = query2Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Visites: " + result[1]);
            System.out.println("----------------------------------");
        }
    }

    public void querySumaVisites2016() throws XQException {
        XQExpression query3 = conn.createExpression();
        XQResultSequence query3Result = query3.executeQuery("xs:integer(sum(doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites/Visites))");
        query3Result.next();
        System.out.println("Visites totals al 2016: "+ query3Result.getItemAsString(null));
    }

    public void queryVisitesPerDistricte() throws XQException {
        XQExpression query4 = conn.createExpression();
        XQResultSequence query4Result = query4.executeQuery("distinct-values(for $districte in doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites/Districte\n" +
                "\treturn concat($districte/text(),\",\",xs:integer(sum(doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites[Districte=$districte]/Visites))))");
        while (query4Result.next()) {
            String[] result = query4Result.getItemAsString(null).split(",");
            System.out.printf("%-24s %s visites\n",result[0],result[1]);
        }
    }

    public void insertVisites(BibliotequesVisites bibliotequesVisites) throws XQException {
        XQExpression expression = conn.createExpression();
        expression.executeCommand("update insert\n" +
                "<biblioteques-visites><Any>"+bibliotequesVisites.getAny()+"</Any>" +
                "<Ambit>"+bibliotequesVisites.getAmbit()+"</Ambit>" +
                "<Titularitat>"+bibliotequesVisites.getTitularitat()+ "</Titularitat>" +
                "<Latitud>"+bibliotequesVisites.getLatitud()+"</Latitud>" +
                "<Longitud>"+bibliotequesVisites.getLongitud()+"</Longitud>" +
                "<TipusEquipament>"+bibliotequesVisites.getTipusEquipament()+"</TipusEquipament>" +
                "<Equipament>"+bibliotequesVisites.getEquipament()+"</Equipament>" +
                "<Districte>"+bibliotequesVisites.getDistricte()+"</Districte>" +
                "<Visites>"+ bibliotequesVisites.getVisites()+"</Visites>" +
                "<Nota>" + bibliotequesVisites.getNota() + "</Nota>" +
                "</biblioteques-visites>\n" +
                "preceding doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites[1]");
    }

    public boolean deleteVisites(String queryField) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand("update delete doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites[Equipament=\""+queryField+"\"]");
            return true;
        }
        return false;
    }

    public boolean updateVisites(String queryField, String newValue) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand( "update value\n" +
                    "doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites[Equipament=\""+queryField+"\"]/Visites \n" +
                    "with '" + newValue + "'");
            return true;
        }
        return false;
    }

    public boolean checkIfExists(String queryField, XQExpression expression) throws XQException {
        XQResultSequence queryDeleteResult = expression.executeQuery("doc(\"/db/GRUP5A/biblioteques-visites_.xml\")/xml/biblioteques-visites[Equipament=\""+queryField+"\"]");

        if (queryDeleteResult.next()) {
            return true;
        }
        return false;

    }
}
