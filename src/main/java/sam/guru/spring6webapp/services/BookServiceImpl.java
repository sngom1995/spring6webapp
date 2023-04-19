package sam.guru.spring6webapp.services;

import org.springframework.stereotype.Service;
import sam.guru.spring6webapp.domain.Book;
import sam.guru.spring6webapp.reposirories.BookRepository;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}
