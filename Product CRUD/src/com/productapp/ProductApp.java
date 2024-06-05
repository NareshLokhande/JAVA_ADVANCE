package com.productapp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.productapp.daoimpl.ProductDAOImpl;
import com.productapp.model.Product;

public class ProductApp {

	public static void main(String[] args) {
//		Product p = new Product(6, "IPS Pannel", 7865);
//		
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		int result = ProductDAOImpl.
		
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		List<Product> productList = ProductDAOImpl.getAll();
//		Iterator<Product> productIterator = productList.iterator();
//		while(productIterator.hasNext()) {
//			Product product = productIterator.next();
//			System.out.println(product);
//		}
		
		Scanner scanner = new Scanner(System.in);
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		boolean exit = false;
		
		while (!exit) {
            System.out.println("\nProduct Management Application");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Get Product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    float price = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    Product newProduct = new Product(id, name, price);
                    int result = productDAOImpl.save(newProduct);
                    if (result > 0) {
                        System.out.println("Product added successfully.");
                    } else {
                        System.out.println("Error adding product.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new product price: ");
                    float newPrice = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    Product updatedProduct = new Product(updateId, newName, newPrice);
                    int updateResult = productDAOImpl.update(updateId, updatedProduct);
                    if (updateResult > 0) {
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Error updating product.");
                    }
                    break;
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    int deleteResult = productDAOImpl.remove(deleteId);
                    if (deleteResult > 0) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Error deleting product.");
                    }
                    break;
                case 4:
                    List<Product> productList = productDAOImpl.getAll();
                    if (productList != null && !productList.isEmpty()) {
                        Iterator<Product> productIterator = productList.iterator();
                        while (productIterator.hasNext()) {
                            Product product = productIterator.next();
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter product ID to fetch: ");
                    int fetchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product product = productDAOImpl.getById(fetchId);
                    if (product != null) {
                        System.out.println(product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
		
		
	}
}
