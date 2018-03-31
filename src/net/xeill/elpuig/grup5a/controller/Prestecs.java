package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.BibliotequesPrestecs;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class Prestecs {
    XQConnection conn;

    public Prestecs(XQConnection conn) {
        this.conn=conn;
    }


    public void queryTotsPrestecs() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-prestecs_.xml\")/xml/biblioteques-prestecs\n" +
                "order by xs:integer($a/Prestecs/text()) descending\n" +
                "return concat($a/Equipament/text(),\",\",$a/Districte/text(),\",\",$a/TipusEquipament/text(),\",\",$a/Any/text(),\",\",$a/Ambit/text(),\n" +
                "               \",\",$a/Titularitat/text(),\",\",$a/Latitud/text(),\",\",$a/Longitud/text(),\",\",$a/Prestecs/text(),\",\",$a/Nota/text())");

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
            System.out.println("Préstecs: " + stringArray[8]);

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

    public void queryEquipaments100MilPrestecs() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-prestecs_.xml\")/xml/biblioteques-prestecs\n" +
                "where $a/Prestecs >= 100000\n" +
                "order by $a/Prestecs descending\n" +
                "return concat($a/Equipament/text(),\",\", $a/Prestecs/text())");
        while (query2Result.next()) {
            String[] result = query2Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Préstecs: " + result[1]);
            System.out.println("----------------------------------");
        }
    }

    public void querySumaPrestecs2016() throws XQException {
        XQExpression query3 = conn.createExpression();
        XQResultSequence query3Result = query3.executeQuery("xs:integer(sum(doc(\"/db/GRUP5A/biblioteques-prestecs_.xml\")/xml/biblioteques-prestecs/Prestecs))");
        query3Result.next();
        System.out.println("Préstecs totals al 2016: "+ query3Result.getItemAsString(null));
    }

    public void queryPrestecsPerDistricte() {

    }

    public void insertBibliotequesPrestecs(BibliotequesPrestecs bibliotequesPrestecs) {

    }

    public boolean deleteBibliotequesPrestecs(String queryField) {

        return false;
    }

    public boolean updateBibliotequesPrestecs(String queryField, String newValue) {

        return false;
    }

    public boolean checkIfExists(String queryField, XQExpression expression) throws XQException {
        XQResultSequence queryDeleteResult = expression.executeQuery("doc(\"/db/GRUP5A/biblioteques-prestecs_.xml\")/xml/biblioteques-prestecs[Equipament=\""+queryField+"\"]");

        if (queryDeleteResult.next()) {
            return true;
        }
        return false;

    }
}
