package com.zenika.csd.twitter.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.twitter.model.Account;
import com.zenika.csd.twitter.repository.AccountRepository;
import com.zenika.csd.twitter.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Inject
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		log.debug("Request to save Account : {}", account);
		Account savedAuthor = accountRepository.saveAndFlush(account);
		return savedAuthor;
	}
}
