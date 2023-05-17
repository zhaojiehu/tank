package com.tankNew3.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 画板
 * 因为当子弹线程运行时,paint方法也要重绘,所以可以把MyPaint也做成线程类:
 */
@SuppressWarnings({"all"})
public class MyPaint extends JPanel implements KeyListener, Runnable {
    Hero hero;//我方坦克.
    //getDir 0 = up,1 = down, 2 = lift, 3 = right.
    Vector<Envey> EnvetTank = new Vector();//敌人坦克集合
    int EnveySize = 3;//敌人坦克数量
    Vector<Bomb> Bombs = new Vector();//坦克爆炸集合
    //炸弹图片
    Image image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_3.jpg"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_13.jpg"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_16.jpg"));

    public MyPaint() {
        hero = new Hero(200, 200);
        for (int i = 0; i < EnveySize; i++) {
            Envey envey = new Envey(100 * (i + 1), 0);
            EnvetTank.add(envey);
            new Thread(envey).start();//启动敌人坦克线程;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        if (hero.isTankLive()) {
            paintTank(hero.getX(), hero.getY(), 0, hero.getDir(), g);
        }
        for (Envey envey : EnvetTank) {
            if (envey.isTankLive()) {
                paintTank(envey.getX(), envey.getY(), 1, envey.getDir(), g);
            }
            g.setColor(Color.RED);
//            for (Object o :envey.bull) {
//                bullet Bull = (bullet) o;
//                if(Bull != null && envey.isTankLive() && Bull.isLoopLive()){
//                    g.fill3DRect(Bull.getX(),Bull.getY(),3,3,false);
//                }
//            }
            //绘制敌人子弹和击中效果:
            for (int i = 0; i < envey.bull.size(); i++) {
                bullet Bull = (bullet) envey.bull.get(i);
                if (Bull != null && envey.isTankLive() && Bull.isLoopLive()) {
                    g.fill3DRect(Bull.getX(), Bull.getY(), 3, 3, false);
                } else {
                    envey.bull.remove(i);
                }
                switch (hero.getDir()) {
                    case 0:
                    case 1:
                        if (hero.isTankLive() && hero.getX() < Bull.getX() && Bull.getX()
                                < hero.getX() + 40 && hero.getY()
                                < Bull.getY() && Bull.getY() < hero.getY() + 60) {
                            hero.setTankLive(false);
                            Bull.setLoopLive(false);
                            Bombs.add(new Bomb(hero.getX(), hero.getY()));
                        }
                        break;
                    case 2:
                    case 3:
                        if (hero.getX() < Bull.getX() && Bull.getX()
                                < hero.getX() + 60 && hero.getY()
                                < Bull.getY() && Bull.getY() < hero.getY() + 40) {
                            hero.setTankLive(false);
                            Bull.setLoopLive(false);
                            Bombs.add(new Bomb(hero.getX(), hero.getY()));
                        }
                }
            }
        }
        //描绘我方子弹;
        g.setColor(Color.CYAN);
        for (int i = 0; i < hero.shot.size(); i++) {
            bullet Bullet = (bullet) hero.shot.get(i);
            if (Bullet != null && Bullet.isLoopLive()) {
                g.fill3DRect(Bullet.getX(), Bullet.getY(), 5, 5, false);
            } else {
                hero.shot.remove(i);
            }
            //控制子弹射坦克//其实应该把判断封装成一个方法!!!
            for (int j = 0; j < EnvetTank.size(); j++) {
                Envey envey = EnvetTank.get(j);
                switch (envey.getDir()) {
                    case 0:
                    case 1:
                        if (envey.getX() < Bullet.getX() && Bullet.getX()
                                < envey.getX() + 40 && envey.getY()
                                < Bullet.getY() && Bullet.getY() < envey.getY() + 60) {
                            envey.setTankLive(false);
                            Bullet.setLoopLive(false);
                            Bombs.add(new Bomb(envey.getX(), envey.getY()));
                            EnvetTank.remove(j);
                            hero.shot.remove(i);
                        }
                        break;
                    case 2:
                    case 3:
                        if (envey.getX() < Bullet.getX() && Bullet.getX()
                                < envey.getX() + 60 && envey.getY()
                                < Bullet.getY() && Bullet.getY() < envey.getY() + 40) {
                            envey.setTankLive(false);
                            Bullet.setLoopLive(false);
                            Bombs.add(new Bomb(envey.getX(), envey.getY()));
                            EnvetTank.remove(j);
                            hero.shot.remove(i);
                        }
                }
            }
        }
        //描绘坦克被炸
        if (Bombs != null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < Bombs.size(); i++) {
                Bomb bomb = (Bomb) Bombs.get(i);
                switch (bomb.die()) {
                    case 3:
                        g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
                        break;
                    case 2:
                        g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
                        break;
                    case 1:
                        g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
                        break;
                    case 0:
                        Bombs.remove(i);
                }
            }
        }
    }

    public void paintTank(int x, int y, int type, int dir, Graphics g) {
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
            case 2:
                g.setColor(Color.BLUE);
        }
        switch (dir) {
            case 0:
                PaintU(x, y, g);
                break;
            case 1:
                PaintD(x, y, g);
                break;
            case 2:
                PaintL(x, y, g);
                break;
            case 3:
                PaintR(x, y, g);
        }
    }

    public void PaintU(int x, int y, Graphics g) {
        g.fill3DRect(x, y, 10, 60, false);
        g.fill3DRect(x + 30, y, 10, 60, false);
        g.fill3DRect(x + 10, y + 10, 20, 40, false);
        g.drawOval(x + 10, y + 20, 20, 20);
        g.drawRect(x + 19, y, 2, 20);
    }

    public void PaintD(int x, int y, Graphics g) {
        g.fill3DRect(x, y, 10, 60, false);
        g.fill3DRect(x + 30, y, 10, 60, false);
        g.fill3DRect(x + 10, y + 10, 20, 40, false);
        g.drawOval(x + 10, y + 20, 20, 20);
        g.drawRect(x + 19, y + 40, 2, 20);
    }

    public void PaintL(int x, int y, Graphics g) {
        g.fill3DRect(x, y, 60, 10, false);
        g.fill3DRect(x, y + 30, 60, 10, false);
        g.fill3DRect(x + 10, y + 10, 40, 20, false);
        g.drawOval(x + 20, y + 10, 20, 20);
        g.drawRect(x, y + 19, 20, 2);
    }

    public void PaintR(int x, int y, Graphics g) {
        g.fill3DRect(x, y, 60, 10, false);
        g.fill3DRect(x, y + 30, 60, 10, false);
        g.fill3DRect(x + 10, y + 10, 40, 20, false);
        g.drawOval(x + 20, y + 10, 20, 20);
        g.drawRect(x + 40, y + 19, 20, 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                hero.drawDown();
                hero.setDir(1);
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
                if (hero.shot.size() >= 0 && hero.shot.size() <= 1)
                    hero.showBullet();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
