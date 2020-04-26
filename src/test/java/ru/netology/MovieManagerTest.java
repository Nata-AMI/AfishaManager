package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    private MovieManager first = new MovieManager(1, 1, "first", 1, 1);
    private MovieManager second = new MovieManager(2, 2, "second", 1, 1);
    private MovieManager third = new MovieManager(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        // настройка заглушки
        MovieManager[] returned = new MovieManager[][]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        MovieManager[] expected = new MovieManager[][]{third, second};
        MovieManager[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        MovieManager[] returned = new MovieManager[][]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        MovieManager[] expected = new MovieManager[][]{third, second, first};
        MovieManager[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }
}