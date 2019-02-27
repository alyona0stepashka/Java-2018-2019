package books;

import Interface.IAbout;
import org.apache.log4j.Logger;

public class Catalogue extends mainBook implements IAbout
{
    private static final Logger LOG = Logger.getLogger(Catalogue.class);
    private  String Copyright;

    public String getCopyright() {
        return Copyright;
    }

    public void setCopyright(String copyright) {
        Copyright = copyright;
    }

    public Catalogue(String name, int cost, String copyright) {
        super(name, cost);
        Copyright = copyright;
    }
    @Override
    public String talkUrSelf() {
        LOG.info("Метод talksUrself"+this.getName()+" "+this.getCost()+" "+this.getCopyright());
        return "Журнал: "+ this.getName()+" "+this.getCost()+" "+this.getCopyright();
    }

    public Catalogue() {}
}
