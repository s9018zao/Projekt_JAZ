package jee.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jee.domain.Book;
import jee.domain.Person;

@Stateless
public class BookManager {
	
	
	
		@PersistenceContext
		EntityManager bookM;

		public void addBook(Book book) {
			book.setId(null);
			bookM.persist(book);
		}

		public void deleteBook(Book book) {
			book = bookM.find(Book.class, book.getId());
			bookM.remove(book);
		}

		@SuppressWarnings("unchecked")
		public List<Book> getAllBooks() {
			return bookM.createNamedQuery("book.all").getResultList();
		}
		
		/*

		public List<Book> getOwnedBooks(Person person) {
			person = em.find(Person.class, person.getId());
			// lazy loading here - try this code without this (shallow) copying
			List<Book> books = new ArrayList<Book>(person.getBooks());
			return books;
		}*/

	}



