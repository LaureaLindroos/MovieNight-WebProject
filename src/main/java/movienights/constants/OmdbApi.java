package movienights.constants;

import movienights.controllers.OmdbController;
import movienights.entities.MovieList;
import movienights.entities.MovieOmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OmdbApi {

    private static final String API_REQUEST = "http://www.omdbapi.com/?apikey=bd1f8ab4";
    private static final Logger log = LoggerFactory.getLogger(OmdbController.class);
    private RestTemplate restTemplate = new RestTemplate();

    public List<MovieOmdb> searchByName(String value){
        MovieList response  = restTemplate.getForObject(API_REQUEST+"&s="+ value + "*", MovieList.class);
        List<MovieOmdb> movies;
        try {
            movies = response.getMovies();
        }
        catch (Exception e){
            movies = null;
        }
        return movies;
    }

    public MovieOmdb searchById(String id){
        MovieOmdb responseMovie = restTemplate.getForObject(API_REQUEST+"&i="+id, MovieOmdb.class);

        return responseMovie;
    }
}
