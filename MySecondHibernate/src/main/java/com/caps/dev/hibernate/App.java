package com.caps.dev.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
       System.out.println("Person Details Saved");
    }
    
    public static void create(Person person) 
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(person);
		tx.commit();
    }
    }
