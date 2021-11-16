package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
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

        //Create Object of author and book and them  to their set initialized in their class respectively
        Author derick = new Author("Derick", "Sam");
        Book book1 = new Book("The last man", "A1203");
        derick.getBooks().add(book1);
        book1.getAuthors().add(derick);

        //Add the objects to the repository to save them in JPA
        authorRepository.save(derick);
        bookRepository.save(book1);

        //Set Another Object of author and book
        Author ruth = new Author("Ruth", "Sam");
        Book book2 = new Book("The faith of kamal", "B908");
        ruth.getBooks().add(book2);
        book2.getAuthors().add(ruth);

        //Add the objects to the repository to save them in JPA
        authorRepository.save(ruth);
        bookRepository.save(book2);

        System.out.println("Started in BootStrap!!!!");
        System.out.println("Number of Books : " + bookRepository.count());
    }
}
