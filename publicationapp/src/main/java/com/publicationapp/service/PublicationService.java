package com.publicationapp.service;

import java.util.List;

import com.publicationapp.model.Publication;

public interface PublicationService {
	Integer save(Publication publication);
	List<Publication> getAll();
	Publication getById(int id);
	void update(Publication publication);
	void remove(int id);
}
