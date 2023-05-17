package com.Run;

public class Threadmethid02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5){
                //线程礼让,不一定成功:
                Thread.yield();
                //线程插队,一定成功:
                t2.join();
            }
            System.out.println("holle"+i);
        }
    }
}
class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("hi"+1);
        }
    }
}
