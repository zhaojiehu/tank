package com.IO.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;

public class work {
    public static void main(String[] args) {

    }
@Test
    public void Copy() {
        String filename = "d:/draw.jpg";
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String image = "C:\\Users\\hi today\\Pictures\\wpcache\\srvsetwp\\2053061.jpg";
        int read = 0;
        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(image);
            fileOutputStream = new FileOutputStream(filename);
            while ((read = fileInputStream.read(bytes)) != -1) {

                fileOutputStream.write(bytes);
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

