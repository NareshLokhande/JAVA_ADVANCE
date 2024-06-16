package com.example.OneToOneDemo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	// Insert the data in DB
    	
//        Person p = new Person();
//        p.setName("Pradeep");
//        p.setPhone("98254472");
//        
//        Address adrs = new Address();
//        adrs.setHouseNo("B/420");
//        adrs.setCity("Mumbai");
//        adrs.setArea("Bandra");
//        
//        //Backward Compatibility
//        p.setAddress(adrs);
//        adrs.setPerson(p);
        
        Session session = new Configuration()
        		.configure()
        		.addAnnotatedClass(Person.class)
        		.addAnnotatedClass(Address.class)
        		.buildSessionFactory().openSession();
        
        Transaction txn = session.beginTransaction();
//      session.save(p);
//      session.save(adrs);
        
        
        // Retrieve Data
        
//        Person p = session.get(Person.class, 1);
//        System.out.println(p);
//        System.out.println(p.getAddress());
        
        //Used backward compatibility here to fetch person from address
        
        Address adrs =session.get(Address.class, 1);
        System.out.println(adrs);
        System.out.println(adrs.getPerson());
        
        txn.commit();
    }
}
