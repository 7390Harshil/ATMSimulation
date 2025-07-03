package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class mini extends JFrame
{
	mini(String pinnumber)
	{
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel minis = new JLabel();
		add(minis);
		
		JLabel bank =new JLabel("MY BANK");
		bank.setBounds(150 , 20 , 100 , 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20 , 80 , 300 , 20);
		add(card);
		
		JLabel balence = new JLabel();
		balence.setBounds(20 , 400 , 300 , 20);
		add(balence);
		
		try
		{
			Connect con = new Connect();
			ResultSet rs = con.st.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
			while(rs.next())
			{
				card.setText("Card Number : " + rs.getString("card_number").substring(0,4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Connect con = new Connect();
			int bal = 0;
			ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			while(rs.next())
		    {
		        String type = rs.getString("type");
		        int amt = Integer.parseInt(rs.getString("amount"));
		        String date = rs.getString("date");

		        sb.append(date)
		          .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
		          .append(type)
		          .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
		          .append(amt)
		          .append("<br><br>");

		        if(type.equals("Deposit")) {
		            bal += amt;
		        } else {
		            bal -= amt;
		        }
		    }
			sb.append("</html>");
			minis.setText(sb.toString());
			
			balence.setText("Your current account balance is Rs. " + bal);
			

			minis.setBounds(20 , 140 , 400 , 200);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		setSize(400 , 600);
		setLocation(20 , 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new mini("");
	}
}