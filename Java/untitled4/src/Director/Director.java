package Director;
import Broadcast.Broadcast;
import Broadcast.Type;
import ShowAbstract.Show;
import tv.TV;
import java.util.*;

public class Director extends Show implements IDirector {

    private static Director _instance = null;
    public synchronized static Director getInstance() {
        if (_instance == null)
            _instance = new Director();//если нулл то создаём
        return _instance;//если не нулл то ничего не создаём
    }

    //паттерн одиночка
//Одиночка — это порождающий паттерн, который гарантирует существование только одного объекта определённого класса,
// а также позволяет достучаться до этого объекта из любого места программы.

    public void SortMin(TV tv) {
        tv.brList.sort(new Comparator<Broadcast>() {
            @Override
            public int compare(Broadcast e1, Broadcast e2) {
                // -1 - less than, 1 - greater than, 0 - equal
                return e1.min > e2.min ? -1 : (e1.min > e2.min) ? 1 : 0;
            }
        }
        );
    }
    public Broadcast MaxMin(TV tv){
        Broadcast br = new Broadcast("q",0, Type.REKLAMA);
        for (Broadcast b:tv.brList) if (br.min<=b.min)  br=b;
        return br;
    }
    public int SumMin(TV tv){
        int sum=0;
        for (Broadcast b:tv.brList) sum+=b.min;
        return sum;
    }
    public ArrayList<Broadcast> FindType(TV tv){
        ArrayList<Broadcast> br = new ArrayList<Broadcast>();
        for (Broadcast b:tv.brList) if (b.brType==Type.REKLAMA) {
            br.add(b);
        }
        return br;
    }

    public void ShowIt(Broadcast br) {
        System.out.println(br.toString());
    }
}
