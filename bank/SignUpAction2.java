package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpAction2  extends JFrame implements ActionListener{
    long random;
    String formno;
    JTextField pan, adhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    SignUpAction2(String formNo) {
        this.formno = formNo;
        setLayout(null);

        setTitle("New Application form - Page 2");

        JLabel additonalDetails = new JLabel(" Page 2: Additional Details ");
        additonalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additonalDetails.setBounds(290,80,400,30);
        add(additonalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"Hindu" , "Muslim" , "Sikh", "Christan", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);



        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);


        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCatagory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000","upto 10,00,000"};
        income = new JComboBox(incomeCatagory);
        income.setBounds(300,240,400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualifiacation: ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String educationalValues[] = {"Non - graduate", "Graduated", "Post - Graduation","Doctorate","Other"};
        education = new JComboBox(educationalValues);
        education.setBounds(300,315,400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationalValues[] = {"Salaried", "Self - Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationalValues);
        occupation.setBounds(300,390,400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN No.: ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("Aadhaar No.: ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300,490,400,30);
        add(adhar);

        JLabel state = new JLabel("Seniour citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(syes);
        martialGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emartialGroup = new ButtonGroup();
        emartialGroup.add(eyes);
        emartialGroup.add(eno);

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
        String sreligion = (String) religion.getSelectedItem(); //It will fetch the item from dropdown menu
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniourCitizen = null;
        if(syes.isSelected()) {
            seniourCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniourCitizen = "No";
        }

        String existingAccount = null;
        if(eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        String span = pan.getText();
        String saadhar = adhar.getText();

        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values ('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniourCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpAction3(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpAction2("");
    }
}
