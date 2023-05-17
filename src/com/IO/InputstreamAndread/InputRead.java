package com.IO.InputstreamAndread;

import java.io.*;

public class InputRead {
    public static void main(String[] args) throws IOException {
        String filePath = "d:/story.txt";
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(new FileInputStream(filePath),"gbk"));
        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        System.out.println(a);
        System.out.println(b);
        bufferedReader.close();
    }
}
