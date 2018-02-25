package com.demo.crudoperations;
import java.sql.Connection;
import java.sql.SQLException;

public interface CrudOperInterface {

	 public void insertData(Connection con,Student s[]);
	 public Student[] retriveData(Connection con) throws SQLException;
	 public void display(Student[] s);
	
}
