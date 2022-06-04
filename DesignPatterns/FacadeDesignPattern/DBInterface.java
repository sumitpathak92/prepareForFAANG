package DesignPatterns.FacadeDesignPattern;

import java.sql.Connection;

public interface DBInterface {

    Connection getConnection();

    void generatePDFReport(String tableName, Connection conn);

    void generateHTMLReport(String tableName, Connection conn);

}
