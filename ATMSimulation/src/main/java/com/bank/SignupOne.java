package com.bank;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nametext , ffield , etext , addtext , citytext , statetext , pintext;
	JButton next;
	JRadioButton male , female , maried , unmaried , other;
	JDateChooser date;
	
	SignupOne()
	{
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		JLabel formno = new JLabel("Application form No. " + random);
		formno.setFont(new Font("Raleway" , Font.BOLD , 38));
		formno.setBounds(140 , 20 , 600, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1 : Personal Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
		personalDetails.setBounds(290 , 80 , 400, 30);
		add(personalDetails);
		
	
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Raleway" , Font.BOLD , 20));
		name.setBounds(100 , 140 , 200 , 30);
		add(name);
		nametext = new JTextField("");
		nametext.setFont(new Font("Arial" , Font.BOLD, 17));
		nametext.setBounds(300 , 140 , 400, 30);
		add(nametext);
		
		
		
		
		JLabel fname = new JLabel("Father's Name : ");
		fname.setFont(new Font("Raleway" , Font.BOLD , 20));
		fname.setBounds(100 , 190 , 200 , 30);
		add(fname);
		ffield = new JTextField("");
		ffield.setFont(new Font("Arial" , Font.BOLD , 17));
		ffield.setBounds(300 , 190 , 400 , 30);
		add(ffield);
		
		
		
		
		JLabel DOB = new JLabel("Date of Birth : ");
		DOB.setFont(new Font("Raleway" , Font.BOLD , 20));
		DOB.setBounds(100 , 240 , 200 ,30);
		add(DOB);
		date= new JDateChooser();
		date.setFont(new Font("Arial" , Font.BOLD , 17));
		date.setBounds(300 , 240 , 400 ,30);
		add(date);
		
		
		
		
		JLabel email = new JLabel("E-mail : ");
		email.setFont(new Font("Raleway" , Font.BOLD , 20));
		email.setBounds(100 , 290 , 200 , 30);
		add(email);
		etext = new JTextField("");
		etext.setFont(new Font("Arial" , Font.BOLD , 17));
		etext.setBounds(300 , 290 , 400 , 30);
		add(etext);
		
		
		
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Raleway" , Font.BOLD , 20));
		gender.setBounds(100 , 340 , 200 ,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Arial" , Font.BOLD , 17));
		male.setBackground(Color.WHITE);
		male.setBounds(300 , 340 , 60 , 30);
		add(male);
		female = new JRadioButton("Female");
		female.setFont(new Font("Arial" , Font.BOLD , 17));
		female.setBackground(Color.WHITE);
		female.setBounds(450 , 340 , 80, 30);
		add(female);
		ButtonGroup button = new ButtonGroup();
		button.add(male);
		button.add(female);
		
		
		
		JLabel mari = new JLabel("Marital Status : ");
		mari.setFont(new Font("Raleway" , Font.BOLD , 20));
		mari.setBounds(100 , 390 , 200 , 30);
		add(mari);
		
		maried = new JRadioButton("Maried");
		maried.setFont(new Font("Arial" , Font.BOLD , 17));
		maried.setBackground(Color.WHITE);
		maried.setBounds(300 , 390 , 100 , 30);
		add(maried);
		unmaried = new JRadioButton("Unmaried");
		unmaried.setFont(new Font("Arial" , Font.BOLD , 17));
		unmaried.setBackground(Color.WHITE);
		unmaried.setBounds(450 , 390 , 100 , 30);
		add(unmaried);
		other = new JRadioButton("Other");
		other.setFont(new Font("Arial" , Font.BOLD , 17));
		other.setBackground(Color.WHITE);
		other.setBounds(630 , 390 , 100 , 30);
		add(other);
		ButtonGroup button1 = new ButtonGroup();
		button1.add(maried);
		button1.add(unmaried);
		button1.add(other);
		
		
		
		
		
		JLabel address = new JLabel("Address : ");
		address.setFont(new Font("Raleway" , Font.BOLD , 20));
		address.setBounds(100 , 440 , 200 , 30);
		add(address);
		addtext = new JTextField("");
		addtext.setFont(new Font("Arial" , Font.BOLD , 17));
		addtext.setBounds(300 , 440 , 400 , 30);
		add(addtext);
		
		
		
		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Ralewy" , Font.BOLD , 20));
		city.setBounds(100 , 490 , 200 , 30);
		add(city);
		citytext = new JTextField("");
		citytext.setFont(new Font("Arial" , Font.BOLD , 17));
		citytext.setBounds(300 , 490 , 400 , 30);
		add(citytext);
		
		
		
		
		
		JLabel state = new JLabel("State : ");
		state.setFont(new Font("Raleway" , Font.BOLD , 20));
		state.setBounds(100 , 540 , 200 , 30);
		add(state);
		statetext = new JTextField("");
		statetext.setFont(new Font("Arial" , Font.BOLD , 17));
		statetext.setBounds(300 , 540 , 400 , 30);
		add(statetext);
		
		
		
		
		JLabel pin = new JLabel("Pincode : ");
		pin.setFont(new Font("Raleway" , Font.BOLD , 20));
		pin.setBounds(100 , 590 , 200 , 30);
		add(pin);
		pintext = new JTextField("");
		pintext.setFont(new Font("Arial" , Font.BOLD , 17));
		pintext.setBounds(300 , 590 , 400 , 30);
		add(pintext);
		
		
		JButton next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway" , Font.BOLD , 14));
		next.setBounds(620 , 640 , 80 , 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850 , 800);
		setLocation(350 , 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno = "" + random;                                        // long
		String name = nametext.getText();
		String fname  = ffield.getText();
		String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected())
		{
			gender = "male";
		}
		else
		{
			gender = "female";
		}
		
		String Email = etext.getText();
		
		String marital = null;
		if(maried.isSelected())
		{
			marital = "Maried";
		}
		else if(unmaried.isSelected())
		{
			marital = "Unmaried";
		}
		else
		{
			marital = "Other";
		}
		
		String address = addtext.getText();
		
		String city = citytext.getText();
		
		String state = statetext.getText();
		
		String pin = pintext.getText();
		
		
		try {
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null , "Nmae is Required");
			}
			else
			{
				Connect con = new Connect();
				String query = "INSERT INTO signup (formno, name, father_name, DOB, gender, email, marital, address, city, state, pincode) VALUES "
				        + "('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + Email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
				con.st.executeUpdate(query);
				
				setVisible(false);
				new signupTwo(formno).setVisible(true);
			}
		}
		catch(Exception err)
		{     
			System.out.println(err);
		}
	}
	public static void main(String args[])
	{
		new SignupOne();
	}
}