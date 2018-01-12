package pl.coderslab.apiback.model;

import java.util.List;
import java.util.NoSuchElementException;

public interface BookService {
//stworzony przez kliknieci eprawym na MemoryBookServ... ->refactory -> extract interface, zaznaczone wszytskie pola
	List<Book> getList();

	void setList(List<Book> list);

	Book getBookById(long id) throws NoSuchElementException;

	void edit(Book book) throws NoSuchElementException;

	void delete(Book book) throws NoSuchElementException;

	void deleteById(long id) throws NoSuchElementException;

	Book add(Book book);

}