package com.example.ManyToManyDemo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Session session = new Configuration()
        		.configure()
        		.addAnnotatedClass(Actor.class)
        		.addAnnotatedClass(Role.class)
        		.buildSessionFactory()
        		.openSession();
        
        session.beginTransaction();
        
        //Insert Data
        Actor a1 = new Actor();
        a1.setName("Prabhas");
        a1.setPhone("5468713");

        Actor a2 = new Actor();
        a2.setName("Shahrukh Khan");
        a2.setPhone("45213547");
        
        Role r1 = new Role();
        r1.setName("Police");
        r1.setDescription("Good Police.");
        
        Role r2 = new Role();
        r2.setName("Villain");
        r2.setDescription("Village villain.");
        
        Role r3 = new Role();
        r3.setName("Judge");
        r3.setDescription("District high court judge.");
        
        //a1 -> r1, r2
        //a2 -> r1, r2, r3
        
        a1.getRoles().add(r1);
        a1.getRoles().add(r2);
        
        a2.getRoles().add(r1);
        a2.getRoles().add(r2);
        a2.getRoles().add(r3);
        
        //Backward Compatibility
        r1.getActors().add(a1);
        r1.getActors().add(a2);
        
        r2.getActors().add(a1);
        r2.getActors().add(a2);
        
        r3.getActors().add(a2);
        
        session.save(a1);
        session.save(a2);
        session.save(r1);
        session.save(r2);
        session.save(r3);
        
        
        session.getTransaction().commit();   
    }
}
