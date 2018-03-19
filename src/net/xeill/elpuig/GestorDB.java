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
    }
}
