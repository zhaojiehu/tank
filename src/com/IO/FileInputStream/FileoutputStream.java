package com.IO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStream {
    public static void main(String[] args) {
        FileoutputStream fileoutputStream = new FileoutputStream();
        fileoutputStream.write1();
        fileoutputStream.write2();
    }

    public void write1(){
        String filename = "d:/read.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //加true,是从尾加,不加是覆盖!!!
            fileOutputStream = new FileOutputStream(filename,true);
            fileOutputStream.write('a');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void write2(){
        String filename = "d:/read.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filename,true);
            String str = "holle";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(),0,3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
