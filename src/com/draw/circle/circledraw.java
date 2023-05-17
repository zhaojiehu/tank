package com.draw.circle;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;

public class circledraw extends JFrame {
    //定义面板:
    private MyPaint mp = null;
    public static void main(String[] args) {

        new circledraw();
    }
    public circledraw(){
        mp = new MyPaint();
        this.add(mp);
        this.setSize(1080,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
//创建界面:
class MyPaint extends JPanel{
//绘图方法:

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint 方法被调用");
        /*
        g.drawOval(10,10,100,100);
        //画直线
        g.drawLine(0,0,50,50);
        //画矩形:
        g.drawRect(0,0,50,50);
        //设置颜色
        g.setColor(Color.CYAN);
        //填充:
        g.fillRect(0,0,50,50);
        g.fillOval(3,3,50,90);

*/
        //填图片:
        Image image = Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("/028.jpg"));
        g.drawImage(image,10,10,600,843,this);
        //设置字体:
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("北京你好",100,100);




    }
}
