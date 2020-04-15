package Afisha.ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private int id;
    private String Name;
    private int ImageUrl;
    private int ganre;

    public void add(Movie first) {
    }
}


public class AfishaManager {
    private Movie[] movies;

    public Movie[] getMovies() {
        return null;
    }

public void add(Movie movie) {
        movies.length = 9;
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movie,0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
        }

public Movie[] getAll(){
        Movie[] result = new Movie[movies.length];
    for (int i = 0; i < result.length ; i++) {
        int index = movies.length - i - 1;
        result[i] = movies[index];
    }
    return result;
}

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
