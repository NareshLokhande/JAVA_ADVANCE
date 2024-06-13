package com.example.hqldemo2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String qry = "SELECT E.name,E.phone from Employee E";
		List ArrayObjects = session.createQuery(qry).list();
		Iterator itr = ArrayObjects.iterator();
		while (itr.hasNext()) {
			Object[] arr = (Object[]) itr.next();
			System.out.println(arr[0] + " " + arr[1]);
		}
	}
}
