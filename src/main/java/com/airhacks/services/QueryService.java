package com.airhacks.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.airhacks.entities.User;


//@DataSourceDefinition(
        //name = "java:jboss/datasources/New_mySQL",
        //className = "org.apache.derby.jdbc.ClientDriver",
        //url = "jdbc:mysql://localhost:3306/ifinances",
        //user = "infinite",
        //password = "skills")
@RequestScoped
@Transactional
public class QueryService {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<User> getUsers() {
		return entityManager.createQuery("SELECT t from User t", User.class).getResultList();
	}
	
	public User findUserById(Long id) {
		User queriedUser = entityManager.find(User.class, id);
		System.out.println(queriedUser.getUserId());
		return queriedUser;
	}

	public User setUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}
}
