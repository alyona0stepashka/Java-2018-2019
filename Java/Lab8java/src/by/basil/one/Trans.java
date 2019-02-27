package by.basil.one;

import java.sql.*;

public class Trans {
        /**
         * JDBC Driver and database url
         */
        static final String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver()";
        static final String DATABASE_URL = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Library;integratedSecurity=true";

        /**
         * User and Password
         */


        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Connection connection = null;
            Statement statement = null;



            connection = DriverManager.getConnection(DATABASE_URL);
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            String SQL;
            SQL = "SELECT * FROM author";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {

                String author = resultSet.getString("author");
                String countru = resultSet.getString("country");
                System.out.println("\n================\n");
                System.out.println("author: " + author);
                System.out.println("countru: " + countru);
            }

            System.out.println("\n===========================\n");
            System.out.println("Creating savepoint...");
            Savepoint savepointOne = connection.setSavepoint("SavepointOne");

            try {
                SQL = "INSERT INTO author VALUES ('Пушкин','Россия')";
                statement.executeUpdate(SQL);

                SQL = "INSERT INTO author VALUES ( 'Лермонтов', 'Россия')";
                statement.executeUpdate(SQL);

                connection.commit();
            } catch (SQLException e) {
                System.out.println("SQLException. Executing rollback to savepoint...");
                connection.rollback(savepointOne);
            }
            String SQL2;
            SQL2 = "SELECT * FROM author";

            ResultSet resultSet2 = statement.executeQuery(SQL2);
            while (resultSet2.next()) {

                String author = resultSet2.getString("author");
                String countru = resultSet2.getString("country");
                System.out.println("\n================\n");
                System.out.println("author: " + author);
                System.out.println("countru: " + countru);
            }
        }
}
