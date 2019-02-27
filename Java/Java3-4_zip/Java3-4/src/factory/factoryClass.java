package factory;

import books.Bucklet;
import books.Catalogue;
import books.book;
import enums.fabricEnum;
import Interface.IAbout;
import org.apache.log4j.Logger;

public final class factoryClass
{
    private static final Logger LOG = Logger.getLogger(factoryClass.class);
    public  static IAbout getItem(fabricEnum a)
    {
        LOG.info("Запрос у фабрики на создание элемента ");
        IAbout rettupe = null;
        switch (a)
        {
            case book:
                rettupe = new book();
                break;
            case Bucklet:
                rettupe = new Bucklet();
                break;
            case catalogue:
                rettupe = new Catalogue();
                break;
        }
        return rettupe;
    }
}
