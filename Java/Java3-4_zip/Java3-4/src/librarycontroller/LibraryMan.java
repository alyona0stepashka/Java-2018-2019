package librarycontroller;
import books.mainBook;
import library.library;
import org.apache.log4j.Logger;

import java.util.Comparator;

public final class LibraryMan
{
    private static final Logger LOG = Logger.getLogger(LibraryMan.class);
    private static LibraryMan man = null;

    public static LibraryMan getInsnatce()
    {
        if(man==null)
        {
            man = new LibraryMan();
        }
            return  man;
    }
    public void talkAboutLib(library a)
    {
        LOG.info("Метод вывода библиотеки класс libraryMan");
        for (int i = 0; i < a.getCollection().size(); i++) {
            System.out.println(a.getCollection().get(i).talkUrSelf());
        }
    }

    public void searchLib(library a, int paper)
    {
        LOG.info("Метод поиска в библиотеке класс libraryMan");
        for (int i = 0; i < a.getCollection().size(); i++) {
            if(a.getCollection().get(i).getPapers() == paper)
                System.out.println(a.getCollection().get(i).talkUrSelf());
        }
    }

    public  void sort(library a)
    {
        LOG.info("Метод сортировки библиотеки класс libraryMan");
        a.getCollection().sort(new Comparator<mainBook>() {
            @Override
            public int compare(mainBook o1, mainBook o2) {
                return  o1.getName().compareTo(o2.getName());
            }
        });
    }
}



