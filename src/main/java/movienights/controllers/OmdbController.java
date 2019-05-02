package movienights.controllers;

import movienights.constants.OmdbApi;
import movienights.entities.Movie;
import movienights.entities.MovieOmdb;
import movienights.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OmdbController {

    @Autowired
    private MovieRepository movieRepository;


    private AtomicLong counter = new AtomicLong();

    OmdbApi omdb = new OmdbApi();


    @RequestMapping(path = "/searchMovie/{value}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<MovieOmdb>> searchByName(@PathVariable String value){
        counter.incrementAndGet();
        List<MovieOmdb> movies = omdb.searchByName(value);

        if(movies == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(path = "/getById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Movie> getById(@PathVariable String id){
        if(movieRepository.findByImdbId(id) == null){
            MovieOmdb responseMovie = omdb.searchById(id);
            counter.incrementAndGet();
            addMovieToDB(responseMovie);
        }
        Movie movie = movieRepository.findByImdbId(id);
        if(movie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    public AtomicLong getCounter() {
        return counter;
    }

    private void addMovieToDB(MovieOmdb responseMovie){
        movieRepository.save(new Movie(responseMovie.getImdbId(), responseMovie.getTitle(), responseMovie.getPoster(), responseMovie.getRuntime()));
    }
}