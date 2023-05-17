package com.IO.Buuffer;

import java.io.*;

public class readAndwrite {
    public static void main(String[] args) {
        readAndwrite readAndwrite = new readAndwrite();
        readAndwrite.read();
        readAndwrite.write();

    }
    public void read(){
        String filePath = "d:/story.txt";
        String file = "";
        BufferedReader bufferedReader = null;
        try {
             bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((file = bufferedReader.readLine())!=null){
                System.out.println(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public void write(){
        String filePath = "d:/story.txt";
        BufferedWriter bufferedWriter = null;
        String Path = "";
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("holle,world");
            bufferedWriter.newLine();
            bufferedWriter.write("我i妇女咖啡机十分恼怒");
            System.out.println();
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
}
