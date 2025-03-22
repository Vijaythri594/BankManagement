package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton button1,button2,button3;

    Login(){
        super("Bank Management System");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2=ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel image1=new JLabel(ii3);
        image1.setBounds(630,350,100,100);
        add(image1);

        label1=new JLabel("WELCOME");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(300,125,450,40);
        add(label1);

        label2=new JLabel("CARD NO:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField1=new JTextField(15);
        textField1.setBounds(325,190,230,30);
        textField1.setFont(new Font("Arial", Font.BOLD, 28));
        add(textField1);


        label3=new JLabel("PIN NO: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField1=new JPasswordField(15);
        passwordField1.setBounds(325,250, 230, 30);
        passwordField1.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField1);

        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.DARK_GRAY);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.DARK_GRAY);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.DARK_GRAY);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2);
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
        setSize(850,480);
        setUndecorated(true);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1){
                Con c= new Con();
                String cardno=textField1.getText();
                String pin=passwordField1.getText();
                String q="select * from login where card_number = '"+cardno+"' and pin= '"+pin+"'";
                ResultSet resultSet=c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }
            }
            else if(e.getSource()==button2){
                textField1.setText("");
                passwordField1.setText("");
            }
            else if (e.getSource()==button3) {
                new SignUp();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
