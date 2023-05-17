package tank5.tank;

import java.io.Serializable;

/**
 * 子弹的线程类:
 */
@SuppressWarnings({"all"})
public class bullet implements Runnable, Serializable {
    private int x;//子弹x坐标
    private int y;//子弹y坐标
    private final int direction;//子弹方向
    private static int speed = 5;//子弹速度
    private boolean loopLive = true;//控制子弹的消亡

    public bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static void setSpeed(int speed) {
        bullet.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLoopLive() {
        return loopLive;
    }

    public void setLoopLive(boolean loopLive) {
        this.loopLive = loopLive;
    }

    @Override
    public void run() {
        //子弹移动
        while (loopLive) {
            //线程结束条件
            if (!(x > 0 && x < 1000 && y > 0 && y < 750)) {
                loopLive = false;
            }
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
            }
            //线程休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        System.out.println("退出线程");
    }
}
