package com.productapp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productapp.dao.ProductDAO;
import com.productapp.model.Product;
import com.productapp.util.SqlUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int save(Product product) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "INSERT INTO products (id, name, price) VALUES (" + product.getId() + ", '" + product.getName()
					+ "', " + product.getPrice() + ")";
			result = SqlUtil.insert(qry);
			SqlUtil.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();

		try {
			SqlUtil.connectDb();
			String qry = "SELECT * FROM products";
			ResultSet rs = SqlUtil.fetch(qry);
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					float price = rs.getFloat("price");
					Product product = new Product(id, name, price);
					products.add(product);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Product getById(int id) {
		Product product = null;
		try {
			SqlUtil.connectDb();
			String qry = "SELECT * FROM products where id=" + id;
			ResultSet rs = SqlUtil.fetch(qry);
			if (rs != null) {
				int productId = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				product = new Product(productId, name, price);
			}
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "DELETE FROM products WHERE id=" + id;
			result = SqlUtil.delete(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public int update(int id, Product product) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "UPDATE products SET id='" + product.getId() + "' name='" + product.getName() + "' price='"
					+ product.getPrice() + "' ";
			result = SqlUtil.update(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
