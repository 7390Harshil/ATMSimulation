package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balence extends JFrame implements ActionListener
{
	JButton back;
	String pinnumber;
	
	Balence(String pinnumber)
	{
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0 , 0 , 900 , 720);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(355 , 429 , 150 , 30);
		back.addActionListener(this);
		image.add(back);
		
		Connect con = new Connect();
		int balence = 0;
		try
		{
			ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current Amount Balance is Rs. " + balence);
		text.setForeground(Color.WHITE);
		text.setBounds(220 , 220 , 400 , 30);
		image.add(text);
		
		setSize(900 , 900);
		setLocation(300 , 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
	
	public static void main(String args[])
	{
		new Balence("");
	}
}