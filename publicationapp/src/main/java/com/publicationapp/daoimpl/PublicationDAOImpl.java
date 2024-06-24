package com.publicationapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.publicationapp.dao.PublicationDAO;
import com.publicationapp.model.Publication;


@Repository
public class PublicationDAOImpl implements PublicationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(Publication publication) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		int result = (Integer)session.save(publication);
		txn.commit();
		return result;
	}
	
	@Override
	public List<Publication> getAll() {
		Session session = sessionFactory.openSession();
		List<Publication> publications = session.createQuery("FROM Publication").list();
		return publications;
	}

	@Override
	public Publication getById(int id) {
		Session session = sessionFactory.openSession();
		return session.get(Publication.class, id);
	}

	@Override
	public void remove(int id) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Publication publication = session.get(Publication.class, id);
		session.delete(publication);
		txn.commit();
	}

	@Override
	public void update(Publication publication) {
	    Session session = sessionFactory.openSession();
	    Transaction txn = session.beginTransaction();
	    session.update(publication);
	    txn.commit();
	    session.close();
		
	}
	
}
