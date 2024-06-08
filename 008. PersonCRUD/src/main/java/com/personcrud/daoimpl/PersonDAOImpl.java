package com.personcrud.daoimpl;

import java.util.List;
import com.personcrud.dao.PersonDAO;
import com.personcrud.models.Person;
import com.personcrud.utils.SqlUtil;

public class PersonDAOImpl implements PersonDAO{

	@Override
	public int save(Person person) {
		int result = -1;
		try {
			SqlUtil.connectDb();
			String qry = "INSERT INTO t_person VALUES ('"+person.getName_person()+"', '"+person.getName_person()+"' , '"+person.getDob()+"'";
			result = SqlUtil.insert(qry);
			SqlUtil.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Person> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}
