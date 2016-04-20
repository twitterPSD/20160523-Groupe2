package com.zenika.csd.twitter.service;

import java.util.List;

import com.zenika.csd.twitter.model.Author;

public interface AuthorService {

	List<Author> findAll();

	Author save(Author author);

	void delete(Integer id);
	
}
