package com.example.hqldemo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Employee.class);
        Session session = cfg.buildSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        
        String hql = "SELECT E.name, E.phone FROM Employee E";
        List results = session.createQuery(hql).list();
        Iterator itr = results.iterator();
        while (itr.hasNext()) {
			Object rs[] = (Object[])itr.next();
			System.out.println(rs[0] + " "+rs[1]);	
		}
        
//      int id=1;
//      String hql="SELECT E.name, E.phone FROM Employee E WHERE E.id= :emp_id";
//      Query query = session.createQuery(hql);
//      query.setParameter("emp_id", id);
//      List results =query.list();
//      Iterator itr = results.iterator();
//      while(itr.hasNext()) {
//      	Object rs[] = (Object[])itr.next();
//      	System.out.println(rs[0]+" "+rs[1]) ;
//      }
        
//        Criteria cr= session.createCriteria(Employee.class);
//        cr.add(Restrictions.gt("salary", 9000f));
//        List results =cr.list();
//        Iterator itr = results.iterator();
//      while(itr.hasNext()) {
//      	
//      	System.out.println(itr.next()) ;
//      }
        
        txn.commit();
    }
}
