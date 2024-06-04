package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/about.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,0,300,200);
        add(img);

        JLabel heading = new JLabel("<html> Dr. A.P.J. Abdul Kalam </br>Technical University Varanasi, India </html>");
        heading.setBounds(70,20,300,150);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Rishabh Chaubey ");
        name.setBounds(80,260,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD,25));
        add(name);

        JLabel contact = new JLabel("Mail: universitymgmt@gmail.com");
        contact.setBounds(80,340,550,40);
        contact.setFont(new Font("Dialog", Font.BOLD,25));
        add(contact);

        JLabel mobile = new JLabel("Mob:+91 1090808208");
        mobile.setBounds(80,380,550,40);
        mobile.setFont(new Font("Dialog", Font.BOLD,25));
        add(mobile);

        setSize(700,500);
        setLocation(300,120);
        getContentPane().setBackground(new Color(252,228,210));
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new About();
    }
}