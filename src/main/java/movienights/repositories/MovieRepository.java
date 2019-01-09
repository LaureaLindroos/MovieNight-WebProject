package movienights.repositories;

import movienights.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Page<Movie> findAllByCategory(String category, org.springframework.data.domain.Pageable pageable);

    Movie findById (int id);
}
