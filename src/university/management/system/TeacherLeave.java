package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choiceRollNo, chotime;
    JDateChooser selDate;
    JButton submit, cancel;
    TeacherLeave(){
        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);

        JLabel EmpID = new JLabel("Search by Employee ID");
        EmpID.setBounds(60,100,250,20);
        EmpID.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(EmpID);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()){
                choiceRollNo.add(resultSet.getString("empID"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lbldate);

        selDate = new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(time);

        chotime = new Choice();
        chotime.setBounds(60,290,200,20);
        chotime.add("Full Day");
        chotime.add("Half Day");
        add(chotime);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500,550);
        setLocation(400,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String empID = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = chotime.getSelectedItem();

            String q = "insert into teacherleave values('"+empID+"','"+date+"', '"+time+"')";
            try{
                if (date.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the Fields");
                }else {
                    Conn c = new Conn();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Leave Confirmed");
                    setVisible(false);
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
