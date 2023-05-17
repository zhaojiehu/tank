package com.IO.InputstreamAndread;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Outputwrite {
    public static void main(String[] args) throws IOException {
        String filePath = "d:/tt.txt";
        OutputStreamWriter gbk = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
        gbk.write("hi,中介费回复");
        gbk.close();
        System.out.println("成功");

    }
    @Test
    public void transformation() {
        String filePath = "d:/draw2.txt";
        String file = "d:/picture.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int rea = 0;
            while ((rea = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, rea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
