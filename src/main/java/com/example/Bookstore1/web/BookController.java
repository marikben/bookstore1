package com.example.Bookstore1.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore1.model.Book;
import com.example.Bookstore1.model.BookRepository;
import com.example.Bookstore1.model.CategoryRepository;



@Controller
public class BookController {
    
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrepository;
	
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories",catrepository.findAll());
        return "addbook";
    }  
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
    	
        repository.save(book);
        return "redirect:booklist";
    }  
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }    
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyBook(@PathVariable("id") Long bookId, Model model) {
    	Optional<Book> book = repository.findById(bookId);
    	model.addAttribute("categories",catrepository.findAll());
    	model.addAttribute("book", book);
        return "modifybook";
    }   
}
