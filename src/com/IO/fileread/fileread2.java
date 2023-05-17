package com.IO.fileread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileread2 {
    public static void main(String[] args) {
        String filePath = "d:/story.txt";
        FileReader fileReader = null;
        int end = 0;
        char[] chars = new char[10];
        try {
            fileReader = new FileReader(filePath);
            while ((end = fileReader.read()) != -1){
                System.out.print((char) end);
            }
//            while ((end = fileReader.read(chars)) != -1){
//                System.out.print(new String(chars,0,end));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
