package DesignPatterns.FacadeDesignPattern;

import java.sql.Connection;

public class FacadeHelper {

    public static void generateReport(DBTypes dbType, ReportTypes reportTypes, String tableName) {
        Connection conn = null;
        switch (dbType) {
            case MYSQL:
                MySQLConnector mySQLConnector = new MySQLConnector();
                conn = mySQLConnector.getConnection();
                switch (reportTypes) {
                    case HTML:
                        mySQLConnector.generateHTMLReport(tableName, conn);
                        break;
                    case PDF:
                        mySQLConnector.generatePDFReport(tableName, conn);
                        break;
                }
                break;
            case ORACLE:
                OracleConnector oracleConnector = new OracleConnector();
                conn = oracleConnector.getConnection();
                switch (reportTypes) {
                    case HTML:
                        oracleConnector.generateHTMLReport(tableName, conn);
                        break;
                    case PDF:
                        oracleConnector.generatePDFReport(tableName, conn);
                        break;
                }
                break;
        }
    }
}

enum DBTypes {
    MYSQL, ORACLE;
}

enum ReportTypes {
    HTML, PDF;
}