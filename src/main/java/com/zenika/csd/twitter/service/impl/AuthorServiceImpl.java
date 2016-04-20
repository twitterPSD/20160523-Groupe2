package com.zenika.csd.twitter.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.twitter.model.Author;
import com.zenika.csd.twitter.repository.AuthorRepository;
import com.zenika.csd.twitter.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

	@Inject
	private AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {
		log.debug("Request to get all authors");
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	@Override
	public Author save(Author author) {
		log.debug("Request to save Author : {}", author);
		Author savedAuthor = authorRepository.saveAndFlush(author);
		return savedAuthor;
	}

	@Override
	public void delete(Integer id) {
		log.debug("Request to delete Author id : {}", id);
		authorRepository.delete(id);
	}

}
