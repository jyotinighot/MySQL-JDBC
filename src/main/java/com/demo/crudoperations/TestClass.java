package com.demo.crudoperations;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) 
	{
		UtilityClass u = null;//=new UtilityClass();
		System.out.println("Enter how many student you want to insert:");
		Scanner sc=new Scanner(System.in);
		int c=1,total=sc.nextInt();
		Student stud[]=new Student[total];
		for(int i=0;i<total;i++)
		{
			System.out.println("Enter Record:"+ c +":");
			stud[i]=new Student();
			stud[i].setId(sc.nextInt());
			stud[i].setName(sc.next());
			stud[i].setMarks(sc.nextInt());
			c++;
		}
	
		TestClass test=new TestClass();
		OperationClass operation=new OperationClass();
		operation.insertData(UtilityClass.getConnectionObject(),stud);
		//oper.retriveData(u.getConnectionObject());
		operation.display(operation.retriveData(UtilityClass.getConnectionObject()));

	}

}

