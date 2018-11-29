package com.crm.demo.controller;

import java.sql.*;

public class DatabaseControllerSingleton {
    private static DatabaseControllerSingleton dbs = null;
    public static Connection DBconnect;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String DriverName = "com.mysql.cj.jdbc.Driver";
    private static String DBdatabase = "";
    private static String DBuser = "";
    private static String DBpassword = "";
    private static String DBurl = "jdbc:mysql://mysql29.unoeuro.com/" + DBdatabase + "?user=" + DBuser + "&password=" + DBpassword + "&useSSL=false&serverTimezone=UTC";
    public static String DBprefix = "OneToMany_";

    // Database configuration start
    private DatabaseControllerSingleton() {
        try {
            Class.forName(DriverName).newInstance();
            DBconnect = DriverManager.getConnection(DBurl, DBuser, DBpassword);
            DriverName = "";
            DBdatabase = "";
            DBuser = "";
            DBpassword = "";
            DBurl = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Database configuration end

    // Database getInstance() Start
    public static DatabaseControllerSingleton GetInstance() {
        if (dbs == null) {
            dbs = new DatabaseControllerSingleton();
        }
        return dbs;
    }
    // Database getInstance() End

    // Outputs a query from a sql string
    public ResultSet dbQuery(String SQLstring) {
        try {
            resultSet = statement.executeQuery(SQLstring);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    // Performs a query from a sql string
    public void dbUpdate(String SQLstring) {
        try {
            statement.executeUpdate(SQLstring);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void statementUpdate(PreparedStatement preparedStatement) {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet statementQuery(PreparedStatement preparedStatement) {
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // Returns the number of rows in a ResultSet
    public int resultCount(ResultSet set) throws SQLException {
        int rowCount;
        int currentRow = set.getRow();              // Get current row
        rowCount = set.last() ? set.getRow() : 0;   // Determine number of rows
        if (currentRow == 0) {                      // If there was no current row
            set.beforeFirst();                      // We want next() to go to first row
        } else {                                    // If there WAS a current row
            set.absolute(currentRow);               // Restore it
        }

        return rowCount;
    }

    // Securing a string before using in sql string
    public String res(String content) {
        try {
            content = content.replaceAll("\n", "\\n")
                    .replaceAll("\r", "\\r")
                    .replaceAll("\t", "\\t")
                    .replaceAll("\00", "\\0")
                    .replaceAll("'", "\\'")
            /* replaceAll("\", "\\\\") */
            /*.replaceAll("\\"", "\\\"")*/;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return content;
    }
}