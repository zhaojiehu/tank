package com.tankNew3.tank;

import java.util.Vector;

@SuppressWarnings({"all"})
public class Hero extends tank {
    Vector shot = new Vector<bullet>();//子弹集合;

    public Hero(int x, int y) {
        super(x, y);
    }

    public void showBullet() {
        //根据坦克方向确定如何创建子弹线程
        switch (getDir()) {
            case 0:
                shot.add(new bullet(getX() + 19, getY(), 0));
                break;
            case 1:
                shot.add(new bullet(getX() + 19, getY() + 60, 1));
                break;
            case 2:
                shot.add(new bullet(getX(), getY() + 19, 2));
                break;
            case 3:
                shot.add(new bullet(getX() + 60, getY() + 19, 3));
        }
        bullet Bull = (bullet) shot.get(shot.size() - 1);
        new Thread(Bull).start();
    }
}
