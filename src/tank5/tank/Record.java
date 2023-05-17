package tank5.tank;

import java.io.*;
import java.util.Vector;

/**
 * 存档类;退出游戏时调用
 */

public class Record {
    public static int wreck = 0;//击毁坦克数
    private static String filePath = "d:/myTank.dat";//存档文件名
    private static ObjectOutputStream fileWriter;
    static Vector<Envey>  EnvetTank = new Vector();//敌人坦克集合

    //得到mypaint的坦克集合
    public static void setEnvetTank(Vector<Envey> envetTank) {
        EnvetTank = envetTank;
    }

    public static int getWreck() {
        return wreck;
    }

    public static void setWreck(int wreck) {
        Record.wreck = wreck;
    }

    public static void addWreck(){
        wreck++;
    }

    //信息存储方法
    public static void record(){
        try {
            fileWriter = new ObjectOutputStream(new FileOutputStream(filePath));
            fileWriter.writeInt(wreck);
            for (Envey envey :EnvetTank) {
                //fileWriter.writeUTF(envey.getX()+" "+envey.getY()+" "+envey.getDir());
//                tank tank = (tank)envey;
                fileWriter.writeObject(envey);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                System.out.println("信息存储成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
