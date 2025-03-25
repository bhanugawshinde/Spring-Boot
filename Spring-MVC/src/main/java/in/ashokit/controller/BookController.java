package in.ashokit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bean.Book;

@Controller
public class BookController {
	
	private List<Book> books = new ArrayList<>();
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", books);
		
		return "books";
	}
	
	@GetMapping("/add-book-form")
	public String addBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book );
		
		return "add-book-form";
	}
	
	@PostMapping("/add-book")
	public String addBook(Book book, Model model) {
		model.addAttribute("msg" ,"Book Added Successfully !!");
		model.addAttribute("book" ,book);
		books.add(book);
		return "add-book-success";
	}
	
}
