package com.zenika.csd.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenika.csd.twitter.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
