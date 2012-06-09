package jee.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jee.domain.Book;
import jee.domain.Person;
import jee.service.PersonManager;
import jee.service.BuyingManager;

@SessionScoped
@Named("saleBean")
public class BuyFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BuyingManager bm;

	@Inject
	private PersonManager pm;

	private Long bookId;
	private Long personId;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public List<Book> getAvailableBooks() {
		return bm.getAvailableBooks();
	}

	public List<Person> getAllPersons() {
		return pm.getAllPersons();
	}

	public String sellCar() {
		bm.BuyBook(personId, bookId);
		return null;
	}
}

