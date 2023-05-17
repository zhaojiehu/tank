package com.Run;

public class SellTicket {
    public static void main(String[] args) throws Exception{
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        Thread.sleep(10000);
        sellTicket02.setLoop(false);

    }
}

class  SellTicket01 extends Thread{
    private static int num = 100;
    @Override
    public void run() {
        super.run();
        while (true){
            if(num <= 0){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 "+ Thread.currentThread().getName()
                    + "售出一张票"+ "剩余"+(--num)+"张票");
        }
    }

}
class SellTicket02 implements Runnable{
    private int num = 100;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
//            if(num <= 0){
//                break;
//            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 "+ Thread.currentThread().getName()
                    + "售出一张票"+ "剩余"+(--num)+"张票");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
