package sam.guru.spring6webapp.reposirories;


import org.springframework.data.repository.CrudRepository;
import sam.guru.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>
{

}
