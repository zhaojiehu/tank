package com.IO.createflie;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class createFile {
    public static void main(String[] args) {

    }
    @Test
    public void create1(){
        String namePath = "d:/news1.txt";
        File file = new File(namePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建文件成功");
    }
    @Test
    public void create2(){
        String parent = "d:/";
        String filename = "new2.txt";
        File file = new File(parent, filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建成功");
    }
    @Test
    public void create3(){
        String parentPath = "d:/";
        String childPath = "new3.txt";
        File file = new File(parentPath, childPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
