package library;

import Interface.IAbout;
import books.mainBook;

import java.util.ArrayList;

public class library
{
    private ArrayList<mainBook> collection = new ArrayList<mainBook>();

    public ArrayList<mainBook> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<mainBook> collection) {
        this.collection = collection;
    }

    public library() {
    }

    public  void addToCollection(mainBook item)
    {
        collection.add(item);
    }

    public int getCost()
    {
        int sum = 0;
        for (int i = 0; i < collection.size(); i++) {
            sum+= collection.get(i).getCost();
        }
        return  sum;
    }
}
