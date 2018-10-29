package com.caps.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.caps.dev.beans.Person;

public class App 
{
    public static void main( String[] args )
    {
       System.out.println("Enter Person Details");
       System.out.println("-------------------");
       Person person = new Person();
       Scanner in = new Scanner(System.in);
       
       System.out.println("Enter person id: ");
       person.setPid(Integer.parseInt(in.nextLine()));
       
       System.out.println("Enter person name: ");
       person.setPname(in.nextLine());
       
       System.out.println("Enter person age: ");
       person.setPage(Integer.parseInt(in.nextLine()));
       
       System.out.println("Enter person email: ");
       person.setPemail(in.nextLine());
       
       System.out.println("Enter person address: ");
       person.setPaddress(in.nextLine());

       create(person);
    }
    
    public static void create(Person person) 
    {
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			
			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

			//3rd version of getConnnecton()
			con = DriverManager.getConnection(dbUrl,"root","anurag@12"); //1st version of getConnection

			String sql = "insert into movies_info values(?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getPid());
			pstmt.setString(2,person.getPname());
			pstmt.setInt(3, person.getPage());
			pstmt.setString(4, person.getPemail());
			pstmt.setString(5, person.getPaddress());
			
			int count = pstmt.executeUpdate();
			

			if(count > 0) {
				System.out.println("Data Inserted");
			}else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    }
