package com.hgsachin.springWebApp.bootstrap;

import com.hgsachin.springWebApp.domain.Author;
import com.hgsachin.springWebApp.domain.Book;
import com.hgsachin.springWebApp.domain.Publisher;
import com.hgsachin.springWebApp.repositories.AuthorRepository;
import com.hgsachin.springWebApp.repositories.BookRepository;
import com.hgsachin.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author lee = new Author("Lee", "Child");
        Book someBook = new Book("Some Book By Lee Child", "1234");
        lee.getBooks().add(someBook);
        someBook.getAuthors().add(lee);
        authorRepository.save(lee);
        bookRepository.save(someBook);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE without EJB", "12355");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEjb);

        Publisher iit = new Publisher("IIT publisher", "No. 14", "Bangalore", "Karnataka", "56000");

        someBook.setPublisher(iit);
        noEjb.setPublisher(iit);

        iit.getBooks().add(someBook);
        iit.getBooks().add(noEjb);

        publisherRepository.save(iit);

        System.out.println("Started in BootStrap");
        System.out.println("No of books: " + bookRepository.count());
        System.out.println("No of publishers: " + publisherRepository.findAll());
    }
}
