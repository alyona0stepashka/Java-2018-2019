package librarian;

import edition.Edition;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import abstractfactory.*;
import library.*;
//instance экземпляр класса
//extends наследование
//implements реализация интерфейса
public class Librarian extends Factory implements ILibrarian {
    private static Librarian _instance = null;

//паттерн одиночка
//Одиночка — это порождающий паттерн, который гарантирует существование только одного объекта определённого класса,
// а также позволяет достучаться до этого объекта из любого места программы.
    private Librarian() {}
    public synchronized static Librarian getInstance() {
        if (_instance == null)
            _instance = new Librarian();//если нулл то создаём
        return _instance;//если не нулл то ничего не создаём
    }

    public void sort(Library e){
        ArrayList<Edition> ed = e.GetLibrary();
        ed.sort(new Comparator<Edition>() {
        @Override
        public int compare(Edition e1, Edition e2) {
            // -1 - less than, 1 - greater than, 0 - equal
            return e1.getYear() > e2.getYear() ? -1 : (e1.getYear() > e2.getYear()) ? 1 : 0;
        }
    });

    }

    public Library find(Library e, int kolvo_str)  throws NullPointerException {
        if(kolvo_str != 0) {
            Library fe = new Library();
            for (Edition ed : e.GetLibrary()) {
                if (ed.getNumber_of_pages() == kolvo_str) {
                    fe.AddEdition(ed);
                }
            }
            return fe;
        }
        else {throw new NullPointerException("Null pointer");}
    }

    public int totalcost(Library e){
        int totalcount = 0;
        for(Edition ed : e.GetLibrary())
        {
            totalcount += ed.getCost();
        }
        return totalcount;
    }
    @Override
    public Library create(String lib)
    {
        return new Library(lib);
    }
}

