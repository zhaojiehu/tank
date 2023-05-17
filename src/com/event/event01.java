package com.event;

import com.sun.javaws.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class event01 extends JFrame{
    Mypaint mp = null;
    public static void main(String[] args) {
        new event01();
    }
    public event01(){
        mp = new Mypaint();
        this.add(mp);
        //加监听器ffff
        this.addKeyListener(mp);
        this.setSize(1080,1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

//KeyListener键盘监听器
class Mypaint extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20,20);
    }

    @Override//键输出触发
    public void keyTyped(KeyEvent e) {

    }

    @Override//键按下触发
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN: y+=2;break;
            case KeyEvent.VK_UP: y-=2;break;
            case KeyEvent.VK_LEFT: x-=2;break;
            case KeyEvent.VK_RIGHT: x+=2;

        }

        //重绘
        this.repaint();
    }

    @Override//键松开触发
    public void keyReleased(KeyEvent e) {

    }
}
