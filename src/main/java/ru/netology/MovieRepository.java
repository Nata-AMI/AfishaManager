package ru.netology;

public class MovieRepository {
    private MovieManager[] items = new MovieManager[0];

    public void save(MovieManager movie) {
        int length = items.length + 1;
        MovieManager[] tmp = new MovieManager[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        items = tmp;
    }

    public MovieManager[] findAll() {
        return items;
    }

    public void findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
    }

    public void removeById(int id) {
        int length = items.length - 1;
        MovieManager[] tmp = new MovieRepository[length];
        int index = 0;
        for (MovieManager item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
