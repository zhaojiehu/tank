package com.IO.Objie;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjOutstream {
    public static void main(String[] args) {
        //保存后文件类型由他的格式决定
        String filePath = "d:/data.dat";

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeInt(100);
            oos.writeBoolean(true);
            oos.writeChar('a');
            oos.writeDouble(5.4);
            oos.writeUTF("turtle");
            oos.writeObject(new Dog("jock", 12));
            System.out.println("数据保存完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
//Serializable序列化;
