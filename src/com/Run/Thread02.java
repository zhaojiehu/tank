package com.Run;

public class Thread02 {
    public static void main(String[] args) {
        car car = new car();
        car.start();
        cup cup = new cup();
        Thread thread = new Thread(cup);
        thread.start();
    }
}
class car extends Thread{
    int a = 0;
    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("holle,world"+(++a));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(a == 10){
                break;
            }
        }
    }
}
class cup implements Runnable{

    @Override
    public void run() {
        int a = 0;
        while (true) {
            System.out.println("汪" + (++a));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(a == 8){
                break;
            }
        }
    }
}