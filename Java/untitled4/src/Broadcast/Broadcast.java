package Broadcast;

public class Broadcast extends SuperBroadcast {
    public Type brType;

    public Broadcast(String n, int m, Type t) {
        name=n;
        min=m;
        brType=t;
    }

    @Override
    public String toString() {
        return "Name: "+this.name+", min: "+this.min+", type: "+this.brType;
    }

}
