package com.tank02.tank;

import javax.swing.*;

public class tankgame01 extends JFrame {
    MyPaint mp ;

    public static void main(String[] args) {
        new tankgame01();
    }
    public tankgame01(){
        mp = new MyPaint();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1080,1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
