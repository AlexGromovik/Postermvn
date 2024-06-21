public class PosterManager {

    private String[] nameMovies = new String[0]; // менеджер
    private final int limit; // переменная количества фильмов

    public PosterManager(int limit) {// Конструктор без указания параметров
        this.limit = limit; // переменная количества фильмов
    }

    public PosterManager(){ // Конструктор с указанием параментов
        this.limit = 7; // переменная количества фильмов
    }

    public void add(String newMovie){ // метод добавления нового фильма

        String[] tmp = new String[nameMovies.length + 1]; // имитация добавления нового фильма
        for (int i = 0; i < nameMovies.length; i++){
            tmp[i] = nameMovies[i];
        }
        tmp[tmp.length - 1] = newMovie;
        nameMovies = tmp;
    }

    public String[] findAll(){ // метод показа всех фильмов в Афише
        return nameMovies; // возвращаем массив
    }

    public String[] findLast(){ // метод нахождения последних добавленных фильмов
        int resultLenght;
        if (nameMovies.length < limit) {// прогоняем массив по количеству элементов
            resultLenght = nameMovies.length;
        } else {
            resultLenght = limit;
        }
        String[] tmp = new String[resultLenght]; // переворачиваем его
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = nameMovies[nameMovies.length - 1 - i];
        }
        return tmp; // возвращаем перевернутый
    }

}
