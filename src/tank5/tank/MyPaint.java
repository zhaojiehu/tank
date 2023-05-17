package tank5.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Vector;

/**
 * 画板
 * 因为当子弹线程运行时,paint方法也要重绘,所以可以把MyPaint也做成线程类:
 */
//@SuppressWarnings({"all"})
public class MyPaint extends JPanel implements KeyListener, Runnable {
    Hero hero;//我方坦克.
    //getDir 0 = up,1 = down, 2 = lift, 3 = right.
    Vector<Envey> EnvetTank = new Vector();//敌人坦克集合
    int EnveySize = 3;//敌人坦克数量
    Vector<Bomb> Bombs = new Vector();//坦克爆炸集合
    //炸弹图片
    Image image1 = Toolkit.getDefaultToolkit().getImage(Panel
            .class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_3.jpg"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(Panel
            .class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_13.jpg"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(Panel
            .class.getResource("/110926qlzkhsx3fbxkv2sm_wps图片_16.jpg"));
    //信息恢复:文件名:
    private String filePath = "d:/myTank.dat";
    private ObjectInputStream objInput = null;
    //检验游戏是否开始:
    private boolean going = false;
    //检验游戏是新游戏还是上一局游戏:0新,1旧:
    private int old = -1;

    public MyPaint() {}

