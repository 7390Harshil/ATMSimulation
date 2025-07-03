package com.bank;

import java.sql.*;

public class Connect {
    Connection con;
    Statement st;

    public Connect()
    {
    	try {
    		con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" , "root" , "Radhey@30");
    		st = con.createStatement();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
}
