package com.example.spring5demo.bootstrap;

import com.example.spring5demo.models.Author;
import com.example.spring5demo.models.Book;
import com.example.spring5demo.models.Publisher;
import com.example.spring5demo.repositories.AuthorRepository;
import com.example.spring5demo.repositories.BookRepository;
import com.example.spring5demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(
        AuthorRepository authorRepository,
        BookRepository bookRepository,
        PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("Harper Collins", "5454 Beethoven Street");
        Publisher publisher2 = new Publisher("Worx", "5454 Beethoven Street");

        publisherRepository.save(publisher);
        publisherRepository.save(publisher2);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        // Rod
        Author rod = new Author("Rod", "Johnson");

        Book book2 = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
