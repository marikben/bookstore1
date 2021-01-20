package com.example.Bookstore1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.model.Book;
import com.example.Bookstore1.model.BookRepository;
import com.example.Bookstore1.model.Category;
import com.example.Bookstore1.model.CategoryRepository;

@SpringBootApplication
public class Bookstore1Application {

	private static final Logger log = LoggerFactory.getLogger(Bookstore1Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository){
		return (args) -> {
			

			log.info("save a couple of books");
			repository.save(new Book("Testikirja", "Marx", 1890, "123-234", 99.90));
			repository.save(new Book("Nykypaivien Saksa", "Sven", 1935, "123-2346", 9.7));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
				
			}

		};
	
	}
	
	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository catrepository){
		return (args) -> {
			

			log.info("save a couple of books");
			catrepository.save(new Category("Tietokirja"));
			catrepository.save(new Category("Elämänkerta"));
			catrepository.save(new Category("Romaani"));
			
			log.info("fetch all categories");
			for (Category category : catrepository.findAll()) {
				log.info(category.toString());
				
			}

		};
}
}

