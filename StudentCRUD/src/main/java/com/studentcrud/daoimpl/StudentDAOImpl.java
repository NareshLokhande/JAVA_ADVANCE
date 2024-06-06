package com.studentcrud.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.studentcrud.dao.StudentDAO;
import com.studentcrud.models.Student;
import com.studentcrud.utils.SqlUtil;

public class StudentDAOImpl implements StudentDAO {

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
//					Student student = new Student(id, name, city, marks, phone, gender);
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

}
