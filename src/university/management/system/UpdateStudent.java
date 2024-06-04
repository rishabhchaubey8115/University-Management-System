package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField textAddress,textPhone,textEmail,textAadhar,textcourse,textbranch;
    JLabel empText;
    JButton update, cancel;
    Choice RollNo;
    UpdateStudent(){
        getContentPane().setBackground(new Color(230,210,252));


        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif" , Font.BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select Roll Number");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif",Font.PLAIN,20));
        add(empID);

        RollNo = new Choice();
        RollNo.setBounds(250,100,200,20);
        add(RollNo);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()) {
                RollNo.add(rs.getString("rollno"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif" , Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif" , Font.BOLD,20));
        add(fname);

        JLabel textFather = new JLabel();
        textFather.setBounds(600,150,150,30);
        add(textFather);

        JLabel RollNO = new JLabel("Roll Number");
        RollNO.setBounds(50,200,200,30);
        RollNO.setFont(new Font("serif" , Font.BOLD,20));
        add(RollNO);

        empText = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif" , Font.BOLD,20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif" , Font.BOLD,20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600,200,150,30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif" , Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif" , Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif" , Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200,300,150,30);
        add(textEmail);

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif" , Font.BOLD,20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif" , Font.BOLD,20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel AadharNo = new JLabel("Aadhar Number");
        AadharNo.setBounds(400,350,200,30);
        AadharNo.setFont(new Font("serif" , Font.BOLD,20));
        add(AadharNo);

        textAadhar = new JTextField();
        textAadhar.setBounds(600,350,150,30);
        add(textAadhar);

        JLabel Qualifiacation = new JLabel("Course");
        Qualifiacation.setBounds(50,400,200,30);
        Qualifiacation.setFont(new Font("serif" , Font.BOLD,20));
        add(Qualifiacation);

        textcourse = new JTextField();
        textcourse.setBounds(200,400,150,30);
        add(textcourse);


        JLabel Department = new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif" , Font.BOLD,20));
        add(Department);

        textbranch = new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);

        try{
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+RollNo.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textAadhar.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("rollno"));
                textcourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));

            }
        }catch (Exception E){
            E.printStackTrace();
        }

        RollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '"+RollNo.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_x"));
                        textM12.setText(resultSet.getString("class_xii"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        empText.setText(resultSet.getString("rollno"));
                        textcourse.setText(resultSet.getString("course"));
                        textbranch.setText(resultSet.getString("branch"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        update = new JButton("Update");
        update.setBounds(250,550,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(250,40);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){
            String Rollno = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();
            String aadhar = textAadhar.getText();

            try{
                String Q = "update student set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', course = '"+course+"', branch = '"+branch+"', aadhar = '"+aadhar+"' where rollno = '"+Rollno+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {

    }
}
