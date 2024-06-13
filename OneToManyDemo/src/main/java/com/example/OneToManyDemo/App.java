package com.example.OneToManyDemo;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        
        Session session = new Configuration()
        		.configure()
        		.addAnnotatedClass(Employee.class)
        		.addAnnotatedClass(Department.class)
        		.buildSessionFactory().openSession();
        
        session.beginTransaction();
        
//    	// Insert the data in DB
//        
//        Department dept = new Department();
//        dept.setName("Sales");
//        dept.setBlock("A");
//        dept.setHod("Mr.Bhosale");
//        
//        Employee e1 = new Employee();
//        e1.setName("Naresh");
//        e1.setSalary(988354);
//        
//        
//        Employee e2 = new Employee();
//        e1.setName("Suresh");
//        e1.setSalary(980004);
//        
//        e1.setDepartment(dept);
//        e2.setDepartment(dept);
//        
//        dept.getEmployees().add(e1);
//        dept.getEmployees().add(e2);
//        
//        session.save(dept);
//        session.save(e1);
//        session.save(e2);
        
        
//        //Retrieve data
//        
//        Department dept = session.get(Department.class, 1);
//        System.out.println(dept);
//        List<Employee> employees = dept.getEmployees();
//        Iterator<Employee> itr = employees.iterator();
//        while (itr.hasNext()) {
//			Employee emp = itr.next();
//			System.out.println(emp);
//		}
        
        //Backward Compatibility
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        System.out.println(emp.getDepartment());
        
        session.getTransaction().commit();
    }
}
