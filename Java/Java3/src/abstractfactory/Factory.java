package abstractfactory;

import book.Book;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import edition.Edition;
import booklet.Booklet;
import library.Library;
import magazine.Magazine;
//Абстрактная фабрика задаёт интерфейс создания всех доступных типов продуктов, а каждая конкретная реализация фабрики порождает продукты одной из вариаций.
//который позволяет создавать семейства связанных объектов, не привязываясь к конкретным классам создаваемых объектов.
public abstract class Factory {
    public abstract Library create(String lib);
}

