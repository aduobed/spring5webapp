package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.domain.Publisher;
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

        System.out.println("Started in BootStrap!!!!");

        //Publisher object Creation
        Publisher publisher = new Publisher();
        publisher.setName("Cue Publishing");
        publisher.setCity("Kansas");
        publisher.setState("KS");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count : " + publisherRepository.count());

        //Create Object of author and book and them  to their set initialized in their class respectively
        Author derick = new Author("Derick", "Sam");
        Book book1 = new Book("The last man", "A1203");
        derick.getBooks().add(book1);
        book1.getAuthors().add(derick);

        //Adding the publisher to the book class
        //Adding the book to the publisher class
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        //Add the objects to the repository to save them in JPA
        authorRepository.save(derick);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        //Set Another Object of author and book
        Author ruth = new Author("Ruth", "Sam");
        Book book2 = new Book("The faith of kamal", "B908");
        ruth.getBooks().add(book2);
        book2.getAuthors().add(ruth);

        //Adding the publisher to the second book class
        //Adding the book to the publisher class
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        //Add the objects to the repository to save them in JPA
        authorRepository.save(ruth);
        bookRepository.save(book2);
        publisherRepository.save(publisher);


        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher Number of Books : " + publisher.getBooks().size() );
    }
}
