package com.tankNew3.tank;

import java.awt.*;

public class Bomb {
    private int x;
    private int y;
    private Image image1;
    private Image image2;
    private Image image3;
    private int Live = 9;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bomb(int x, int y, Image image1, Image image2, Image image3) {
        this.x = x;
        this.y = y;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
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

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public Image getImage3() {
        return image3;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }

    public int getLive() {
        return Live;
    }

    public void setLive(int live) {
        Live = live;
    }

    public int die() {
        if (Live > 6) {
            Live--;
            return 3;
        } else if (Live > 3) {
            Live--;
            return 2;
        } else if (Live > 0) {
            Live--;
            return 1;
        } else {
            return 0;
        }
    }
}
