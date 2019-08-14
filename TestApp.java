package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestApp {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Alien alien=new Alien();
		
		alien.setAname("Scott");
		alien.setColor("Greeen");
		session.save(alien);
		tx.commit();
		session.close();
		session=sf.openSession();
		alien=session.get(Alien.class, 1);
		System.out.println(alien);
		session.close();

	}

}
