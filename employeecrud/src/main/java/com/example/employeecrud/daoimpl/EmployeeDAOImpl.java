package com.example.employeecrud.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.example.employeecrud.dao.EmployeeDAO;
import com.example.employeecrud.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private SessionFactory sf;
	private Session s;
	private Configuration config;
	Transaction txn = null;

	public EmployeeDAOImpl() {
		config = new Configuration();
		config.configure().addAnnotatedClass(Employee.class);
		sf = config.buildSessionFactory();
	}

	@Override
	public Integer save(Employee employee) {
		s = sf.openSession();
		Integer id = null;

		try {
			txn = s.beginTransaction();
			id = (Integer) s.save(employee);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return id;
	}

	@Override
	public List<Employee> getAll() {
		s = sf.openSession();
		List<Employee> emplist = new ArrayList<Employee>();

		try {
			txn = s.beginTransaction();
			emplist = s.createQuery("FROM Employee").list();
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return emplist;
	}

	@Override
	public Employee getById(int id) {
		s = sf.openSession();
		Employee emp = null;
		
		try {
			txn = s.beginTransaction();
			emp = s.get(Employee.class, id);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return emp;
	}

	@Override
	public int remove(int id) {
		s =  sf.openSession();
		int result = -1;
		try {
			txn = s.beginTransaction();
			Employee emp = s.get(Employee.class, id);
			
			if (emp != null) {
				s.delete(emp);
				txn.commit();
				result = 1;
			}
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return result;
	}

	@Override
	public int update(int id, String name, String phone, float salary) {
		
		s = sf.openSession();
		int result = -1;
		try {
			txn = s.beginTransaction();
			Employee emp = s.get(Employee.class, id);
			
			if (emp != null) {
				emp.setName(name);
				emp.setPhone(phone);
				emp.setSalary(salary);
				
				s.update(emp);
				txn.commit();
				result = 1;
	
			}
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return result;
	}
}
