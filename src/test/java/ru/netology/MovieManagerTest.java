package ru.netology;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestNonEmpty {

    private MovieManager manager = new MovieManager();
    Movie first = new Movie(1, 1, "first", 1, 1);
    Movie second = new Movie(2, 2, "second", 1, 1);
    Movie third = new Movie(3, 3, "third", 1, 1);
    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieRepository.removeById(idToRemove);

        MovieManager[] actual = manager.getByOrder();
        MovieManager[] expected = new MovieManager[][]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieRepository.removeById(idToRemove);

        MovieManager[] actual = manager.getByOrder();
        MovieManager[] expected = new MovieManager[][]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}