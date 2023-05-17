package com.IO.FileInputStream;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileinputstream {
    public static void main(String[] args) {
        fileinputstream fileinputstream = new fileinputstream();
        fileinputstream.read1();
        fileinputstream.read2();

    }
    public void read1(){
        String filename = "d:/read.txt";
        int read;
        FileInputStream fileInputStream = null;
        try {
             fileInputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ( (read = fileInputStream.read()) != -1){
                System.out.println((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void read2(){
        String filename = "d:/read.txt";
        int a = 0;
        byte[] bytes = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filename);
            while ((a = fileInputStream.read(bytes) )!= -1){
                System.out.print(new String(bytes,0,a));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
