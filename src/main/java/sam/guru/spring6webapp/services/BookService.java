package sam.guru.spring6webapp.services;

import sam.guru.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> listAllBooks();
}
