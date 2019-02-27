package by.belstu.Pakholko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDAO implements IDAO {

    private String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Space";

    public MyDAO(){
        try{
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public IGenDAO<Planets, Integer> getPlanetsDAO(Connection connection) {
        return new MyDAO_Planets(connection);
    }

    @Override
    public IGenDAO<Satellites, Integer> getSatellitesDAO(Connection connection) {
        return new MyDAO_Sattelites(connection);
    }
}
