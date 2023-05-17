package com.tank03.tank;

import sun.awt.Graphics2Delegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPaint extends JPanel implements KeyListener,Runnable{
    Hero hero ;
    //getDir 0 = up,1 = down, 2 = lift, 3 = right.
    Vector<Envey> EnvetTank = new Vector();//敌人坦克集合
    int EnveySize = 3;//敌人坦克数量
    private Image OffScreenImage;
    private int jj = 0;
    int h;
    int z;
    public MyPaint(){
        hero = new Hero(200,200);
        for (int i = 0; i < EnveySize; i++) {
            EnvetTank.add(new Envey(100*(i+1),0));
        }
        h = hero.getX()+19;
        z = hero.getY()+2;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        paintTank(hero.getX(),hero.getY(),0,hero.getDir(),g);
        for (Envey envey :EnvetTank) {
            envey.setDir(1);
            paintTank(envey.getX(),envey.getY(),1,envey.getDir(),g);
        }

        if(jj != 0){
        g.setColor(Color.CYAN);
        g.fillRect(z,h,5,5);
        h -= 3;
        }


//        paintTank(EnvetTank.,hero.getY()+200,1,dir,g);
//        paintTank(hero.getX()+300,hero.getY(),0,dir,g);
//        paintTank(hero.getX()+400,hero.getY(),0,dir,g);
    }

    public void paintTank(int x,int y,int type,int dir,Graphics g){
        switch (type){
            case 0 : g.setColor(Color.CYAN); break;
            case 1 : g.setColor(Color.yellow); break;
            case 2 : g.setColor(Color.BLUE);
        }
        switch (dir){
            case 0 :
                PaintU( x, y, g);
                break;
            case 1 :
                PaintD(x, y, g);
                break;
            case 2:
                PaintL(x, y, g);
                break;
            case 3:
                PaintR(x, y, g);
        }
    }

    public void PaintU(int x,int y,Graphics g){
        g.fill3DRect( x, y,10,60,false);
        g.fill3DRect(x+30, y,10,60,false);
        g.fill3DRect(x+10,y+10,20,40,false);
        g.drawOval(x+10,y+20,20,20);
        g.drawRect(x+19,y,2,20);
    }
    public void PaintD(int x,int y, Graphics g){
        g.fill3DRect( x, y,10,60,false);
        g.fill3DRect(x+30, y,10,60,false);
        g.fill3DRect(x+10,y+10,20,40,false);
        g.drawOval(x+10,y+20,20,20);
        g.drawRect(x+19,y+40,2,20);
    }
    public void  PaintL(int x,int y,Graphics g){
        g.fill3DRect( x, y,60,10,false);
        g.fill3DRect(x, y+30,60,10,false);
        g.fill3DRect(x+10,y+10,40,20,false);
        g.drawOval(x+20,y+10,20,20);
        g.drawRect( x,y+19,20,2);
    }
    public void PaintR(int x, int y, Graphics g){
        g.fill3DRect( x, y,60,10,false);
        g.fill3DRect(x, y+30,60,10,false);
        g.fill3DRect(x+10,y+10,40,20,false);
        g.drawOval(x+20,y+10,20,20);
        g.drawRect(x+40,y+19,20,2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                hero.drawDown();
                hero.setDir(1) ;
                break;
            case KeyEvent.VK_UP:
                hero.drawUP();
                hero.setDir(0);
                break;
            case KeyEvent.VK_LEFT:
                hero.drawLift();
                hero.setDir(2);
                break;
            case KeyEvent.VK_RIGHT:
                hero.drawRight();
                hero.setDir(3);
                break;
            case KeyEvent.VK_J:
                Thread thread = new Thread(this);
                thread.start();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

//    @Override
//    public void update(Graphics g) {
//        if(OffScreenImage == null){
//            OffScreenImage = this.createImage(1000,750);
//        }
//        Graphics gImage = OffScreenImage.getGraphics();
//        paint(gImage);
//        g.drawImage(OffScreenImage,0,0,null);
//    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2D = (Graphics2D) g;
//    }

    @Override
    public void run() {
         z = hero.getX()+19;
         h = hero.getY()+2;
         jj = 1;
        while (true){
            if(h <= 0 || h >= 750){
                break;
            }
            this.repaint();
//            getGraphics().setColor(Color.CYAN);
//            getGraphics().fillRect(z,h,2,2);
            h -= 3;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //this.repaint();
        }

    }
}
