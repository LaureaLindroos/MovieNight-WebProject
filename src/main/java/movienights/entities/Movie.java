package movienights.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer i;
    @JsonProperty("imdbID")
    private String id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Rating")
    private String rating;
    @JsonProperty("Language")
    private String language;

    public Movie(String id, String title, String year, String plot, String genre, String runtime, String rating, String language) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.genre = genre;
        this.runtime = runtime;
        this.rating = rating;
        this.language = language;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
