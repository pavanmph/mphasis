package com.test.controller;
import com.test.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class BookController {
 
	@GetMapping("/")
	public String homeForm() {
		return "index";
	}
	@GetMapping("/bform")
	public String bookForm() {
		return "bookpage";
	}
	@PostMapping("/submit")
	public String submitBookForm(
			@RequestParam("id") int id,
			@RequestParam("name")String name,
			@RequestParam("author")String author,
			@RequestParam("price")int price,
			Model model,Book book)
	{
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		
		model.addAttribute("data",book);
		
		if(book.getId()>0) {
			return "success";
		}
		else {
			return "bookpage";
		}
	}
	
}
 
 