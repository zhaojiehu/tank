package com.Run.work;

public class work2 {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account).start();
        new Thread(account).start();
    }
}
class Account implements Runnable{
    private int money = 10000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取款1000,余额为" + money);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("退出线程"+Thread.currentThread().getName());

    }
}
