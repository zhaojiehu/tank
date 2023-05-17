package com.tank;

import javax.swing.*;
import java.awt.*;

public class MyPaint extends JPanel {
    Hero hero ;
    public MyPaint(){
        hero = new Hero(100,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        paintTank(hero.getX(),hero.getY(),0,0,g);
        paintTank(hero.getX()+100,hero.getY(),1,0,g);
        paintTank(hero.getX()+200,hero.getY(),2,0,g);
    }

    public void paintTank(int x,int y,int type,int dir,Graphics g){
        switch (type){
            case 0 : g.setColor(Color.CYAN); break;
            case 1 : g.setColor(Color.yellow); break;
            case 2 : g.setColor(Color.BLUE);
        }
        switch (dir){
            case 0 :
                PaintT( x, y, g);
                break;
            case 1 :
        }
    }

    public void PaintT(int x,int y,Graphics g){
        g.fill3DRect( x, y,10,60,false);
        g.fill3DRect(x+30, y,10,60,false);
        g.fill3DRect(x+10,y+10,20,40,false);
        g.drawOval(x+10,y+20,20,20);
        g.drawRect(x+19,y,2,20);
    }
}
