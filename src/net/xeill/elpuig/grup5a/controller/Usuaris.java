package net.xeill.elpuig.grup5a.controller;

import net.xeill.elpuig.grup5a.model.ArxiuUsuaris;

import javax.xml.xquery.XQConnection;

public class Usuaris {
    XQConnection conn;

    public Usuaris(XQConnection conn) {
        this.conn=conn;
    }

    public void queryTotsUsuaris() {

    }

    public void querySumaUsuaris() {

    }

    public void queryPerEquipament() {

    }

    public void queryCompteAmbit() {

    }

    public void insertArxiuUsuaris(ArxiuUsuaris arxiuUsuaris) {
        //TODO: Pedir datos y crear instancia en menú
    }

    public void deleteArxiuUsuaris(String queryField) {
        //TODO: Buscar por algún campo desde menú
    }

    public void updateArxiuUsuaris(String queryField, String newValue) {
        //TODO: Buscar por algún campo desde menú
    }
}
