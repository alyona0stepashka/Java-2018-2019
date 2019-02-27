package pakholko.belstu;

import Broadcast.Broadcast;
import Broadcast.Type;
import Director.Director;
import tv.TV;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
//Log4j способен просматривать файл log4j.xml для изменений конфигурации.
// Если вы измените файл log4j, log4j автоматически обновит уровни журнала в соответствии с вашими изменениями.


public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
        //DOMConfigurator для отправки одного из предопределенных наборов конфигураций журналов XML
    }

    private static final Logger LOG = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        try
        {



            LOG.info("Begin.");

        Director director = Director.getInstance();

        TV tv = new TV();
        tv.brList.add(new Broadcast("Our Story", 30, Type.NEWS));
        tv.brList.add(new Broadcast("R1", 3, Type.REKLAMA));
        tv.brList.add(new Broadcast("Big Fish", 15, Type.MULT));
        tv.brList.add(new Broadcast("R2", 2, Type.REKLAMA));
        tv.brList.add(new Broadcast("Boom", 140, Type.FILM));
        tv.brList.add(new Broadcast("Our Story", 30, Type.NEWS));
        System.out.println();

        LOG.info("Sort by minutes");
        director.SortMin(tv);
        for (Broadcast b:tv.brList) System.out.println(b.toString());
        System.out.println();

        LOG.info("Broadcast with max minutes");
        Broadcast br = director.MaxMin(tv);
        System.out.println(br.toString());
        System.out.println();

        LOG.info("Summary minutes for day");
        System.out.println(director.SumMin(tv));
        System.out.println();

        LOG.info("Broadcast (REKLAMA type)");
        ArrayList<Broadcast> brL = director.FindType(tv);
        for (Broadcast b:brL) System.out.println(b.toString());
        System.out.println();

        LOG.info("Show broadcast by once");
        director.ShowIt(br);

        System.out.println();LOG.info("End.");

        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("finally");
        }
    }
}
