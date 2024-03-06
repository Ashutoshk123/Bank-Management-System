package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,20);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw) {
            String withdrawAmount = amount.getText();
            Date date = new Date();

            if(withdrawAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    int withdrawAmountInt = Integer.parseInt(withdrawAmount);
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()) {
                        if(rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (withdrawAmountInt <= balance) {
                        String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+withdrawAmountInt+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs "+withdrawAmountInt+" withdrawn successfully");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
