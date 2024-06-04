package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1500,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        t = new Thread(this);
        t.start();
        setLocation(200,250);
        setUndecorated(true);
        setVisible(true);

        int x = 1;
        for (int i=2; i<=600; i+=4, x+=1){
            setLocation(370 - ((i + x)/2), 300 - (i/2));
            setSize(i + 5*x, i + x);

            try {
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public void run(){
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
