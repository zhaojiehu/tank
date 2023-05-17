package com.Run.work;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {
        math1 math1 = new math1();
        new Thread(math1).start();
        Control control = new Control(math1);
        new Thread(control).start();
    }
}
class math1 implements Runnable{
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            System.out.println((int)(Math.random()*100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
class Control implements Runnable {
    math1 ma;
    private Scanner scanner =  new Scanner(System.in);
    public Control(math1 ma) {
        this.ma = ma;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入Q,结束");
            char At = scanner.next().charAt(0);
            if(At == 'q'){
                ma.setLoop(false);
                break;
            }
        }
    }


}
