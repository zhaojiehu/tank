package com.IO.fileread;

import java.io.FileWriter;
import java.io.IOException;

public class Fileread {
    public static void main(String[] args) {
        String filePath = "d:/note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','i'};
        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.write(chars,0,chars.length);
            fileWriter.write("jfjfj");
            fileWriter.write("jfhj",0,2);
            fileWriter.write(354);
            fileWriter.write('a');
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
