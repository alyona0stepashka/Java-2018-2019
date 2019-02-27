package by.belstu.Pakholko;

//import com.sun.tools.javac.util.Convert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDAO_Sattelites implements IGenDAO<Satellites, Integer> {
    private final Connection connection;

    public MyDAO_Sattelites(Connection connection) {
        this.connection = connection;
    }

    public void updateRadiusByName(String name, int newRadius) throws SQLException {
        String sql = "UPDATE Satellite SET Radius = ? Where Name = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, newRadius);
        stm.setString(2, name);
        stm.executeUpdate();
    }
    public List<String> getWithMinRadius() throws SQLException {
        String sql = "SELECT top(1) PlanetName, count(PlanetName) as qw from Satellite Where Radius = (select Top(1) Radius From Satellite ORDER BY Radius) group by PlanetName order by qw desc";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<String> list = new ArrayList<String>();
        String planetName = new String();
        String list_member = new  String();
        int planetCountradius = 0;
        while (rs.next()) {
            planetName = rs.getString("PlanetName");
            planetCountradius = rs.getInt("qw");
            list_member = planetName + " has max kolvo of satellites with min radius: " + Integer.toString(planetCountradius);
            list.add(list_member);
        }
        return list;
    }


    public List<String> getWithMaxRadius() throws SQLException {
        String sql = "SELECT top(1) PlanetName, sum(Radius) as rad FROM Satellite Group by PlanetName order by rad desc;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<String> list = new ArrayList<String>();
        String planetName = new String();
        String list_member = new  String();
        int planetCountradius = 0;
        while (rs.next()) {
            planetName = rs.getString("PlanetName");
            planetCountradius = rs.getInt("rad");
            list_member = planetName + " has the largest sum of satellite's radius: " + Integer.toString(planetCountradius);
            list.add(list_member);
        }
        return list;
    }

    @Override
    public Satellites read(String key) throws SQLException {
        String sql = "SELECT * FROM Satellite WHERE NAME = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, key);
        ResultSet rs = stm.executeQuery();
        rs.next();
        Satellites s = new Satellites();
        s.DistanceToPlanet = rs.getInt("DistanceToPlanet");
        s.Radius = rs.getInt("Radius");
        s.Name = rs.getString("Name");
        s.PlanetName = rs.getString("PlanetName");
        return s;
    }

    @Override
    public List<Satellites> getAll() throws SQLException {
        String sql = "SELECT * FROM Satellite;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Satellites> list = new ArrayList<Satellites>();
        while (rs.next()) {
            Satellites s = new Satellites();
            s.DistanceToPlanet = rs.getInt("DistanceToPlanet");
            s.Radius = rs.getInt("Radius");
            s.Name = rs.getString("Name");
            s.PlanetName = rs.getString("PlanetName");
            list.add(s);
        }
        return list;
    }
}
