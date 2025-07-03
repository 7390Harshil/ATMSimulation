package com.bank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener{
	
	JTextField pan , aadhar , pintext;
	JButton next;
	JRadioButton syes , sno , eyes , eno;
	JComboBox Religion , Category , Income , Edu , Ocu;
	String receivedFormNo;
	
	
	signupTwo(String formno)
	{
		this.receivedFormNo = formno;
		setLayout(null); 
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2  :Additional Details");
		additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
		additionalDetails.setBounds(290 , 80 , 400, 30);
		add(additionalDetails);
		
	
		
		JLabel religion = new JLabel("Religion : ");
		religion.setFont(new Font("Raleway" , Font.BOLD , 20));
		religion.setBounds(100 , 140 , 200 , 30);
		add(religion);
		String varReligion[] = {"Hindu" , "Muslim" , "Sikh" , "Christian" , "Other"};
		Religion = new JComboBox(varReligion);
		Religion.setBackground(Color.WHITE);
		Religion.setFont(new Font("Arial" , Font.BOLD, 14));
		Religion.setBounds(300 , 140 , 400, 30);
		add(Religion);
		
		
		
		JLabel category = new JLabel("Category : ");
		category.setFont(new Font("Raleway" , Font.BOLD , 20));
		category.setBounds(100 , 190 , 200 , 30);
		add(category);
		String varCategory[] = {"General" , "SC" , "ST" , "OBC" , "Other"};
		Category = new JComboBox(varCategory);
		Category.setBackground(Color.WHITE);
		Category.setFont(new Font("Arial" , Font.BOLD , 14));
		Category.setBounds(300 , 190 , 400 , 30);
		add(Category);
		
		
		
		
		JLabel income = new JLabel("Income : ");
		income.setFont(new Font("Raleway" , Font.BOLD , 20));
		income.setBounds(100 , 240 , 200 ,30);
		add(income);
		String varIncome[] = {"Null" , "<1499999" , "1500000 - 2499999" , "2500000 - 4999999" , "5000000 - 10000000" , ">10000000"};
		Income = new JComboBox(varIncome);
		Income.setBackground(Color.WHITE);
		Income.setFont(new Font("Arial" , Font.BOLD , 14));
		Income.setBounds(300 , 240 , 400 ,30);
		add(Income);
		
		
		
		
		JLabel education = new JLabel("Educational");
		education.setFont(new Font("Raleway" , Font.BOLD , 20));
		education.setBounds(100 , 290 , 200 , 30);
		add(education);
		JLabel qualify = new JLabel("Qualification : ");
		qualify.setFont(new Font("Raleway" , Font.BOLD , 20));
		qualify.setBounds(100 , 315 , 200 ,30);
		add(qualify);
		String varEdu[] = {"Non - Graduate" , "Graduate" , "Post - Graduate" , "Doctrate" , "Other"};
		Edu = new JComboBox(varEdu);
		Edu.setBackground(Color.WHITE);
		Edu.setFont(new Font("Arial" , Font.BOLD , 14));
		Edu.setBounds(300 , 315 , 400 , 30);
		add(Edu);
		
		
		
		JLabel occupy = new JLabel("Occupation : ");
		occupy.setFont(new Font("Raleway" , Font.BOLD , 20));
		occupy.setBounds(100 , 390 , 200 , 30);
		add(occupy);
		String varOcu[] = {"Salaried" , "Self - Employed" , "Bussiness" , "Student" , "Retired" , "Other"};
		Ocu = new JComboBox(varOcu);
		Ocu.setBackground(Color.WHITE);
		Ocu.setFont(new Font("Arial" , Font.BOLD , 14));
		Ocu.setBounds(300 , 390 , 400 , 30);
		add(Ocu);
		
		
		
		
		
		JLabel PAN = new JLabel("PAN Number : ");
		PAN.setFont(new Font("Raleway" , Font.BOLD , 20));
		PAN.setBounds(100 , 440 , 200 , 30);
		add(PAN);
		pan = new JTextField("");
		pan.setFont(new Font("Arial" , Font.BOLD , 17));
		pan.setBounds(300 , 440 , 400 , 30);
		add(pan);
		
		
		
		JLabel AAdhar = new JLabel("Aadhar Number : ");
		AAdhar.setFont(new Font("Ralewy" , Font.BOLD , 20));
		AAdhar.setBounds(100 , 490 , 200 , 30);
		add(AAdhar);
		aadhar = new JTextField("");
		aadhar.setFont(new Font("Arial" , Font.BOLD , 17));
		aadhar.setBounds(300 , 490 , 400 , 30);
		add(aadhar);
		
		
		
		
		
		JLabel Senior = new JLabel("Senior Citizen : ");
		Senior.setFont(new Font("Raleway" , Font.BOLD , 20));
		Senior.setBounds(100 , 540 , 200 , 30);
		add(Senior);
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 60, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		sno = new JRadioButton("No");
		sno.setBounds(380, 540, 60, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		ButtonGroup citizenGroup = new ButtonGroup();
		citizenGroup.add(syes);
		citizenGroup.add(sno);

		
		
		
		JLabel pin = new JLabel("Existing Account : ");
		pin.setFont(new Font("Raleway" , Font.BOLD , 20));
		pin.setBounds(100 , 590 , 200 , 30);
		add(pin);
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 60, 30);  
		eyes.setBackground(Color.WHITE);
		add(eyes);
		eno = new JRadioButton("No");
		eno.setBounds(380, 590, 60, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(eyes);
		accountGroup.add(eno);

		
		
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
		String sreligion = (String)Religion.getSelectedItem();
		String scategory  = (String)Category.getSelectedItem();
		String sincome = (String)Income.getSelectedItem();
		String seducation = (String)Edu.getSelectedItem();
		String soccupation = (String)Ocu.getSelectedItem();
		String scitizen = null;
		if(syes.isSelected())
		{
			scitizen = "Yes";
		}
		else
		{
			scitizen = "No";
		}
		
		String sexisting = null;
		if(eyes.isSelected())
		{
			sexisting = "Yes";
		}
		else
		{
			sexisting = "No";
		}
		
		String span = pan.getText();
		
		String saadhar = aadhar.getText();
		
		
		try 
		{
			Connect con = new Connect();
			String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, senior_citizen, existing_account, pan ,  aadhar) VALUES "
			        + "('" + receivedFormNo + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + scitizen + "', '" + sexisting + "', '" + span + "', '" + saadhar + "')";
			con.st.executeUpdate(query);
			
			setVisible(false);
			new signupThree(receivedFormNo).setVisible(true);
		}
		catch(Exception err)
		{     
			System.out.println(err);
		}
	}
	public static void main(String args[])
	{
		new signupTwo("");
	}
}