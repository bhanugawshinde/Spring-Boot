package in.ashokit.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.bean.Book;

@Controller
public class BookController {
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		
		Book b1 = new Book(1, "java", 100.01);
		Book b2 = new Book(2, "python", 200.02);
		Book b3 = new Book(3, "spring", 300.03);
		
		model.addAttribute("books", Arrays.asList(b1,b2,b3));
		
		return "books";
	}
}
