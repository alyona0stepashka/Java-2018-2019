package by.belstu.Pakholko;
import java.util.List;

public class Planets {
    public String Name;
    public int Radius;
    public int Temperature;
    public String IsAtmosphere;
    public String IsLife;
    public List<String> Satellites;

    @Override
    public String toString(){
        return '\n' + "Planets{"+
                "Name='"+Name+'\''+
                ", Radius="+Radius+
                ", Temperature="+Temperature+
                ", IsAtmosphere='"+IsAtmosphere+'\''+
                ", IsLife='"+IsLife+'\''+'}'+
                ", Satellites: " + Satellites.toString() + '}';
    }
}
