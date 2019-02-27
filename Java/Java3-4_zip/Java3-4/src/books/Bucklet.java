package books;

import Interface.IAbout;
import org.apache.log4j.Logger;

public class Bucklet extends mainBook implements IAbout
{
    private static final Logger LOG = Logger.getLogger(Bucklet.class);
    private String BuckletThem;

    public String getBuckletThem() {
        return BuckletThem;
    }

    public void setBuckletThem(String buckletThem) {
        BuckletThem = buckletThem;
    }

    public Bucklet(String name, int cost, String buckletThem) {
        super(name, cost);
        BuckletThem = buckletThem;
    }

    public  Bucklet(){}

    @Override
    public String talkUrSelf() {
        LOG.info("Метод talksUrself"+this.getName()+" "+this.getCost()+" "+this.getBuckletThem());
        return "Буклет: "+ this.getName()+" "+this.getCost()+" "+this.getBuckletThem();
    }
}
