package com.Run;

public class Threadmethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        //线程命名:
        t.setName("jack");
        //改变优先级:
        //t.setPriority(Thread.MAX_PRIORITY);
//启动线程:
        t.start();
        for (int i = 0; i < 5; i++) {
            //<editor-fold desc="Description">
            //</editor-fold>
            System.out.println("hi"+i);
            //Thread.sleep(1000);
        }
        //执行时会中断t线程休眠:
        t.interrupt();
        //查询优先级:
        System.out.println("优先级"+t.getPriority());

    }
}
class T extends Thread{
    @Override
    public void run() {
        super.run();
        while (true) {
            for (int i = 0; i < 100; i++) {
                //获取线程名字:
                System.out.println(Thread.currentThread().getName() + "名字" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");

            }
        }
    }
}