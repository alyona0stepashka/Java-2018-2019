package by.belstu.Pakholko.Task1_2;

import java.util.Random;

public class Main {
    public static final int STUDCOUNT = 5;
    public static final int CANTEENSIZE = 2;

    public static void main(String[] args)
    {
        Canteen canteen = new Canteen(CANTEENSIZE,STUDCOUNT);
        Random rand = new Random();

        for (int i = 0; i < STUDCOUNT; i++)
        {
            (new Student(i+1, canteen)).start();
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
