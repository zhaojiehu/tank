package com.IO;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Standary {
    public static void main(String[] args) {
        //标准输出/输入;
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
