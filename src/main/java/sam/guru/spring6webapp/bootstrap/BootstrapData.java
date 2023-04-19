package sam.guru.spring6webapp.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sam.guru.spring6webapp.domain.Author;
import sam.guru.spring6webapp.domain.Book;
import sam.guru.spring6webapp.reposirories.AuthorRepository;
import sam.guru.spring6webapp.reposirories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        Author author = authorRepository.save(samba);
        Book book = bookRepository.save(ddd);

        Author bathie = new Author();
        bathie.setFirstName("Bathie");
        bathie.setLastName("Lo");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("123123");

        Author author1 = authorRepository.save(bathie);
        Book book1 = bookRepository.save(noEJB);

        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());



    }
}
