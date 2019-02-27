package books;

import Interface.IAbout;

public abstract class mainBook implements IAbout
{
    private  String name;
    private int Cost;
    private int Papers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public int getPapers() {
        return Papers;
    }

    public void setPapers(int papers) {
        Papers = papers;
    }

    public mainBook(String name, int cost) {
        this.name = name;
        this.Cost = cost;
    }

    public mainBook() {
    }
}
