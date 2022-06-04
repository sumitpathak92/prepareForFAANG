package DesignPatterns.FacadeDesignPattern;

import java.sql.Connection;

public class MySQLConnector implements DBInterface{

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void generatePDFReport(String tableName, Connection conn) {

    }

    @Override
    public void generateHTMLReport(String tableName, Connection conn) {

    }
}
