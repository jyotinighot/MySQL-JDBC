package com.demo.crudoperations;


import java.sql.Connection;
import java.sql.DriverManager;

public class UtilityClass 
{
	
	public UtilityClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnectionObject()
	{
		Connection con=null;
		try
		{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","");
		 
		System.out.println("Connection istablished");
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return con;
	}

}