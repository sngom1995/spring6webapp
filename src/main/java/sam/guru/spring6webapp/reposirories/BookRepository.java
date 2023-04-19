package sam.guru.spring6webapp.reposirories;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookRepository, Long> {
}
