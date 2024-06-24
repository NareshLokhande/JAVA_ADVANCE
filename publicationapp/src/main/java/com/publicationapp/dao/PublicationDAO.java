package com.publicationapp.dao;

import java.util.List;

import com.publicationapp.model.Publication;

public interface PublicationDAO {
	List<Publication> getAll();
	Publication getById(int id);
	Integer save(Publication publication);
	void update(Publication publication);
	void remove(int id);
}
