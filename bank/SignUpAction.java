package bank;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpAction  extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, mailTextField, adTextField, ctTextField, stTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    SignUpAction() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO. "+random);
        formNo.setFont(new Font("Raleway", Font.BOLD,38));
        formNo.setBounds(140,20,600,40); //only works when setLayout() should be null
        add(formNo);

        JLabel personDetails = new JLabel(" Page 1: Personal Details ");
        personDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        JLabel email = new JLabel("Email Id: ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        ButtonGroup genGroup = new ButtonGroup();
        genGroup.add(male);
        genGroup.add(female);

        mailTextField = new JTextField();
        mailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mailTextField.setBounds(300,340,400,30);
        add(mailTextField);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup mlGroup = new ButtonGroup();
        mlGroup.add(married);
        mlGroup.add(unmarried);
        mlGroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        adTextField = new JTextField();
        adTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adTextField.setBounds(300,440,400,30);
        add(adTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        ctTextField = new JTextField();
        ctTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        ctTextField.setBounds(300,490,400,30);
        add(ctTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stTextField = new JTextField();
        stTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stTextField.setBounds(300,540,400,30);
        add(stTextField);

        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formNo = " " + random; //it will change the random form number to string
        String name = nameTextField.getText(); //fetch the entered text
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //here uicomponent will fetch the data from the date chooser
        String gender = null;
        if(male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }

        String mail = mailTextField.getText();
        String marital = null;
        if(married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = adTextField.getText();
        String city = ctTextField.getText();
        String state = stTextField.getText();
        String pincode = pinTextField.getText();

        try{
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+mail+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpAction2(formNo).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpAction();
    }
}
