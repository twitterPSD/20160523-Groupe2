package com.zenika.csd.twitter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.csd.twitter.model.Account;
import com.zenika.csd.twitter.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	private AccountService authorService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Author> findAuthors() {
//		return authorService.findAll();
//	}
//
	@RequestMapping(method = RequestMethod.POST)
	public Account addAccount(@RequestBody Account account) {
		account.setId(null);
		return authorService.save(account);
	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public Author updateAuthor(@RequestBody Author updatedAuthor, @PathVariable Integer id) {
//		updatedAuthor.setId(id);
//		return authorService.save(updatedAuthor);
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void deleteAuthor(@PathVariable Integer id) {
//		authorService.delete(id);
//	}

	
}
