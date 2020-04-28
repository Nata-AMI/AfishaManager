package ru.netology;

public class MovieRepository {
    private Movie[] items = new Movie[0];

    public save(Movie movie) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}