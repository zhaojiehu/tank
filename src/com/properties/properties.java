package com.properties;

import java.io.*;
import java.util.Properties;

public class properties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user","调用函数");
        properties.store(new FileWriter("src\\mysql.properties"),"jsj");

    }
}
