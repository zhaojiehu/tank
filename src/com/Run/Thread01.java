package com.Run;
//继承Thread就是线程
//基本会重写run方法,run方法 是Thread实现了Runable的一个方法:
public class Thread01 extends  Thread {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

    }

    @Override
    public void run() {
        super.run();
        int time = 1000;
        do {
            System.out.println("喵喵喵" + (++time));
            try {
                Thread01.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time == 1080) {
                break;
            }
        } while (true);
    }
}

class Dog implements Runnable{
        int time = 0;
    @Override
        public void run() {
            while (true){
                System.out.println("汪"+(++time));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(time == 8){
                    break;
                }
            }
        }
    }

