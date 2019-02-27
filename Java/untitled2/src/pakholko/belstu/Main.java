package pakholko.belstu;

//Программа передач. Определить иерархию телевизионных передач (новости, фильмы, мультики, реклама и т.п.).
// Сформировать  программу на день.

// Создать программного директора.
// В его функции входит поиск самой длинной передачи, передачи, относящейся к определенному типу,
// подсчет длительности всей программы, сортировка передач (критерий определите сами).

public class Main {

    public static void main(String[] args) {

        Director director = new Director();
        Broadcast mult = new Broadcast("mult", 15);
        Broadcast news = new Broadcast("news", 30);
        Broadcast film = new Broadcast("film", 120);
        Broadcast reklama = new Broadcast("reklama", 5);

        Broadcast[] day = new Broadcast[]{mult, reklama, news, reklama, film, reklama, mult};

        System.out.println();
        System.out.println("Begin sort:");
        day = director.Sort(day);
        System.out.println("End sort.");
        System.out.println();

        director.MaxTime(day);
        System.out.println();

        int sum = director.SumTime(day);
        System.out.println("Summary time: "+sum);
        System.out.println();

        director.TypeFind("mult", day);
        System.out.println();
    }
}
