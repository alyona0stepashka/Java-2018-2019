package Director;

import Broadcast.Broadcast;
import tv.TV;

import java.util.ArrayList;

public interface IDirector {
    public void SortMin(TV tv);
    public Broadcast MaxMin(TV tv);
    public int SumMin(TV tv);
    public ArrayList<Broadcast> FindType(TV tv);
}
