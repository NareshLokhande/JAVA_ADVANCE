package com.example.hibernatedemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        
        cfg.configure().addAnnotatedClass(Product.class).addAnnotatedClass(Employee.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();
        
//        Product p = new Product();
//        p.setId(102);
//        p.setName("Mouse");
//        p.setPrice(550);
//        p.setQty(10);        
//        session.save(p);
        
//        Employee emp = new Employee();
//        emp.setName("Naresh");
//        emp.setPhone("9822316707");
//        emp.setSalary(10000);
//        session.save(emp);
        
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        
        txn.commit();
    }
}
