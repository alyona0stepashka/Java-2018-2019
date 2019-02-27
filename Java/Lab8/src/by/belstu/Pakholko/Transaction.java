package by.belstu.Pakholko;

import java.sql.*;

public class Transaction {
    static final String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver()";
    static final String DATABASE_URL = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Space;integratedSecurity=true";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;



        connection = DriverManager.getConnection(DATABASE_URL);
        connection.setAutoCommit(false);

        statement = connection.createStatement();

        String SQL;
        SQL = "SELECT * FROM Satellite";

        ResultSet resultSet = statement.executeQuery(SQL);

        while (resultSet.next()) {

            String satel = resultSet.getString("Name");
            String planet = resultSet.getString("PlanetName");
            System.out.println("================");
            System.out.println("Satellite: " + satel);
            System.out.println("Planet: " + planet);
        }

        System.out.println("\n===========================\n");
        System.out.println("Creating savepoint...");
        Savepoint savepointOne = connection.setSavepoint("SavepointOne");

        try {
            SQL = "INSERT INTO Satellite VALUES (1234,'kuku',1345678,'Earth')";
            statement.executeUpdate(SQL);

            SQL = "INSERT INTO Satellite VALUES (174, 'beze', 132323, 'Mars')";
            statement.executeUpdate(SQL);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQLException. Executing rollback to savepoint...");
            connection.rollback(savepointOne);
        }
        String SQL2;
        SQL2 = "SELECT * FROM Satellite";

        ResultSet resultSet2 = statement.executeQuery(SQL2);
        while (resultSet2.next()) {
            String satel = resultSet2.getString("Name");
            String planet = resultSet2.getString("PlanetName");
            System.out.println("================");
            System.out.println("Satellite: " + satel);
            System.out.println("Planet: " + planet);
        }
    }

}
