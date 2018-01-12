package pl.coderslab.apiback.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {
	
	private static long nextId = 1;
	private List<Book> list;

	// initilize new ArrayList in construcotr
	public MemoryBookService() {
		this.list = new ArrayList<>();
		
		//wywolamy metode add
		add(new Book(0, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
		add(new Book(0, "9788324627738", "Rusz	glowa,	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
				"programming"));
		add(new Book(0, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Book getBookById(long id) throws NoSuchElementException {

		Predicate<Book> bookById = c -> c.getId() == id;
		Book book = this.list.stream().filter(bookById).findFirst().get();
		return book;
	}

	public void edit(Book book) throws NoSuchElementException {

		Book b = getBookById(book.getId());
		// jak ksiazka zostanie znaleziona to zastanie przyisana do b, gdzie bedziemy mogli podmienc dane "starej ksiazki"(
		
		b = book;
	}

	public void delete(Book book) throws NoSuchElementException {
		//pierwotne cialo metody
//		Book b = getBookById(book.getId());
//		this.list.remove(b);
		
		// nowe cialo metody, jak wywolamy delete to wykona sie delteById
		deleteById(book.getId());
	}
	public void deleteById(long id) throws NoSuchElementException {
		
		Book b = getBookById(id);
		this.list.remove(b);
	}

	public Book add(Book book) {
		
		book.setId(nextId++);
		this.list.add(book);
		return book;
	}
}
