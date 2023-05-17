package com.tank03.bullet;

import com.tank03.tank.tankgame01;

import javax.swing.*;

public class bullet1 extends JFrame{
    MyPaint mp;

    public static void main(String[] args) {
       new bullet1();

    }
    public bullet1(){
        mp = new MyPaint();
        this.add(mp);
        this.setSize(1080,1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        new Thread(mp).start();
    }
}