    //再次初始化坦克
    public void newTank(){
        hero = new Hero(600, 200);
        tankmusic tankmusic = new tankmusic();
        new Thread(tankmusic).start();
        if(old == 1){
            try {
                objInput = new ObjectInputStream(new FileInputStream(filePath));
                int obj = objInput.readInt();//中间变量
                //恢复旧坦克;
                for (int i = 0;i < 3 - obj; i++){
                    try {
//                        int j = 0;
//                        String[] s = objInput.readUTF().split(" ");
//                        Envey envey = new Envey(Integer.parseInt(s[j++]),
//                                Integer.parseInt(s[j++]));
//                        envey.setDir(Integer.parseInt(s[j++]));

 //* 要有默认构造函数!!!!
 //* 否则会反序列化失败

                        Object o = objInput.readObject();
                        Envey envey = (Envey)o;

                        for (Object o1 :envey.bull) {
                            bullet bullet = (tank5.tank.bullet) o1;
                            new Thread(bullet).start();
                        }

                        EnvetTank.add(envey);
                        envey.setEnvetTank(EnvetTank);
                        Record.setEnvetTank(EnvetTank);
                        new Thread(envey).start();//启动敌人坦克线程;
                    } catch (Exception e) {
                        e.printStackTrace();
                        old = 0;
                    }
                }
                //建立新坦克
/**                for (int i = 0; i < obj; i++) {
//                    Envey envey = new Envey(100 * (i + 1), 0);
//                    EnvetTank.add(envey);
//                    envey.setEnvetTank(EnvetTank);
//                    Record.setEnvetTank(EnvetTank);
//                    new Thread(envey).start();//启动敌人坦克线程;
               }*/
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
            going = true;
        }
        if(old == 0){
            for (int i = 0; i < EnveySize; i++) {
                Envey envey = new Envey(100 * (i + 1), 0);
                EnvetTank.add(envey);
                envey.setEnvetTank(EnvetTank);
                Record.setEnvetTank(EnvetTank);
                new Thread(envey).start();}//启动敌人坦克线程;
            going = true;
        }
    }

    //描绘是否继续上局游戏:
    public void LastGame(Graphics g){
        g.setFont(new Font("宋体",Font.BOLD,50));
        g.drawString("继续上局游戏/新游戏",280,350);
        g.drawString("Y/N",380,410);
    }

    //描绘战绩面板:
    public void record(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(1000,0,300,750);
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("我方共击毁敌方坦克:",1010,30);
        paintTank(1010,70,0,0,g);
        g.setColor(Color.RED);
        g.drawString(Record.wreck+"",1070,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        record(g);
        if(going == false){
        LastGame(g);}
        if(going) {
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
                                Record.addWreck();
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
                                Record.addWreck();
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
                            g.drawImage(image1, bomb.getX(), bomb.getY(),
                                    60, 60, this);
                            break;
                        case 2:
                            g.drawImage(image2, bomb.getX(), bomb.getY(),
                                    60, 60, this);
                            break;
                        case 1:
                            g.drawImage(image3, bomb.getX(), bomb.getY(),
                                    60, 60, this);
                            break;
                        case 0:
                            Bombs.remove(i);
                    }
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
            case KeyEvent.VK_Y:
                old = 1;
                this.newTank();
                break;
            case KeyEvent.VK_N:
                old = 0;
                this.newTank();
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
            if (Thread.interrupted()) {
                save();
            }
        }
        //存盘

    }

    //结束游戏,记录信息;
    public void save() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("d:/tank.txt", true));
            bufferedWriter.write("杀敌数:" + (3 - EnvetTank.size()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //判断坦克是否重叠(我方坦克坐标不变,敌方坦克方向改变)
    public boolean overlapping(tank Tank) {
        int dir = Tank.getDir();
        if (Tank instanceof Hero) {
            for (Object o : EnvetTank) {
                Envey envey = (Envey) o;
                switch (envey.getDir()) {
                    case 0:
                    case 1:
                        if (dir == 0) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 40 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        if (dir == 1) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 40 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        if (dir == 2) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 40 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        if (dir == 3) {
                            if (Tank.getX() + 60 > envey.getX() && Tank.getX() + 60 < envey.getX()
                                    + 40 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        break;
                    case 2:
                    case 3:
                        if (dir == 0 || dir == 2) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 60 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        if (dir == 1) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 60 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        if (dir == 3) {
                            if (Tank.getX() + 60 > envey.getX() && Tank.getX() + 60 < envey.getX()
                                    + 60 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        break;
                }
            }

        }
        if (Tank instanceof Envey) {
            for (int i = 0; i < EnvetTank.size(); i++) {
                Envey envey = EnvetTank.get(i);
                if (Tank == envey) {
                    continue;
                }
                switch (envey.getDir()) {
                    case 0:
                    case 1:
                        if (dir == 0 || dir == 2) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 40 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        if (dir == 1) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 40 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        if (dir == 3) {
                            if (Tank.getX() + 60 > envey.getX() && Tank.getX() + 60 < envey.getX()
                                    + 40 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 60) {
                                return false;
                            }
                        }
                        break;
                    case 2:
                    case 3:
                        if (dir == 0 || dir == 2) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 60 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        if (dir == 1) {
                            if (Tank.getX() > envey.getX() && Tank.getX() < envey.getX()
                                    + 60 && Tank.getY() + 60 > envey.getY() && Tank.getY() + 60 <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        if (dir == 3) {
                            if (Tank.getX() + 60 > envey.getX() && Tank.getX() + 60 < envey.getX()
                                    + 60 && Tank.getY() > envey.getY() && Tank.getY() <
                                    envey.getY() + 40) {
                                return false;
                            }
                        }
                        break;
                }
            }
            switch (hero.getDir()) {
                case 0:
                case 1:
                    if (dir == 0 || dir == 2) {
                        if (Tank.getX() > hero.getX() && Tank.getX() < hero.getX()
                                + 40 && Tank.getY() > hero.getY() && Tank.getY() <
                                hero.getY() + 60) {
                            return false;
                        }
                    }
                    if (dir == 1) {
                        if (Tank.getX() > hero.getX() && Tank.getX() < hero.getX()
                                + 40 && Tank.getY() + 60 > hero.getY() &&
                                Tank.getY() + 60 < hero.getY() + 60) {
                            return false;
                        }
                    }
                    if (dir == 3) {
                        if (Tank.getX() + 60 > hero.getX() && Tank.getX() + 60 <
                                hero.getX() + 40 && Tank.getY() >
                                hero.getY() && Tank.getY() < hero.getY() + 60) {
                            return false;
                        }
                    }
                    break;
                case 2:
                case 3:
                    if (dir == 0 || dir == 2) {
                        if (Tank.getX() > hero.getX() && Tank.getX() < hero.getX()
                                + 60 && Tank.getY() > hero.getY() && Tank.getY() <
                                hero.getY() + 40) {
                            return false;
                        }
                    }
                    if (dir == 1) {
                        if (Tank.getX() >= hero.getX() && Tank.getX() <= hero.getX()
                                + 60 && Tank.getY() + 60 >= hero.getY() &&
                                Tank.getY() + 60 <= hero.getY() + 40) {
                            return false;
                        }
                    }
                    if (dir == 3) {
                        if (Tank.getX() + 60 > hero.getX() && Tank.getX() + 60
                                < hero.getX() + 60 && Tank.getY() > hero.getY()
                                && Tank.getY() < hero.getY() + 40) {
                            return false;
                        }
                    }
            }
        }
        return true;
    }
}
