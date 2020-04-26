package ru.netology;


import org.junit.jupiter.api.Test;

public class MovieManagerTestNonEmpty {
    @Test
    public void shouldRemoveIfExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 1;
        MovieManager first = new MovieManager(1, 1, "first", 1, 1);
        MovieManager second = new MovieManager(2, 2, "second", 1, 1);
        MovieManager third = new MovieManager(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieManager[] actual = manager.getAll();
        MovieManager[] expected = new MovieManager[][]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 4;
        MovieManager first = new MovieManager(1, 1, "first", 1, 1);
        MovieManager second = new MovieManager(2, 2, "second", 1, 1);
        MovieManager third = new MovieManager(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        MovieManager[] actual = manager.getAll();
        MovieManager[] expected = new MovieManager[][]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}