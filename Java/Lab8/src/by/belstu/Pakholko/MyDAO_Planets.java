package by.belstu.Pakholko;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyDAO_Planets implements IGenDAO<Planets, Integer> {
    private final Connection connection;

    public List<String> parser(String str)
    {
        List<String> res = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str,", ", false);
        while(tokenizer.hasMoreTokens()) {
            res.add(tokenizer.nextToken());
        }
        return res;
    }

    public MyDAO_Planets(Connection connection){
        this.connection = connection;
    }

    public List<Planets> planetsWithLife() throws SQLException{
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet WHERE IsLife = 'Y';";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planets> list = new ArrayList<Planets>();
        while(rs.next()){
            Planets p = new Planets();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getInt("Temperature");
            p.Radius = rs.getInt("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            list.add(p);
        }
        return list;
    }

    public List<Planets> planetsWithMaxSetell() throws SQLException{
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planets> list = new ArrayList<Planets>();
        while(rs.next()){
            Planets p = new Planets();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getInt("Temperature");
            p.Radius = rs.getInt("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            list.add(p);
        }
        int count = 0;
        for(Planets p : list)
        {
            if(p.Satellites.size() > count)
                count = p.Satellites.size();
        }
        List<Planets> list1 = new ArrayList<Planets>();
        for(Planets p : list)
        {
            if(p.Satellites.size() == count)
                list1.add(p);
        }
        return list1;
    }

    public List<Planets> planetsWithSetellities() throws SQLException{
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planets> list = new ArrayList<Planets>();
        while(rs.next()){
            Planets p = new Planets();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getInt("Temperature");
            p.Radius = rs.getInt("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            list.add(p);
        }
        int count = 0;
        for(Planets p : list)
        {
            if(p.Satellites.size() > count)
                count = p.Satellites.size();
        }
        List<Planets> list1 = new ArrayList<Planets>();
        for(Planets p : list)
        {
            if(p.Satellites.size() == count)
                list1.add(p);
        }
        return list1;
    }

    @Override
    public Planets read(String key) throws SQLException {
        String sql = "SELECT * FROM Planet WHERE Name = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, key);
        ResultSet rs = stm.executeQuery();
        rs.next();
        Planets p = new Planets();
        p.Name = rs.getString("Name");
        p.IsLife = rs.getString("IsLife");
        p.IsAtmosphere = rs.getString("IsAtmosphere");
        p.Temperature = rs.getInt("Temperature");
        p.Radius = rs.getInt("Radius");
        p.Satellites = this.parser(rs.getString("Satellites"));
        return p;
    }

    @Override
    public List<Planets> getAll() throws SQLException {
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM Planet;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Planets> list = new ArrayList<Planets>();
        while(rs.next()){
            Planets p = new Planets();
            p.Name = rs.getString("Name");
            p.IsLife = rs.getString("IsLife");
            p.IsAtmosphere = rs.getString("IsAtmosphere");
            p.Temperature = rs.getInt("Temperature");
            p.Radius = rs.getInt("Radius");
            p.Satellites = this.parser(rs.getString("Satellites"));
            list.add(p);
        }
        return list;
    }
}
