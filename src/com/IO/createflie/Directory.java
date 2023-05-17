package com.IO.createflie;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory {
    public static void main(String[] args) {

    }
    @Test
    public void deleteFile(){
        File file = new File("d:/news1.txt");
        if(file.exists()){
            file.delete();
        }else{
            System.out.println("文件不存在");
        }
    }
    public void deletePath(){
        File file = new File("d:/news1");
        if(file.exists()){
            file.delete();
        }else{
            System.out.println("文件不存在");
        }
    }
    @Test
    public void directoryPath(){
        String dir = "d:/c/t";
        File file = new File(dir);
        if(file.exists()){
            System.out.println("文件存在");
        }else{
            file.mkdirs();//一级目录用mkdir();
        }
    }
}
