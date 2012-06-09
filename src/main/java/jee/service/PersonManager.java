package jee.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jee.domain.Book;
import jee.domain.Person;

@Stateless
public class PersonManager {
	
	
	
		@PersistenceContext
		EntityManager em;

		public void addPerson(Person person) {
			person.setId(null);
			em.persist(person);
		}

		public void deletePerson(Person person) {
			person = em.find(Person.class, person.getId());
			em.remove(person);
		}

		@SuppressWarnings("unchecked")
		public List<Person> getAllPersons() {
			return em.createNamedQuery("person.all").getResultList();
		}

		public List<Book> getOwnedBooks(Person person) {
			person = em.find(Person.class, person.getId());
			// lazy loading here - try this code without this (shallow) copying
			List<Book> books = new ArrayList<Book>(person.getBooks());
			return books;
		}

	}



