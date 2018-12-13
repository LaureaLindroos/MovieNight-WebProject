import entities.Movie;
import entities.MovieList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OMDbAPI {
    private static final Logger log = LoggerFactory.getLogger(OMDbAPI.class);

    RestTemplate restTemplate = new RestTemplate();

    public OMDbAPI (){

    }
    public List<Movie> getMoviesByName(String search){
        MovieList response = restTemplate.getForObject(
                "http://www.omdbapi.com/?s="+search+"&apikey=eefee898",
                MovieList.class);
        List<Movie> movies = response.getMovies();
        movies.forEach(movie -> log.info(movie.toString()));
        return movies;
    }

    //Can only search for year with title
    public Movie getMoviesById(String id){
        Movie movie = restTemplate.getForObject(
                "http://www.omdbapi.com/?i="+id+"&apikey=eefee898",
                Movie.class);
        return movie;
    }
}
