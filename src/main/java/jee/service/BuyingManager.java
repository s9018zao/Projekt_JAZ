package jee.service;

	
	import java.util.List;

	import javax.ejb.Stateless;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import jee.domain.Book;
	import jee.domain.Person;


	/* 
	 * This is a Stateless EJB Bean
	 * All its methods are transactional
	 */
	@Stateless
	public class BuyingManager {

		@PersistenceContext
		EntityManager em;

		public void BuyBook(Long personId, Long bookId) {

			Person person = em.find(Person.class, personId);
			Book book = em.find(Book.class, bookId);
			book.setBought(true);

			person.getBooks().add(book);
		}

		@SuppressWarnings("unchecked")
		public List<Book> getAvailableBooks() {
			return em.createNamedQuery("book.unsold").getResultList();
		}

		public void disposeBook(Person person, Book book) {

			person = em.find(Person.class, person.getId());
			book = em.find(Book.class, book.getId());

			Book toRemove = null;
			// lazy loading here (person.getCars)
			for (Book aBook : person.getBooks())
				if (aBook.getId().compareTo(book.getId()) == 0) {
					toRemove = aBook;
					break;
				}

			if (toRemove != null)
				person.getBooks().remove(toRemove);
			
			book.setBought(false);
		}
	}



