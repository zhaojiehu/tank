package com.tankNew3.tank;

import java.util.Vector;

@SuppressWarnings({"all"})
public class Envey extends tank implements Runnable {
    Vector bull = new Vector<bullet>();//敌人坦克子弹集合;
    private int js = 0;//计数器;

    public Envey(int x, int y) {
        super(x, y);
        setDir(1);//默认向下
        switch (getDir()) {
            case 0:
                bull.add(new bullet(getX() + 19, getY(), 0));
                break;
            case 1:
                bull.add(new bullet(getX() + 19, getY() + 60, 1));
                break;
            case 2:
                bull.add(new bullet(getX(), getY() + 19, 2));
                break;
            case 3:
                bull.add(new bullet(getX() + 60, getY() + 19, 3));
        }
        new Thread((bullet) bull.get(0)).start();
    }

    //创建敌人子弹(敌人坦克创建就创建,一段时间自动发射子弹)
    @Override
    public void run() {
        while (isTankLive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            js++;
            if (js >= 50) {
                js = 0;
                //敌人自动发射子弹:
                switch (getDir()) {
                    case 0:
                        bull.add(new bullet(getX() + 19, getY(), 0));
                        break;
                    case 1:
                        bull.add(new bullet(getX() + 19, getY() + 60, 1));
                        break;
                    case 2:
                        bull.add(new bullet(getX(), getY() + 19, 2));
                        break;
                    case 3:
                        bull.add(new bullet(getX() + 60, getY() + 19, 3));
                }
                new Thread((bullet) bull.get(bull.size() - 1)).start();
                setDir((int) (Math.random() * 4));
                System.out.println(getDir());
            }
            switch (getDir()) {
                case 0:
                    if (getY() > 0) {
                        setY(getY() - getSpeed());
                    }
                    break;
                case 1:
                    if (getY() < 750) {
                        setY(getY() + getSpeed());
                    }
                    break;
                case 2:
                    if (getX() > 0) {
                        setX(getX() - getSpeed());
                    }
                    break;
                case 3:
                    if (getX() < 1000) {
                        setX(getX() + getSpeed());
                    }
            }
        }
    }
}
