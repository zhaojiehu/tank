package com.IO.work;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class work1 {
    public static void main(String[] args) throws IOException {
        String file = "d:/mytemp";
        File file1 = new File(file);
        if(file1.exists()){
            System.out.println("该文件夹存在");
        }else {
            file1.mkdir();
        }

    }
    @Test
    public void create() throws IOException {
        String file = "hello.txt";
        String Path = "d:/mytemp";
        File file1 = new File(Path, file);
        if(file1.exists()){
            System.out.println("该文件已存在");
        }else{
            file1.createNewFile();
        }
    }
    @Test
    public void createfile() throws IOException {
        String file = "hello.txt";
        String Path = "d:/mytemp/hello.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Path));
        bufferedWriter.write("holle,world");
        bufferedWriter.close();
    }
}
