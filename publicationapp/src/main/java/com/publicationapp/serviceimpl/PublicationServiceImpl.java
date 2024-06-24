package com.publicationapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicationapp.daoimpl.PublicationDAOImpl;
import com.publicationapp.model.Publication;
import com.publicationapp.service.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService {
	
	@Autowired
	private PublicationDAOImpl publicationDAOImpl;
	
	@Override
	public Integer save(Publication publication) {
		return publicationDAOImpl.save(publication);
	}

	@Override
	public List<Publication> getAll() {
		return publicationDAOImpl.getAll();
	}

	@Override
	public Publication getById(int id) {
		return publicationDAOImpl.getById(id);
	}

	@Override
	public void update(Publication publication) {
		publicationDAOImpl.update(publication);
	}

	@Override
	public void remove(int id) {
		publicationDAOImpl.remove(id);
	}

}
