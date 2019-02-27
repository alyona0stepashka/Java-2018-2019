package classes;

import java.util.Arrays;

//Создать программного директора.
// В его функции входит поиск самой длинной передачи, передачи, относящейся к определенному типу,
// подсчет длительности всей программы, сортировка передач (критерий определите сами).

public final class Director {
    public static Broadcast[] Sort(Broadcast[] br){
        Arrays.sort(br);
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
        for(Broadcast p: br) {
            if (p.type==s)
                System.out.println(p.type+" ("+p.length+")");
        }
    }
    public static int SumTime(Broadcast[] br){
        int sum=0;
        for(Broadcast p: br) {
            sum+=p.length;
        }
        return sum;
    }
}
