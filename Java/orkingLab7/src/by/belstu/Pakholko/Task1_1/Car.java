package by.belstu.Pakholko.Task1_1;

import java.util.Random;

public class Car extends Thread {
    public String carsName;
    public Street street;
    Random random = new Random();

    public Car(int pCarName, Street pStreet)
    {
        this.carsName = String.valueOf(pCarName);
        this.street = pStreet;
    }

    @Override
    public void run()
    {
        synchronized (street) {
                boolean flag = random.nextBoolean();//рандомно распределяем
                if (flag) {
                    street.addCarToFirstDirection(this);
                }
                else {
                    street.addCarToSecondDirection(this);
                }
                System.out.println("Машинка №" + this.getCarsName() + " находится на " + (flag?1:2) + " направлении");
                try
                {
                    street.wait(1500);
                    street.crossTheRoad();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public String getCarsName(){
        return this.carsName;
    }
}
