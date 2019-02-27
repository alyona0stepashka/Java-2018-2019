package by.belstu.Pakholko.Task2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {
    private String name;
    private SkyCenter callCenter;
    private Semaphore semaphore;
    private int priority;
    private String age;
    public Client(SkyCenter pSkyCenter, Semaphore pSemaphore, int pName, int pPriority) {
        Random rand = new Random();
        this.name = String.valueOf(pName);
        this.semaphore = pSemaphore;
        this.callCenter = pSkyCenter;
        if(rand.nextBoolean())
        {
            this.priority = Thread.MAX_PRIORITY;
            this.age = "пенсионер";
        }
        else{
            this.priority = Thread.MIN_PRIORITY;
            this.age = "парень";
        }
    }

    public String getClientName() {
        return this.name + ", " + this.age;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int waitingTime = rand.nextInt(50000) + 100;
        System.out.println("Клиент " + this.getClientName() + " пришел");

        try {
            if (semaphore.tryAcquire(waitingTime, TimeUnit.MICROSECONDS)) {
                System.out.println("Клиент " + this.getClientName() + " беседует");
                callCenter.connect(this);
                callCenter.showLines();
                Thread.sleep(rand.nextInt(1000) + 500);
                callCenter.disconnect(this);
                semaphore.release();
                System.out.println("Клиент " + this.getClientName() + " поговорил");
            } else {
                System.out.println("Клиент " + this.getClientName() + " ушел");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
