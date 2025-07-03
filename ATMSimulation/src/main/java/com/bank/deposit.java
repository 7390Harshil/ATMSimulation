package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class deposit extends JFrame implements ActionListener
{
	JButton deposit , back;
	JTextField amt;
	String pinno;
	
	deposit(String pinnumber)
	{
		this.pinno = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900 ,  900 ,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0 , 0 , 900 , 720);
		add(image);
		
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setBounds(200 , 200 , 700 , 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD , 14));
		image.add(text);
		
		amt = new JTextField();
		amt.setFont(new Font("Raleway" , Font.BOLD , 22));
		amt.setBounds(180, 250 , 320 , 25);
		image.add(amt);
		
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355 , 395 , 150 , 30);
	    deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355 , 429 , 150 , 30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		setSize(900 , 900);
		setUndecorated(true);
		setLocation(300 , 0);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == deposit)
		{
			String num = amt.getText();
			Date date = new Date();
			if(num.equals(""))
			{
				JOptionPane.showMessageDialog(null , "Please enter the amount you want to submit.");
			}
			else
			{
				try {
					Connect con = new Connect();
					String query = "INSERT INTO bank (pin, date, type , amount) VALUES "
							+ "('"+pinno+"' , '" + date + "', 'Deposit' , '" + num + "')";
					con.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null , "Rs " + num + "Deposited Successfully.");
					setVisible(false);
					new Transactions(pinno).setVisible(true);
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			new Transactions(pinno).setVisible(true);
		}
	}
	public static void main(String args[])
	{
		new deposit("");
	}
}