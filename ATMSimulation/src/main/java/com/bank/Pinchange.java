package com.bank;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener
{
	
	JPasswordField pintext , retext;
	JButton change , back;
	String pino;
	
	
	Pinchange(String pinnumber)
	{
		this.pino = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,  900 , Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0 , 0 , 900 , 720);
		add(image);
		
		JLabel text = new JLabel("Change your PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD , 16));
		text.setBounds(255 , 200 , 700 , 35);
		image.add(text);
		
		
		JLabel pin = new JLabel("Change PIN : ");
		pin.setForeground(Color.WHITE);
		pin.setFont(new Font("System" , Font.BOLD , 16));
		pin.setBounds(200 , 260 , 400 , 35);
		image.add(pin);
		
		pintext = new JPasswordField();
		pintext.setBounds(320 , 265 , 160 , 27);
		image.add(pintext);
		
		
		JLabel re = new JLabel("Re-enter PIN : ");
		re.setForeground(Color.WHITE);
		re.setFont(new Font("System" , Font.BOLD , 16));
		re.setBounds(200 , 300 , 400 , 35);
		image.add(re);
		
		retext = new JPasswordField();
		retext.setBounds(320 , 305 , 160 , 27);
		image.add(retext);
		
		change = new JButton("CHANGE");
		change.setBounds(355 , 395 , 150 , 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355 , 429 , 150 , 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900 , 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == change)
		{
			try
			{
				String npin = pintext.getText();
				String rpin = retext.getText();
				
				if(!npin.equals(rpin))
				{
					JOptionPane.showMessageDialog(null , "Entered PIN does not match");
					return;
				}
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null , "Please enter new PIN");
					return;
				}
				
				if(rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null , "Please Re-enter new PIN");
					return;
				}
				
				Connect con = new Connect();
				String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pino+"'";
				String query2 = "update login set pin_number = '"+rpin+"' where pin_number = '"+pino+"'";
				String query3 = "update signupthree set pin_number = '"+rpin+"' where pin_number = '"+pino+"'";
				
				con.st.executeUpdate(query1);
				con.st.executeUpdate(query2);
				con.st.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null , "PIN Changed Successfully");
				
				setVisible(false);
				new Transactions(rpin).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			setVisible(false);
			new Transactions(pino).setVisible(true);
		}
	}
	
	
	public static void main(String args[])
	{
		new Pinchange("").setVisible(true);
	}
}