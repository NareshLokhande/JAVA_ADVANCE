package com.example.employeecrud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.employeecrud.daoimpl.EmployeeDAOImpl;
import com.example.employeecrud.model.Employee;

public class App {
	private static Scanner sc = new Scanner(System.in);
	private static EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

	private static void displayMenu() {
		System.out.println("1. Add Employees");
		System.out.println("2. Get All Employees");
		System.out.println("3. Get By ID");
		System.out.println("4. Remove Employee");
		System.out.println("5. Exit");
		System.out.print("\nEnter choice : ");

	}

	private static int getChoice() {
		while (!sc.hasNextInt()) {
			System.out.print("Invalid input. Please enter a number: ");
			sc.next();
		}
	    return sc.nextInt();
	}
	
	private static void addEmployee() {
		Employee employee = new Employee();
		System.out.print("Enter the Name :");
		sc.nextLine();
		employee.setName(sc.nextLine());
		System.out.print("Enter the Phone :");
		employee.setPhone(sc.nextLine());
		System.out.print("Enter the Salary:");
		employee.setSalary(sc.nextFloat());

		int id = employeeDAOImpl.save(employee);
		System.out.println("Inserted id " + id);

	}

	private static void getEmployeeById() {
		System.out.print("Enter id you want to Search : ");
		int id = sc.nextInt();
		Employee employee = employeeDAOImpl.getById(id);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee not found");
		}
	}

	private static void getAllEmployees() {
		List<Employee> employees = employeeDAOImpl.getAll();
		if (employees.size() == 0) {
			System.out.println("No employees Found");
		} else {
			Iterator<Employee> itr = employees.iterator();
			while (itr.hasNext()) {
				Employee employee = (Employee) itr.next();
				System.out.println(employee);
			}
		}
	}
	
	private static void removeEmployee() {
		System.out.print("Enter id to delete: ");
		int id = sc.nextInt();
		int result = employeeDAOImpl.remove(id);
		if (result != -1) {
			System.out.println("Employee removed");
		} else {
			System.out.println("Employee with id " + id + " removed !!");
		}
	}
	
	public static void main(String[] args) {

		char continuationChoice;

		do {
			displayMenu();
			int choice = getChoice();

			switch (choice) {
			case 1:
				addEmployee();
				break;

			case 2:
				getAllEmployees();
				break;

			case 3:
				getEmployeeById();
				break;

			case 4:
				removeEmployee();
				break;

			case 5:
				System.out.println("Exiting application...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice.");
			}
			System.out.print("Do you want to continue? (Y/N): ");
			continuationChoice = sc.next().charAt(0);
			sc.nextLine();
		} while (continuationChoice == 'Y');

	}
	

//	do
//
//	{
//		// System.out.println("1. Add Employee \n2. Get All Employees \n3. Get by ID
//		// \n4. Remove Employee \n5. Exit \n");
//
//		displayMenu();
//		System.out.print("Enter choice : ");
//		int choice = sc.nextInt();
//
//		if (choice == 1) {
//			Employee employee = new Employee();
//			System.out.print("Enter the Name :");
//			sc.nextLine();
//			employee.setName(sc.nextLine());
//			System.out.print("Enter the Phone :");
//			employee.setPhone(sc.nextLine());
//			System.out.print("Enter the Salary:");
//			employee.setSalary(sc.nextFloat());
//
//			int id = employeeDAOImpl.save(employee);
//			System.out.println("Inserted id " + id);
//		} else if (choice == 2) {
//			List<Employee> employees = employeeDAOImpl.getAll();
//			if (employees.size() == 0) {
//				System.out.println("No employees Found");
//			} else {
//				Iterator<Employee> itr = employees.iterator();
//				while (itr.hasNext()) {
//					Employee employee = (Employee) itr.next();
//					System.out.println(employee);
//				}
//			}
//		} else if (choice == 3) {
//			System.out.print("Enter id you want to Search : ");
//			int id = sc.nextInt();
//			Employee employee = employeeDAOImpl.getById(id);
//			if (employee != null) {
//				System.out.println(employee);
//			} else {
//				System.out.println("Employee not found");
//			}
//
//		} else if (choice == 4) {
//			System.out.print("Enter id to delete: ");
//			int id = sc.nextInt();
//			int result = employeeDAOImpl.remove(id);
//			if (result != -1) {
//				System.out.println("Employee removed");
//			} else {
//				System.out.println("Employee with id " + id + " removed !!");
//			}
//		} else {
//			System.out.println("Invalid choice ");
//		}
//
//		System.out.println("Do you want to Continue ? (Y/N)");
//		continuationChoice = sc.next().charAt(0);
//		sc.nextLine();
//	}while(continuationChoice=='Y');
//
//	sc.close();
//}

}
