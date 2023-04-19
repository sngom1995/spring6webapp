package sam.guru.spring6webapp.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sam.guru.spring6webapp.domain.Author;
import sam.guru.spring6webapp.domain.Book;
import sam.guru.spring6webapp.domain.Publisher;
import sam.guru.spring6webapp.reposirories.AuthorRepository;
import sam.guru.spring6webapp.reposirories.BookRepository;
import sam.guru.spring6webapp.reposirories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Author samba = new Author();
        samba.setFirstName("Samba");
        samba.setLastName("Ngom");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123123");

        samba.getBooks().add(ddd);
        ddd.getAuthors().add(samba);

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisher.getBooks().add(ddd);
        publisherRepository.save(publisher);
        ddd.setPublisher(publisher);


        publisher.getBooks().add(ddd);

        Author author = authorRepository.save(samba);
        Book book = bookRepository.save(ddd);

        Author bathie = new Author();
        bathie.setFirstName("Bathie");
        bathie.setLastName("Lo");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("123123");
        noEJB.setPublisher(publisher);

        bathie.getBooks().add(noEJB);
        noEJB.getAuthors().add(bathie);

        Author author1 = authorRepository.save(bathie);
        Book book1 = bookRepository.save(noEJB);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);



        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());


    }
}
