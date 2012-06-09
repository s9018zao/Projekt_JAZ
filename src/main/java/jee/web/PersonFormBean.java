package jee.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import jee.domain.Book;
import jee.domain.Person;
import jee.service.PersonManager;
import jee.service.BuyingManager;

@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	private ListDataModel<Person> persons = new ListDataModel<Person>();
	
	private Person personToShow = new Person();
	private ListDataModel<Book> ownedBooks = new ListDataModel<Book>();


	@Inject
	private PersonManager pm;
	
	@Inject
	private BuyingManager bm;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public ListDataModel<Person> getAllPersons() {
		persons.setWrappedData(pm.getAllPersons());
		return persons;
	}

	public ListDataModel<Book> getOwnedBooks() {
		ownedBooks.setWrappedData(pm.getOwnedCars(personToShow));
		return ownedBooks;
	}
	
	// Actions
	public String addPerson() {
		pm.addPerson(person);
		return "showPersons";
		//return null;
	}

	public String deletePerson() {
		Person personToDelete = persons.getRowData();
		pm.deletePerson(personToDelete);
		return null;
	}
	
	public String showDetails() {
		personToShow = persons.getRowData();
		return "details";
	}
	
	public String disposeCar(){
		Book carToDispose = ownedBooks.getRowData();
		bm.disposeBook(personToShow, carToDispose);
		return null;
	}
}

