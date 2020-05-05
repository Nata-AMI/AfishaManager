package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MovieManagerTest {

    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1,  "first", "1", "comedy");
    private Movie second = new Movie(2,  "second", "1", "tragedy");
    private Movie third = new Movie(3,  "third", "1", "animal");
    private Movie fortth = new Movie(4,  "fortth", "1", "animal");
    private Movie fifth = new Movie(5,  "fifth", "1", "animal");
    private Movie sixth = new Movie(6,  "sixth", "1", "animal");
    private Movie seventh = new Movie(7,  "seventh", "1", "animal");
    private Movie eighth = new Movie(8,  "eighth", "1", "animal");
    private Movie ninth = new Movie(9,  "ninth", "1", "animal");
    private Movie tenth = new Movie(10,  "tenth", "1", "animal");
    private Movie eleventh = new Movie(11,  "eleventh", "1", "animal");


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
    public void shouldRemoveNoExists() {
        manager.add(first);
        manager.add(second);
        int idToRemove = 4;
        manager.add(third);


        Movie[] actual = manager.removeById();
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

    @Test
    public void shouldMostThemTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fortth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getByOrder(11);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth,fifth, fortth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddedOne() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fortth);
        manager.add(fifth);
        manager.add(sixth);

        Movie[] actual = manager.getByOrder(7);
        Movie[] expected = new Movie[]{seventh, sixth,fifth, fortth, third, second, first};
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
    public void shouldOnlyTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fortth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getByOrder(10);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth,fifth, fortth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMinusTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fortth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getByOrder(-10);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth,fifth, fortth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneHundred() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fortth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getByOrder(100);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth,fifth, fortth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}