package booklet;
import edition.Edition;
//extends наследование
public class Booklet extends Edition{
    public Booklet(String name, String author, int year, int number_of_pages, int cost)
    {
        super(name, author, year, number_of_pages, cost);

    }
//??????????????????????????????????????7это конструктор?
    public Booklet(){
        super();
    }

    @Override
    public String toString() {
        return "Буклет " + getName() + ", автор " + getAuthor()
                + ", год выпуска  " + getYear() + ", количество страниц: " + getNumber_of_pages() + ", стоимость: " + getCost();
    }
}
