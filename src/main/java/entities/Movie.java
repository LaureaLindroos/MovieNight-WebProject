package entities;

import com.fasterxml.jackson.annotation.JsonProperty;)
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

    public Movie (){

    }
}
