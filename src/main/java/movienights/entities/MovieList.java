package movienights.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieList {
    @JsonProperty("Search")
    private List<MovieOmdb> movies;

    public MovieList(){

    }

    public List<MovieOmdb> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieOmdb> movies) {
        this.movies = movies;
    }
}
