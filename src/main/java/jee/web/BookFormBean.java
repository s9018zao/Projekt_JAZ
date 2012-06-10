package jee.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import jee.domain.Book;
import jee.domain.Person;
import jee.service.PersonManager;
import jee.service.BookManager;
import jee.service.BuyingManager;

@SessionScoped
@Named("bookBean")
public class BookFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Book book = new Book();
	private ListDataModel<Book> books = new ListDataModel<Book>();
	
	private Book bookToShow = new Book();
	private ListDataModel<Book> ownedBooks = new ListDataModel<Book>();


	@Inject
	private PersonManager pm;
	
	@Inject
	private BookManager bookM;
	
	/*@Inject
	private BuyingManager bm;*/

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	/*public ListDataModel<Person> getAllPersons() {
		persons.setWrappedData(pm.getAllPersons());
		return persons;
	}*/

	/*public ListDataModel<Book> getOwnedBooks() {
		ownedBooks.setWrappedData(pm.getOwnedBooks(personToShow));
		return ownedBooks;
	}*/
	
	// Actions
	public String addBook() {
		bookM.addBook(book);
		//return "showBooks";
		return null;
	}

	public String deleteBook() {
		Book bookToDelete = books.getRowData();
		bookM.deleteBook(bookToDelete);
		return null;
	}
	
	/*public String showDetails() {
		personToShow = persons.getRowData();
		return "details";
	}*/
	
	/*public String disposeBook(){
		Book bookToDispose = ownedBooks.getRowData();
		bm.disposeBook(personToShow, bookToDispose);
		return null;
	}*/
}