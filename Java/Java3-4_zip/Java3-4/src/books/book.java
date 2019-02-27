package books;

import Interface.IAbout;
import org.apache.log4j.Logger;

public class book extends mainBook implements IAbout
{
    private static final Logger LOG = Logger.getLogger(book.class);
    private String autor;


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public book(String name, int cost, String autor) {
        super(name, cost);
        this.autor = autor;
    }
    public book(){}
    @Override
    public String talkUrSelf() {
        LOG.info("Метод talksUrself"+this.getName()+" "+this.getCost()+" "+this.getAutor());
        return "Книга:"+ this.getName()+" "+this.getCost()+" "+this.getAutor();
    }
}
