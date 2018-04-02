package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.BibliotequesPrestecs;
import net.xeill.elpuig.grup5a.model.BibliotequesUsosInternet;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class UsosInternet {
    XQConnection conn;

    public UsosInternet(XQConnection conn) {
        this.conn=conn;
    }


    public void queryTotsUsosInternet() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet\n" +
                "order by xs:integer($a/UsosInternetTotals/text()) descending\n" +
                "return concat($a/Equipament/text(),\",\",$a/Districte/text(),\",\",$a/TipusEquipament/text(),\",\",$a/Any/text(),\",\",$a/Ambit/text(),\n" +
                "               \",\",$a/Titularitat/text(),\",\",$a/Latitud/text(),\",\",$a/Longitud/text(),\",\",$a/UsosInternetTotals/text(),\",\",$a/Nota/text())");

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
            System.out.println("Usos d'Internet: " + stringArray[8]);

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

    public void queryEquipaments100MilUsosInternet() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("for $a in doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet\n" +
                "where $a/UsosInternetTotals >= 100000\n" +
                "order by $a/UsosInternetTotals descending\n" +
                "return concat($a/Equipament/text(),\",\", $a/UsosInternetTotals/text())");
        while (query2Result.next()) {
            String[] result = query2Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Usos d'Internet: " + result[1]);
            System.out.println("----------------------------------");
        }
    }

    public void querySumaUsosInternet2016() throws XQException {
        XQExpression query3 = conn.createExpression();
        XQResultSequence query3Result = query3.executeQuery("xs:integer(sum(doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet/UsosInternetTotals))");
        query3Result.next();
        System.out.println("Usos d'Internet totals al 2016: "+ query3Result.getItemAsString(null));
    }

    public void queryUsosInternetPerDistricte() throws XQException {
        XQExpression query4 = conn.createExpression();
        XQResultSequence query4Result = query4.executeQuery("distinct-values(for $districte in doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet/Districte\n" +
                "\treturn concat($districte/text(),\",\",sum(doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet[Districte=$districte]/UsosInternetTotals)))");
        while (query4Result.next()) {
            String[] result = query4Result.getItemAsString(null).split(",");
            System.out.printf("%-24s %s usos d'Internet\n",result[0],result[1]);
        }
    }

    public void insertUsosInternet(BibliotequesUsosInternet bibliotequesUsosInternet) throws XQException {
        XQExpression expression = conn.createExpression();
        expression.executeCommand("update insert\n" +
                "<biblioteques-usosinternet><Any>"+bibliotequesUsosInternet.getAny()+"</Any>" +
                "<Ambit>"+bibliotequesUsosInternet.getAmbit()+"</Ambit>" +
                "<Titularitat>"+bibliotequesUsosInternet.getTitularitat()+ "</Titularitat>" +
                "<Latitud>"+bibliotequesUsosInternet.getLatitud()+"</Latitud>" +
                "<Longitud>"+bibliotequesUsosInternet.getLongitud()+"</Longitud>" +
                "<TipusEquipament>"+bibliotequesUsosInternet.getTipusEquipament()+"</TipusEquipament>" +
                "<Equipament>"+bibliotequesUsosInternet.getEquipament()+"</Equipament>" +
                "<Districte>"+bibliotequesUsosInternet.getDistricte()+"</Districte>" +
                "<UsosInternetTotals>"+ bibliotequesUsosInternet.getUsosInternet()+"</UsosInternetTotals>" +
                "<Nota>" + bibliotequesUsosInternet.getNota() + "</Nota>" +
                "</biblioteques-usosinternet>\n" +
                "preceding doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet[1]");
    }

    public boolean deleteUsosInternet(String queryField) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand("update delete doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet[Equipament=\""+queryField+"\"]");
            return true;
        }
        return false;
    }

    public boolean updateUsosInternet(String queryField, String newValue) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand( "update value\n" +
                    "doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet[Equipament=\""+queryField+"\"]/UsosInternetTotals \n" +
                    "with '" + newValue + "'");
            return true;
        }
        return false;
    }

    public boolean checkIfExists(String queryField, XQExpression expression) throws XQException {
        XQResultSequence queryDeleteResult = expression.executeQuery("doc(\"/db/GRUP5A/biblioteques-usosinternet_.xml\")/xml/biblioteques-usosinternet[Equipament=\""+queryField+"\"]");

        if (queryDeleteResult.next()) {
            return true;
        }
        return false;

    }
}
