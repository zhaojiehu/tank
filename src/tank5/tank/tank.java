package tank5.tank;

import java.io.Serializable;

public class tank implements Serializable {
    private int x;
    private int y;
    private int dir;
    private int speed = 3;
    private boolean tankLive = true;

    public boolean isTankLive() {
        return tankLive;
    }

    public void setTankLive(boolean tankLive) {
        this.tankLive = tankLive;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public tank() {
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

    public void drawUP() {
        if (y > 0) {
            y = y - speed;
        }
    }
    public void drawDown() {
        if (y + 60 < 750)
            y = y + speed;
    }

    public void drawLift() {
        if (x > 0)
            x = x - speed;
    }

    public void drawRight() {
        if (x + 60< 1000)
            x = x + speed;
    }

}
