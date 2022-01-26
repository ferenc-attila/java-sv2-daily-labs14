package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService = new MovieService();
    List<Movie> moviesOfDiCaprio = new ArrayList<>();

    @BeforeEach
    void init() {

        Movie movie1 = new Movie("Titanic", 120, new ArrayList<>(Arrays.asList("Leonardo DiCaprio", "Tom Cruise", "Juhász Jácint")));
        Movie movie2 = new Movie("Gyűrűk Ura", 180, new ArrayList<>(Arrays.asList("Orlando Bloom", "Sinkovits Imre")));
        Movie movie3 = new Movie("Ne nézz fel", 160, new ArrayList<>(Arrays.asList("Leonardo DiCaprio", "Emilia Hart", "Sinkovits Imre")));
        Movie movie4 = new Movie("Star Wars", 130, new ArrayList<>(Arrays.asList("Clint Eastwood", "Széles Tamás")));

        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        movieService.addMovie(movie4);

        moviesOfDiCaprio.add(movie1);
        moviesOfDiCaprio.add(movie3);
    }

    @Test
    void findMovieByActorTest() {
        assertEquals(moviesOfDiCaprio, movieService.findMovieByActor("Leonardo DiCaprio"));
    }

    @Test
    void getLongestMovieLengthTest() {
        assertEquals(180, movieService.getLongestMovieLength());
    }
}