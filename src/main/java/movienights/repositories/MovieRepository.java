package movienights.repositories;

import movienights.entities.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Movie findByTitleContaining(String title);

    Movie findById (int id);

    Movie findByImdbId(String id);
}
