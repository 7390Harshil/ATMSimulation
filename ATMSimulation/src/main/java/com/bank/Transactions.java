package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
	
	JButton deposit , cash , fast , mini , pin , bank , exit;
	String pinnumber;
	
	
	Transactions(String pinno)
	{
		this.pinnumber = pinno;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0 ,0 , 900 , 720);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(230 , 200 , 700 , 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD , 14));
		image.add(text);
		
	    deposit = new JButton("Deposit"); 
		deposit.setBounds(170 , 325 , 150 , 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cash = new JButton("Cash Withdrawl");
		cash.setBounds(355 , 325 , 150 , 30);
		cash.addActionListener(this);
		image.add(cash);
		
		fast = new JButton("Fast Cash");
		fast.setBounds(170 , 360 , 150 , 30);
		fast.addActionListener(this);
		image.add(fast);
		
		mini = new JButton("Mini Statement");
		mini.setBounds(355 , 360 , 150 , 30);
		mini.addActionListener(this);
		image.add(mini);
		
		pin = new JButton("Pin Change");
		pin.setBounds(170 , 395 , 150 , 30);
		pin.addActionListener(this);
		image.add(pin);
		
		bank = new JButton("Bank Inquiry");
		bank.setBounds(355 , 395 , 150 , 30);
		bank.addActionListener(this);
		image.add(bank);
		
		exit = new JButton("Exit");
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
			System.exit(0);
		}
		else if(ae.getSource() == deposit)
		{
			setVisible(false);
			new deposit(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == cash)
		{
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == fast)
		{
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == pin)
		{
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == bank)
		{
			setVisible(false);
			new Balence(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == mini)
		{
			new mini(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String args[])
	{
		new Transactions("");
	}
}
