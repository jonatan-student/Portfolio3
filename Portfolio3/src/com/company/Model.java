package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Model {
    String url;
    Connection conn = null;
    Statement stmt = null;

    public Model(String url) {
        this.url = url;
    }

    // Connecting to the database
    public void connect() throws SQLException
    {
        conn = getConnection(url);
    }

    // Closing connection with database
    public void close() throws SQLException
    {
        if (conn != null)
            conn.close();
    }

    public void createStatement() throws SQLException
    {
        this.stmt = conn.createStatement();
    }


}
