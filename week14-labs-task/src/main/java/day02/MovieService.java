package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findMovieByActor(String actor) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream().anyMatch(actual -> actual.equals(actor)))
                .toList();
    }

    public int getLongestMovieLength() {
        return movies.stream()
                .max(Comparator.comparingInt(Movie::getLength))
                .orElseThrow(() -> new IllegalStateException("Empty list.")).getLength();
    }
}
