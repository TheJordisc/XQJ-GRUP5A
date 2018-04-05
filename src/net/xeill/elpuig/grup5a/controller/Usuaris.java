package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.ArxiuUsuaris;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class Usuaris {
    XQConnection conn;

    public Usuaris(XQConnection conn) {
        this.conn=conn;
    }

    public void queryTotsUsuaris() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris\n" +
                "order by xs:integer($a/UsuarisSalesDeConsulta/text()) descending\n" +
                "return concat($a/Equipament/text(),\",\",$a/Districte/text(),\",\",$a/TipusEquipament/text(),\",\",$a/Any/text(),\",\",$a/Ambit/text(),\n" +
                "               \",\",$a/Titularitat/text(),\",\",$a/Latitud/text(),\",\",$a/Longitud/text(),\",\",$a/UsuarisSalesDeConsulta/text(),\",\",$a/Nota/text())");

        while (query1Result.next()) {
            String[] stringArray =  query1Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + stringArray[0]);
            System.out.println("Districte: " + stringArray[1]);
            System.out.println("Tipus d'equipament: " + stringArray[2]);
            System.out.println("Any: " + stringArray[3]);
            System.out.println("Àmbit: " + stringArray[4]);
            System.out.println("Titularitat: " + stringArray[5]);
            System.out.println("Latitud: " + stringArray[6]);
            System.out.println("Longitud: " + stringArray[7]);
            System.out.println("Usuaris de sales de consulta: " + stringArray[8]);

            String nota;
            if(stringArray.length<10) {
                nota="(No hi ha cap nota)";
            } else {
                nota=stringArray[9];
            }

            System.out.println("Nota: " + nota);

            System.out.println("----------------------------------");
        }
    }

    public void querySumaUsuaris() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("sum(doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris/UsuarisSalesDeConsulta)");
        query2Result.next();
        System.out.println("Quantitat total d'usuaris: "+ query2Result.getItemAsString(null));
    }

    public void queryPerEquipament() throws XQException {
        XQExpression query3 = conn.createExpression();
        XQResultSequence query3Result = query3.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris\n" +
                "return concat($a/Equipament/text(),\",\", $a/UsuarisSalesDeConsulta/text())");
        while (query3Result.next()) {
            String[] result = query3Result.getItemAsString(null).split(",");
            System.out.println("Equipament: " + result[0]);
            System.out.println("Usuaris: " + result[1]);
        }
    }

    public void queryCompteAmbit() throws XQException {
        XQExpression query4 = conn.createExpression();
        XQResultSequence query4Result = query4.executeQuery("count(distinct-values(doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris/Ambit))");
        while (query4Result.next()) {
            System.out.println("Quantitat total d'ambits: "+ query4Result.getItemAsString(null));
        }
    }


    public void insertArxiuUsuaris(ArxiuUsuaris arxiuUsuaris) throws XQException {
        XQExpression expression = conn.createExpression();
        expression.executeCommand("update insert\n" +
                "<arxius-usuaris>" +
                "<Any>"+arxiuUsuaris.getAny()+"</Any>" +
                "<Ambit>"+arxiuUsuaris.getAmbit()+"</Ambit>" +
                "<Titularitat>"+arxiuUsuaris.getTitularitat() + "</Titularitat>" +
                "<Latitud>"+arxiuUsuaris.getLatitud()+ "</Latitud>" +
                "<Longitud>"+arxiuUsuaris.getLongitud()+"</Longitud>" +
                "<TipusEquipament>"+arxiuUsuaris.getTipusEquipament()+"</TipusEquipament>" +
                "<Equipament>"+arxiuUsuaris.getEquipament()+ "</Equipament>" +
                "<Districte>"+ arxiuUsuaris.getDistricte()+"</Districte>" +
                "<UsuarisSalesDeConsulta>"+ arxiuUsuaris.getUsuaris()+"</UsuarisSalesDeConsulta>" +
                "</arxius-usuaris>" +
                "preceding doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris[1]");
    }

    public boolean deleteArxiuUsuaris(String queryField) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand("update delete doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris[Equipament=\""+queryField+"\"]");
            return true;
        }
        return false;
    }

    public boolean updateArxiuUsuaris(String queryField, String newValue) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand( "update value\n" +
                    "doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris[Equipament=\""+queryField+"\"]/UsuarisSalesDeConsulta \n" +
                    "with '" + newValue + "'");
            return true;
        }
        return false;
    }

    public boolean checkIfExists(String queryField, XQExpression expression) throws XQException {
        XQResultSequence queryDeleteResult = expression.executeQuery("doc(\"/db/GRUP5A/arxius-usuaris_.xml\")/xml/arxius-usuaris[Equipament=\""+queryField+"\"]");

        if (queryDeleteResult.next()) {
            return true;
        }
        return false;

    }
}
