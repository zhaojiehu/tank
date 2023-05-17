package com.IO.printfStream;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class printf {
    public static void main(String[] args) throws IOException {
        PrintStream stream = System.out;
        stream.print("sjinkls");
        stream.write("fijfmkl".getBytes(StandardCharsets.UTF_8));
        System.setOut(new PrintStream("d:/yy.txt"));
        System.out.println("hfjfsksoi");
        stream.close();
    }
}
