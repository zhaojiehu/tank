package com.Run.selllike;

public class SellTicket {
    public static void main(String[] args) throws Exception{
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
    }
}

class SellTicket02 implements Runnable{
    private int num = 100;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
           synchronized (this){
               if(num <= 0){
                   break;
               }
               System.out.println("窗口 "+ Thread.currentThread().getName()
                       + "售出一张票"+ "剩余"+(--num)+"张票");
           }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // m1();
        }
        System.out.println(Thread.currentThread().getName()+"退出线程");
    }
    public synchronized void m1(){
        if(num <= 0){
            loop = false;
            return;
        }
        System.out.println("窗口 "+ Thread.currentThread().getName()
                + "售出一张票"+ "剩余"+(--num)+"张票");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
