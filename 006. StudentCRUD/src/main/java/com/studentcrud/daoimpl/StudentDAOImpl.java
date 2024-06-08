package com.studentcrud.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.studentcrud.dao.StudentDAO;
import com.studentcrud.models.Student;
import com.studentcrud.utils.SqlUtil;

public class StudentDAOImpl implements StudentDAO {
	final static String DB_USER = "root";
	final static String DB_PASSWORD = "cdac";
	final static String DB_NAME = "school";
	final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static Statement stmt;
	static Connection conn;

	@Override
	public int save(Student student) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "INSERT INTO student VALUES ('" + student.getId() + "' , '" + student.getName() + "' , '"
					+ student.getPhone() + "','" + student.getMarks() + "','" + student.getCity() + "','"
					+ student.getGender() + "')";
			result = SqlUtil.insert(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		try {
			SqlUtil.connectDb();
			String qry = "SELECT  * from student";
			ResultSet rs = SqlUtil.fetch(qry);
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String city = rs.getString("city");
					String gender = rs.getString("gender");
					float marks = rs.getFloat("marks");
					Student student = new Student(id, name, phone, gender, marks, city);
					students.add(student);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = null;
		try {
			SqlUtil.connectDb();
			String qry = "select * from student where id=" + id;
			ResultSet rs = SqlUtil.fetch(qry);
			if (rs != null) {
				if (rs.next()) {
					student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setId(rs.getInt("city"));
					student.setMarks(rs.getFloat("marks"));
					student.setPhone(rs.getString("phone"));
					student.setGender(rs.getString("gender"));
				}
			}

			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return student;
	}

	@Override
	public int remove(int id) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "Delete from student where id=" + id;
			result = SqlUtil.delete(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public int update(int id, Student student) {
		int result=-1;
		try {
			SqlUtil.connectDb();
			String qry = "UPDATE student SET name='"+student.getName()+"' city '"+student.getCity()+"' marks='"+student.getMarks()+"' phone='"+student.getPhone()+"' gender='"+student.getGender()+"' WHERE id='"+student.getId()+"'";
			
			result = SqlUtil.update(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
//	 @Override
//	    public int update(int id, Student student) {
//	        int result = -1;
//	        String qry = "UPDATE student SET name = ?, city = ?, marks = ?, phone = ?, gender = ? WHERE id = ?";
//
//	        try (
//	        		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//	        		PreparedStatement pstmt = conn.prepareStatement(qry)) {
//
//	            pstmt.setString(1, student.getName());
//	            pstmt.setString(2, student.getCity());
//	            pstmt.setFloat(3, student.getMarks());
//	            pstmt.setString(4, student.getPhone());
//	            pstmt.setString(5, student.getGender());
//	            pstmt.setInt(6, id);
//
//	            result = pstmt.executeUpdate();
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	        return result;
//	    }

}
