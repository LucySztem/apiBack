package pl.coderslab.apiback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.apiback.model.Book;
import pl.coderslab.apiback.model.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	// testu czy controll dziala
//	@GetMapping("/test")
//	public Book test() {
//		//zwroci w przegladarce w formacie JSON
//		return new Book (1L,"9788324631766","Thinking	in	Java",
//				"Bruce	Eckel","Helion","programming");
//	}
	@Autowired
	// wstrzykniecie interfejsu BookService
	BookService bookService;
	
	@GetMapping("")
	public List<Book> getList() {
		
		return this.bookService.getList();
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable long id) {
		return this.bookService.getBookById(id);
	}
	
	// dodawanie nowej ksazki do listy, patrz slajd 31
	@PostMapping("")
	public Book addBook(@RequestBody Book book) {
		
		
		return this.bookService.add(book);
	}
	// usuwanie ksiazki o wskazanym id, patrz slajd 31
		@DeleteMapping("/{id}")
		public String deleteBook(@PathVariable long id) {		
			
			 this.bookService.deleteById(id);
			 
			 return "{result: ok}";
		}
		@PutMapping("/{id}")
		public String putBook(@PathVariable long id, @RequestBody Book book) {		
			//odniesienie sie do ksiazki z DB o takim id
			 this.bookService.edit(book);
			 
			 return "{result: ok}";
		}
}
