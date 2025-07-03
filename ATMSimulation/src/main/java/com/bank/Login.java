package com.bank;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener
{
	
	JButton login , clear , signup;
	JTextField cardtext; 
	JPasswordField pintext;
	
	Login()
	{
		setTitle("Automated Teller Machine");        //To set the title of the frame
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/bank_logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70 , 10 , 100 , 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Oswald" , Font.BOLD , 38));
		text.setBounds(200 , 40 , 400 , 40);           //To make label from (left , up , width , height)
		add(text);
		
		JLabel card = new JLabel("Card NO. :");
		card.setFont(new Font("Raleway" , Font.BOLD, 28));
		card.setBounds(120 , 150 , 250 , 40);
		add(card);
		
		cardtext = new JTextField();
		cardtext.setBounds(300 , 150 , 230 , 30);
		cardtext.setFont(new Font("Arial" , Font.BOLD , 14));
		add(cardtext);
		
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Raleway" , Font.BOLD , 28));
		pin.setBounds(120 , 220 , 250 , 30);
		add(pin);
		
		pintext = new JPasswordField();
		pintext.setBounds(300 , 220 , 230 , 30);
		pintext.setFont(new Font("Arial" , Font.BOLD , 14));
		add(pintext);
	                          	
		login = new JButton("LOGIN");
		login.setBounds(300 , 300 , 100 , 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430 , 300 , 100 , 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300 , 350 , 230 , 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800 , 480);                          //To set the size of the frame
		setVisible(true);                            //To make the frame visible
		setLocation(350 , 200);                      //To set the location of the frame(left , top , right , bottom)
	}


	public void actionPerformed(ActionEvent ac)
	{
		if(ac.getSource() == clear)
		{
			cardtext.setText("");
			pintext.setText("");
		}
		else if(ac.getSource() == signup)
		{
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		else if(ac.getSource() == login)
		{
			Connect con = new Connect();
			String cardno = cardtext.getText();
			String pinno = pintext.getText();
			String query = "select * from login where card_number = '"+cardno+"' and pin_number = '"+pinno+"' "; 
			try
			{
				ResultSet rs = con.st.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transactions(pinno).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null ,  "Incorrect Card Number or PIN");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String args[])
	{
		new Login();
	}
}