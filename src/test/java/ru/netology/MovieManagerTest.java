package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MovieManagerTest {

    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1,  "first", "1", "comedy");
    private Movie second = new Movie(2,  "second", "1", "tragedy");
    private Movie third = new Movie(3,  "third", "1", "animal");

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.removeById();
        Movie[] expected = new Movie[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        manager.add(first);
        manager.add(second);
        manager.add(third);


        Movie[] actual = manager.removeById();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetByOrder() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.getByOrder(3);
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldOnlyOne() {
        manager.add(first);

        Movie[] actual = manager.getByOrder(1);
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }
}