package com.IO.createflie;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }
    @Test
    public void Information(){
        File file = new File("d:/news1.txt");
        //文件名字
        System.out.println(file.getName());
        //文件绝对路径
        System.out.println("绝对路径"+ file.getAbsolutePath());
        System.out.println("父类目录"+ file.getParent());
        System.out.println("文件大小"+ file.length());
        System.out.println("文件是否存在"+file.exists());
        System.out.println("是不是一个目录"+file.isDirectory());
        System.out.println("是不是一个文件"+file.isFile());

    }
}
