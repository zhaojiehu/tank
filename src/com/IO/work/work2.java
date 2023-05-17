package com.IO.work;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class work2 {
    public static void main(String[] args) throws IOException {
        String file = "d:/hosts.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = null;
        int i = 0;
        while ((s = bufferedReader.readLine()) != null){
            System.out.println(++i + s);
        }
        bufferedReader.close();
    }
}
