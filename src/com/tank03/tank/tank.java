package com.tank03.tank;

public class tank {
    private int x ;
    private int y;
    private int bulletX ;
    private int BulletY ;
    private int dir;
    private int speed = 1;

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void drawUP(){
        y = y -speed;
    }
    public void drawDown(){
        y = y +speed;
    }
    public void drawLift(){
        x = x - speed;
    }
    public void drawRight(){
        x = x + speed;
    }

}
