package DesignPatterns.FacadeDesignPattern;

import java.sql.Connection;

public class FacadePatternTest {

    public static void main(String[] args) {


        String tableName = "some_name";

        // generating report without using facade
        MySQLConnector mySQLConnector = new MySQLConnector();
        Connection connection = mySQLConnector.getConnection();
        mySQLConnector.generatePDFReport(tableName, connection);
        mySQLConnector.generateHTMLReport(tableName, connection);

        OracleConnector oracleConnector = new OracleConnector();
        Connection connection1 = oracleConnector.getConnection();
        oracleConnector.generatePDFReport(tableName, connection1);
        oracleConnector.generateHTMLReport(tableName, connection1);


        // generating reports using facade pattern

        FacadeHelper.generateReport(DBTypes.MYSQL, ReportTypes.HTML, tableName);
        FacadeHelper.generateReport(DBTypes.ORACLE, ReportTypes.HTML, tableName);

    }
}
