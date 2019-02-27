package pakholko.belstu;

public class Broadcast {
    public String type;
    public int length;

    public Broadcast(String str, int l){
        type=str;
        length=l;
    }
    public String ToString(){
        return ("Type "+type+"("+length+")");
    }
}
