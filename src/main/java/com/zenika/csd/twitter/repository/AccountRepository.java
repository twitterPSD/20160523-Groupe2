package com.zenika.csd.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenika.csd.twitter.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
