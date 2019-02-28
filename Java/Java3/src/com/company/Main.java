package com.company;

import abstractfactory.*;
import book.*;
import booklet.*;
import edition.*;
import librarian.*;
import magazine.*;
import library.*;



import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
//Log4j способен просматривать файл log4j.xml для изменений конфигурации. Если вы измените файл log4j, log4j автоматически обновит уровни журнала в соответствии с вашими изменениями.

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
        //DOMConfigurator для отправки одного из предопределенных наборов конфигураций журналов XML
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        try
        {
            LOG.info("Start Program.");
            Librarian lib = Librarian.getInstance();
            Library lib1 = lib.create("september");
            LOG.info("Book's List");
            lib1.AddEdition(new Book("Милый друг", " Ги де Мопассан", 2018, 2018, 40, 12345, "Publhouse",Type.PHANTASY));
            lib1.AddEdition(new Book("Девушка в поезде", "Пола Хоккинс", 2016, 1000, 15, 1237, "Publlll",Type.PHANTASY));
            lib1.AddEdition(new Booklet("Буклет", "Буклетович", 2017, 300, 25));
            lib1.AddEdition(new Magazine("Мурзилка", "МDK", 1990, 2018,8,10000));
            LOG.info("Cost of Books");
            System.out.println("Total cost of library: " + lib.totalcost(lib1));
            lib.sort(lib1);
            LOG.info("Sorting by year");
            System.out.println("Sort library ");
            for(Edition ed : lib1.GetLibrary())
            {
                System.out.println(ed.toString());
            }

            System.out.println("book with 2018 pages: ");
            LOG.info("Sorting by pages");
            for(Edition ed : lib.find(lib1, 2018).GetLibrary()) {
                System.out.println(ed.toString());
            }

            LOG.info("End Program.");
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        finally {
            System.out.println("proc finally");
        }
    }
}

