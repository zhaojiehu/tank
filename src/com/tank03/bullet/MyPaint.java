package com.tank03.bullet;

import javax.swing.*;
import java.awt.*;

public class MyPaint extends JPanel implements Runnable{
    private int x = 0;
    private int y = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);//重新清空,不然会重叠;
        g.setColor(Color.RED);
        g.fillOval(x,y,5,5);
    }

    @Override
    public void run() {
        while (true){
            if(x >= 1000){
                break;
            }
            x+=3;

            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
