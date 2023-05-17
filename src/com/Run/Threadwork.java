package com.Run;

public class Threadwork {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+ "数字"+ (i+1));
            Thread.sleep(1000);
            if(i == 4){
                System.out.println("主线程中断,子线程执行");
                A a = new A();
                Thread thread = new Thread(a);
                thread.setDaemon(true);
                thread.start();
            }
        }
        System.out.println("主线程结束");
    }
}
class A implements Runnable{
    @Override
    public void run() {
        for (; ;) {
            System.out.println("hi"+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
