package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.ArxiuConsultes;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

public class Consultes {
    XQConnection conn;

    public Consultes(XQConnection conn) {
        this.conn=conn;
    }

    public void queryConsultes() throws XQException {
        XQExpression query1 = conn.createExpression();
        XQResultSequence query1Result = query1.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes\n" +
                "order by xs:integer($a/ConsultesPresencialsSalesDeConsulta/text()) descending\n" +
                "return concat(\"Equipament: \", $a/Equipament/text(),\". Consultes presencials: \", $a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query1Result.next()) {
            System.out.println(query1Result.getItemAsString(null));
        }
    }

    public void queryConsultesArxius() throws XQException {
        XQExpression query2 = conn.createExpression();
        XQResultSequence query2Result = query2.executeQuery("for $a in doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[TipusEquipament=\"Arxius\"]\n" +
                "        return concat(\"Equipament: \", $a/Equipament/text(),\". Consultes presencials: \", $a/ConsultesPresencialsSalesDeConsulta/text())");

        while (query2Result.next()) {
            System.out.println(query2Result.getItemAsString(null));
        }
    }

    public void queryConsultesBiblioteques() throws XQException {
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

    public void queryTotsArxius() throws XQException {
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

    public void insertArxiuConsultes(ArxiuConsultes arxiuConsultes) throws XQException {
        XQExpression expression = conn.createExpression();
        expression.executeCommand("update insert\n" +
                "<arxius-consultes><Any>"+arxiuConsultes.getAny()+"</Any><Ambit>"+arxiuConsultes.getAmbit()+"</Ambit><Titularitat>"+arxiuConsultes.getTitularitat()+
                "</Titularitat><Latitud>"+arxiuConsultes.getLatitud()+"</Latitud><Longitud>"+arxiuConsultes.getLongitud()+"</Longitud>" +
                "<TipusEquipament>"+arxiuConsultes.getTipusEquipament()+"</TipusEquipament><Equipament>"+arxiuConsultes.getEquipament()+
                "</Equipament><Districte>"+arxiuConsultes.getDistricte()+"</Districte><ConsultesPresencialsSalesDeConsulta>"+
                arxiuConsultes.getConsultesPresencials()+"</ConsultesPresencialsSalesDeConsulta></arxius-consultes>" +
                "preceding doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[1]");
    }

    public boolean deleteArxiuConsultes(String queryField) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand("update delete doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[Equipament=\""+queryField+"\"]");
            return true;
        }
        return false;

    }

    public boolean updateArxiuConsultes(String queryField, String newValue) throws XQException {
        XQExpression expression = conn.createExpression();
        if (checkIfExists(queryField,expression)){
            expression.executeCommand( "update value\n" +
                    "doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[Equipament=\""+queryField+"\"]/ConsultesPresencialsSalesDeConsulta \n" +
                    "with '" + newValue + "'");
            return true;
        }
        return false;
    }

    public boolean checkIfExists(String queryField, XQExpression expression) throws XQException {
        XQResultSequence queryDeleteResult = expression.executeQuery("doc(\"/db/GRUP5A/arxius-consultes_.xml\")/xml/arxius-consultes[Equipament=\""+queryField+"\"]");

        if (queryDeleteResult.next()) {
            return true;
        }
        return false;

    }
}
