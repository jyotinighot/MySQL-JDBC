package com.demo.crudoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperationClass implements CrudOperInterface 
{

	public void insertData(Connection con, Student s[]) 
	{
		PreparedStatement ps=null;
		int len=s.length;
		try {
			 ps=con.prepareStatement("insert into student values(?,?,?)");
			for(int i=0;i<len;i++)
			{
				ps.setInt(1, s[i].getId());
				ps.setString(2, s[i].getName());
				ps.setInt(3, s[i].getMarks());
				ps.executeUpdate();
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			closeConn(ps,con);
		}
		
		
		
	}

	public Student[] retriveData(Connection con) 
	{
		Statement st;
		
		try {
			st = con.createStatement();
		
			String str=("select * from student");
			ResultSet rs=st.executeQuery(str);
			
			
			Student stud[]=new Student[20];
			for(int i=0;rs.next();i++)
			{
				stud[i]=new Student();
				stud[i].setId(rs.getInt(1));
				stud[i].setName(rs.getString(2));
				stud[i].setMarks(rs.getInt(3));
			}
			return stud;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

	public void display(Student[] s) {
		for(Student stud:s)
		{
			System.out.print(stud.getId()+" ");
			System.out.print(stud.getName()+" ");
			System.out.println(stud.getMarks());
		}
		
	}

	public static void closeConn(PreparedStatement s,Connection c)
	{
		try {
			s.close();
			c.close();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
}