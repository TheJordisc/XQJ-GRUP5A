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

    public XQConnection getConn() {
        return conn;
    }

    public void setConn(XQConnection conn) {
        this.conn = conn;
    }
}
