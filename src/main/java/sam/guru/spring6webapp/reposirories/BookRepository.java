package sam.guru.spring6webapp.reposirories;

import org.springframework.data.repository.CrudRepository;
import sam.guru.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
