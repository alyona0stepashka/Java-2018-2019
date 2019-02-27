package by.belstu.it.Pakholko;

public class Main {

    public static void main(String[] args) {
        WorkWithSite worker = new WorkWithSite();
        worker.getLocalHost();
        worker.getByName("www.belstu.by");
        byte ip[] = {(byte)127,(byte)0,(byte)0,(byte)7};
        worker.getByAdress("Unknown",ip);
        worker.ReadHTML("https://www.tut.by");
        worker.getInfo("https://www.tut.by");
    }
}
