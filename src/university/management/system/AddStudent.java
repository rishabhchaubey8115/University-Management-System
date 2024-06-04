package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField textName,textFather,textAddress,textPhone,textEmail,textM10,textM12,textAadhar;
    JLabel rollText;
    Random ran = new Random();
    JDateChooser cdob;
    JComboBox courseBox,departmentBox;
    JButton submit, cancel;
    Long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddStudent(){
        getContentPane().setBackground(new Color(128,176,255));


        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif" , Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif" , Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif" , Font.BOLD,20));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600,150,150,30);
        add(textFather);

        JLabel rollno = new JLabel("Roll Number");
        rollno.setBounds(50,200,200,30);
        rollno.setFont(new Font("serif" , Font.BOLD,20));
        add(rollno);

        rollText = new JLabel("1505" + f4);
        rollText.setBounds(200,200,150,30);
        rollText.setFont(new Font("serif" , Font.BOLD,20));
        add(rollText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif" , Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

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

        textM10 = new JTextField();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif" , Font.BOLD,20));
        add(M12);

        textM12 = new JTextField();
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

        String course[] = {"B.Tech","BBA","BCA","BSC","MSC","MCA","MCom","MA","BA","BCom"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        JLabel Department = new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif" , Font.BOLD,20));
        add(Department);

        String department[] = {"Computer Science","Electronics","Mechanical","Civil","IT"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

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
        if (e.getSource() == submit){
            String name = textName.getText();
            String fname = textFather.getText();
            String rollno = rollText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAadhar.getText();
            String course = (String) courseBox.getSelectedItem();
            String branch = (String) departmentBox.getSelectedItem();
            try {
                if (textName.getText().equals("") || textFather.getText().equals("") || rollText.getText().equals("") ||textAddress.getText().equals("") || textPhone.getText().equals("") || textEmail.getText().equals("") || textM10.getText().equals("") || textM12.getText().equals("") || textAadhar.getText().equals("") || courseBox.getSelectedItem().equals("") || departmentBox.getSelectedItem().equals("") || dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the Fields");
                }else {
                    String q = "insert into student values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";
                    Conn c = new Conn();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Details Inserted");
                    setVisible(false);
                }

            }catch(Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();

    }
}
