package com.IO.Buuffer;

import java.io.*;

public class InputStream {
    public static void main(String[] args) {
        String filePath = "d:/draw.jpg";
        String newfilePath = "d:/draw2.txt";
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        int b = 0;
        byte[] bytes = new byte[1024];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newfilePath));
            while ((b = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,b);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                    if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
