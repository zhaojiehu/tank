package tank5.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tankgame01 extends JFrame {
    MyPaint mp;

    public static void main(String[] args) {
        new tankgame01();
    }
    public tankgame01() {
        mp = new MyPaint();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300, 1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Record.record();
            }
        });
        new Thread(mp).start();
    }
}
