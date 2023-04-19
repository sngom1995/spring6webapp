package sam.guru.spring6webapp.reposirories;

import org.springframework.data.repository.CrudRepository;
import sam.guru.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
