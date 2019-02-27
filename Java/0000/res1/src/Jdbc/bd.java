package Jdbc;

import java.sql.*;

public class bd {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433;databaseName=db1");
            Statement statement =connection.createStatement();
            statement.execute("Insert Table_1(A,B) values('NEW_A','NEW_B') ");
            statement.execute("Delete from Table_1 where A='A1'");
            ResultSet str= statement.executeQuery("Select * from Table_1 ");//where A='A1'
            while (str.next())
            {
                System.out.println(str.getString("A")+" "+str.getString("B"));
            }
            connection.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
