package com.IO.createflie;

import com.IO.Objie.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ObjInput {
    public static void main(String[] args) {
        String filePath = "d:/data.dat";
        ObjectInputStream ois = null;
        try {
            try {
                ois = new ObjectInputStream(new FileInputStream(filePath));
                System.out.println(ois.readInt());
                System.out.println(ois.readBoolean());
                System.out.println(ois.readChar());
                System.out.println(ois.readDouble());
                System.out.println(ois.readUTF());
                Object dog = ois.readObject();
                System.out.println(dog.getClass());
                System.out.println(dog);
                Dog dog2 = (Dog)dog;
                dog2.toString();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //反序列化要与序列化保持一致!!!
        /**重要细节:
         * 反序列化的类要保持一致(有同类名,不同包名的情况)
         * 可以引入包明类名;
         */

    }
}
