package com.IO.work;

import java.io.*;
import java.util.Properties;

public class work3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "src/dog.properties";
        Properties properties = new Properties();
//        properties.setProperty("name","tom");
//        properties.setProperty("age","5");
//        properties.setProperty("color","red");
//        properties.store(new FileWriter(file),null);
        properties.load(new FileReader(file));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")),
                properties.getProperty("color"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/dog.dat"));
        Dog dog1 = (Dog)objectInputStream.readObject();
        System.out.println(dog1.toString());

    }
    public<T> void ser(T t){

    }
}
class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}