import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager(5);

    String nameMovie1 = "Блэдшот";
    String nameMovie2 = "Вперёд";
    String nameMovie3 = "Отель <<Белград>>";
    String nameMovie4 = "Джельтемены";
    String nameMovie5 = "Человек-неведимка";
    String nameMovie6 = "Тролли. Мировой тур";
    String nameMovie7 = "Номер один";

    @BeforeEach
    public void setup() { // Начальные предустановки к тестированию
        manager.add(nameMovie1);
        manager.add(nameMovie2);
        manager.add(nameMovie3);
        manager.add(nameMovie4);
        manager.add(nameMovie5);
        manager.add(nameMovie6);
        manager.add(nameMovie7);
    }

    @Test
    public void shouldAllPoster() { // должен вернуть все постеры в порядке добавления элементов

        String[] expected = {nameMovie1, nameMovie2, nameMovie3, nameMovie4, nameMovie5, nameMovie6, nameMovie7};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterWithIncorrectNumberOfMovies() { // должен вернуть афишу со всеми элементами в обратном порядке (от последнего добавленного элеменкта)
        PosterManager manager = new PosterManager();

        manager.add(nameMovie1);
        manager.add(nameMovie2);
        manager.add(nameMovie3);
        manager.add(nameMovie4);
        manager.add(nameMovie5);
        manager.add(nameMovie6);
        manager.add(nameMovie7);

        String[] expected = { nameMovie7, nameMovie6, nameMovie5, nameMovie4, nameMovie3 };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterWithinLimit() { // проверка лимитированной афиши, с включенными в пределами фильмами
        PosterManager manager = new PosterManager();

        manager.add(nameMovie5);
        manager.add(nameMovie6);
        manager.add(nameMovie7);

        String[] expected = {nameMovie7, nameMovie6, nameMovie5};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterBeyondTheLimit() { // проверка лимитированной афиши, с превышающим перечнем фильмов
        PosterManager manager = new PosterManager(5);
        manager.add(nameMovie1);
        manager.add(nameMovie2);
        manager.add(nameMovie3);
        manager.add(nameMovie4);
        manager.add(nameMovie5);
        manager.add(nameMovie6);

        String[] expected = {nameMovie6, nameMovie5, nameMovie4, nameMovie3, nameMovie2};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPosterWithLackOfMovies() {

        PosterManager manager = new PosterManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}
