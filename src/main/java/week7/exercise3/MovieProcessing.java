package week7.exercise3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieProcessing {
    static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("Inception", "Sci-Fi", 8.8, 2010),
                new Movie("Interstellar", "Sci-Fi", 8.6, 2014),
                new Movie("The Batman", "Action", 7.9, 2022),
                new Movie("Dune", "Sci-Fi", 8.1, 2021),
                new Movie("Joker", "Drama", 8.4, 2019),
                new Movie("Avengers Endgame", "Action", 8.4, 2019),
                new Movie("Tenet", "Sci-Fi", 7.3, 2020)
        );

        List<String> result = movies.stream()
                .filter(movie -> movie.releaseYear() > 2015)
                .filter(movie -> movie.rating() >= 8.0)
                .sorted(Comparator.comparing(Movie::rating).reversed())
                .map(movie -> String.format("%s (%d) - %.1f",movie.title(), movie.releaseYear(), movie.rating()))
                .toList();

        System.out.println(result);
    }
}