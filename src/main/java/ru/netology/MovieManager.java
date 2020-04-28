package ru.netology;

public class MovieManager {
    private MovieManager[] items = new MovieManager[0];
    int maxMovieAmount = 10;
    int minMovieAmount = 0;

    public void add(MovieManager item) {
        int length = items.length + 1;
        MovieManager[] tmp = new MovieManager[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getByOrder(int MovieAmount) {
        if (MovieAmount>=maxMovieAmount) {
            MovieAmount=maxMovieAmount;
        }
        if (MovieAmount<=maxMovieAmount) {
            MovieAmount=minMovieAmount);
        }
        MovieManager[] result = new MovieManager[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}


