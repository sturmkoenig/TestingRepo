package com.airhacks.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import com.airhacks.entities.User;

@RequestScoped
@Transactional
public class QueryService {

	@PersistenceContext
	EntityManager entityManager;

	@Inject
	private Logger logger;

	public List<User> getUsers() {
		return entityManager.createQuery("SELECT t from User t", User.class).getResultList();
	}

	public User findUserById(Long id) {
		User queriedUser = entityManager.find(User.class, id);
		String msg = String.format("Queried user: %d", id);
		logger.info(msg);
		return queriedUser;
	}

	public User setUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}
}
