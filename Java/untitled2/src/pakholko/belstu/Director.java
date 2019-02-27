package pakholko.belstu;
import java.util.Arrays;

//Создать программного директора.
// В его функции входит поиск самой длинной передачи, передачи, относящейся к определенному типу,
// подсчет длительности всей программы, сортировка передач (критерий определите сами).
interface Direction{
    Broadcast[] Sort(Broadcast[] br);
    void TypeFind(String s,Broadcast[] br);
    void MaxTime(Broadcast[] br);
    int SumTime(Broadcast[] br);
}

public final class Director {
    public static Broadcast[] Sort(Broadcast[] br){
        Broadcast temp;
        for (int i = 0; i < 7 - 1; i++) {
            for (int j = 0; j < 7 - i - 1; j++) {
                if (br[j].length < br[j + 1].length) {
                    // меняем элементы местами
                    temp = br[j];
                    br[j] = br[j + 1];
                    br[j + 1] = temp;
                }
            }
        }
        for(Broadcast p: br) {
            System.out.println(p.type+" ("+p.length+")");
        }
        return br;
    }
    public static void MaxTime(Broadcast[] br){
        br = Sort(br);
        System.out.println("MaxLength: " + br[0].type+" ("+br[0].length+")");
    }
    public static void TypeFind(String s,Broadcast[] br){
        int count =0;
        for(Broadcast p: br) {
            if (p.type==s) {
                System.out.println(p.type+" ("+p.length+")");
                count++;
            }
        }
        System.out.println("Count of "+s+": "+count);
    }
    public static int SumTime(Broadcast[] br){
        int sum=0;
        for(Broadcast p: br) {
            sum+=p.length;
        }
        return sum;
    }
}
