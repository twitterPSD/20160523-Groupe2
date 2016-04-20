package com.zenika.csd.twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.csd.twitter.model.Author;
import com.zenika.csd.twitter.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Author> findAuthors() {
		return authorService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Author addAuthor(@RequestBody Author author) {
		author.setId(null);
		return authorService.save(author);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Author updateAuthor(@RequestBody Author updatedAuthor, @PathVariable Integer id) {
		updatedAuthor.setId(id);
		return authorService.save(updatedAuthor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable Integer id) {
		authorService.delete(id);
	}

	
}
