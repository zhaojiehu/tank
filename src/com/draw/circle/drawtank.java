package com.draw.circle;

import javax.swing.*;
import java.awt.*;

public class drawtank extends JFrame {
    MyPaintTank mp = null;
    public static void main(String[] args) {
        new drawtank();
    }
    public drawtank(){
        mp = new MyPaintTank();
        this.add(mp);
        this.setSize(1080,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPaintTank extends JPanel {
//绘图方法:

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.CYAN);

        g.fill3DRect(100,400,60,250,false);
        g.fill3DRect(240,400,60,250,false);
        g.fill3DRect(160,442,80,200,false);
        g.setColor(Color.CYAN);
        g.fillOval(160,502,80,80);
        g.fillRect(196,400,10,125);
    }
}
