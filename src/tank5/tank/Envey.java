package tank5.tank;

import java.io.Serializable;
import java.util.Vector;


public class Envey extends tank implements Runnable, Serializable {
    Vector bull = new Vector<bullet>();//敌人坦克子弹集合;
    private int js = 0;//计数器;
    Vector<Envey> EnvetTank = new Vector();//敌人坦克集合

    public void setEnvetTank(Vector<Envey> envetTank) {
        EnvetTank = envetTank;
    }

    public Envey() {
        super();
    }

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

    //判断敌人坦克是否重叠(重叠false 否true)
    public boolean oveltank() {
        switch (this.getDir()) {
            case 0:
                for (tank envey : EnvetTank) {
                    if (this != envey) {
                        switch (envey.getDir()) {
                            case 0:
                            case 1:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 40
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 60) {
                                    return false;
                                }
                                if (getX() + 40 > envey.getX()
                                        && getX() + 40 < envey.getX() + 40
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 60) {
                                    return false;
                                }
                                break;
                            case 2:
                            case 3:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 60
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 40) {
                                    return false;
                                }
                                if (getX() + 40 > envey.getX()
                                        && getX() + 40 < envey.getX() + 60
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 40) {
                                    return false;
                                }
                                break;
                        }
                    }
                }

            case 1:
                for (tank envey : EnvetTank) {
                    if (this != envey) {
                        switch (envey.getDir()) {
                            case 0:
                            case 1:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 40
                                        && getY() + 60 > envey.getY()
                                        && getY() + 60 < envey.getY() + 60) {
                                    return false;
                                }
                                if (getX() + 40 > envey.getX()
                                        && getX() + 40 < envey.getX() + 40
                                        && getY() + 60 > envey.getY()
                                        && getY() + 60 < envey.getY() + 60) {
                                    return false;
                                }
                                break;
                            case 2:
                            case 3:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 60
                                        && getY() + 60 > envey.getY()
                                        && getY() + 60 < envey.getY() + 40) {
                                    return false;
                                }
                                if (getX() + 40 > envey.getX()
                                        && getX() + 40 < envey.getX() + 60
                                        && getY() + 60 > envey.getY()
                                        && getY() + 60 < envey.getY() + 40) {
                                    return false;
                                }
                                break;
                        }
                    }
                }
            case 2:
                for (tank envey : EnvetTank) {
                    if (this != envey) {
                        switch (envey.getDir()) {
                            case 0:
                            case 1:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 40
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 60) {
                                    return false;
                                }
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 40
                                        && getY() + 40 > envey.getY()
                                        && getY() + 40 < envey.getY() + 60) {
                                    return false;
                                }
                                break;
                            case 2:
                            case 3:
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 60
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 40) {
                                    return false;
                                }
                                if (getX() > envey.getX()
                                        && getX() < envey.getX() + 60
                                        && getY() + 40 > envey.getY()
                                        && getY() +40 < envey.getY() + 40) {
                                    return false;
                                }
                                break;
                        }
                    }
                }
            case 3:
                for (tank envey : EnvetTank) {
                    if (this != envey) {
                        switch (envey.getDir()) {
                            case 0:
                            case 1:
                                if (getX() + 60 > envey.getX()
                                        && getX() + 60 < envey.getX() + 40
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 60) {
                                    return false;
                                }
                                if (getX() + 60 > envey.getX()
                                        && getX() + 60 < envey.getX() + 40
                                        && getY() + 40 > envey.getY()
                                        && getY() + 40 < envey.getY() + 60) {
                                    return false;
                                }
                                break;
                            case 2:
                            case 3:
                                if (getX() + 60 > envey.getX()
                                        && getX() + 60 < envey.getX() + 60
                                        && getY() > envey.getY()
                                        && getY() < envey.getY() + 40) {
                                    return false;
                                }
                                if (getX() + 60 > envey.getX()
                                        && getX() + 60 < envey.getX() + 60
                                        && getY() + 40 > envey.getY()
                                        && getY() + 40 < envey.getY() + 40) {
                                    return false;
                                }
                                break;
                        }
                    }
                }
        }
        return true;
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
                    if (getY() > 0 && oveltank()) {
                        setY(getY() - getSpeed());
                    }
                    break;
                case 1:
                    if (getY() + 60 < 750 && oveltank()) {
                        setY(getY() + getSpeed());
                    }
                    break;
                case 2:
                    if (getX() > 0 && oveltank()) {
                        setX(getX() - getSpeed());
                    }
                    break;
                case 3:
                    if (getX() + 60 < 1000 && oveltank()) {
                        setX(getX() + getSpeed());
                    }
            }
        }
    }
}
