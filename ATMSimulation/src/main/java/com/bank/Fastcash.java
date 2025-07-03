package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener
{
	
	JButton deposit , cash , fast , mini , pin , bank , exit;
	String pinnumber;
	
	
	Fastcash(String pinno)
	{
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0 ,0 , 900 , 720);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(230 , 200 , 700 , 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD , 14));
		image.add(text);
		
	    deposit = new JButton("Rs. 100"); 
		deposit.setBounds(170 , 325 , 150 , 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cash = new JButton("Rs. 200");
		cash.setBounds(355 , 325 , 150 , 30);
		cash.addActionListener(this);
		image.add(cash);
		
		fast = new JButton("Rs. 500");
		fast.setBounds(170 , 360 , 150 , 30);
		fast.addActionListener(this);
		image.add(fast);
		
		mini = new JButton("Rs. 1000");
		mini.setBounds(355 , 360 , 150 , 30);
		mini.addActionListener(this);
		image.add(mini);
		
		pin = new JButton("Rs. 2000");
		pin.setBounds(170 , 395 , 150 , 30);
		pin.addActionListener(this);
		image.add(pin);
		
		bank = new JButton("Rs. 5000");
		bank.setBounds(355 , 395 , 150 , 30);
		bank.addActionListener(this);
		image.add(bank);
		
		exit = new JButton("BACK");
		exit.setBounds(355 , 429 , 150 , 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900 , 900);
		setLocation(300 , 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == exit)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else
		{
			String amt = ((JButton)ae.getSource()).getText().substring(4);
			Connect con = new Connect();
			try
			{
				ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
				int balence = 0;
				while(rs.next())
				{
					if(rs.getString("type").equals("Deposit"))
					{
						balence += Integer.parseInt(rs.getString("amount"));
					}
					else
					{
						balence -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != exit && balence < Integer.parseInt(amt))
				{
					JOptionPane.showMessageDialog(null ,  "Insufficient Balence");
					return;
				}
				
				Date date = new Date();
				String query = "INSERT INTO bank (pin, date, type , amount) VALUES "
						+ "('"+pinnumber+"' , '" + date + "', 'Withdrawl' , '" + amt + "')";
				con.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null , "Rs " + amt + "Withdraw Successfully.");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public static void main(String args[])
	{
		new Fastcash("");
	}
}
