package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.Playlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();

    public FilmBase(){

    }
    public void start(){
        System.out.println("--- FilmBasen er startet ---");
        initFilms();
        printList(allFilms);
        testPlaylist();
        testFiltering();
    }
    private void initFilms(){
        allFilms.add(new Film("The Godfather", 1972, Genre.Crime, Genre.Drama));
        allFilms.add(new Film("The Shawshank Redemption", 1994, Genre.Drama));
        allFilms.add(new Film("Schindler's List", 1993, Genre.Biography,Genre.Drama));
        allFilms.add(new Film("Some Like It Hot", 1959, Genre.Comedy,Genre.Romance));
        allFilms.add(new Film("Ben Hur", 1959, Genre.Adventure,Genre.Drama));
        allFilms.add(new Film("Apocalypse Now", 1979, Genre.Drama,Genre.War));
        allFilms.add(new Film("Gladiator", 2000, Genre.Action,Genre.Adventure,Genre.Drama));
        allFilms.add(new Film("Titanic", 1997, Genre.Drama,Genre.Romance));
        allFilms.add(new Film("From Here To Eternity", 1953, Genre.Drama, Genre.Romance));
        allFilms.add(new Film("Unforgiven", 1992, Genre.Drama));
        allFilms.add(new Film("Chinatown", 1974, Genre.Drama));
    }
    private void printList(Collection<Film> films) {
        for (Film film : films) {
            System.out.println(film.getTitle() + " : " + "(" + film.getYear() + ")" + " : " + film.getGenres());
        }
    }
    private void testFiltering() {
        Playlist playlist = new Playlist();
        System.out.println("--- Tilføjer til playlist ---");
        for (int i = 0; i < allFilms.size(); i++) {
            playlist.addFilm(allFilms.get(i));
        }

        System.out.println("--- Udskriver playlist med filter(Romance) ---");
        for (Film film : playlist.listOfFilms()) {
            if (film.hasGenre(Genre.Romance)) {
                System.out.println(film.getTitle() + " : " + film.getGenres());
            }
        }
    }
    private void testPlaylist(){
        Playlist playlist = new Playlist();
        System.out.println("--- Tilføjer til playlist ---");
        for (int i = 0; i < allFilms.size(); i++) {
            playlist.addFilm(allFilms.get(i));
        }
        System.out.println("--- Udskriver Playlist ---");
        while(playlist.hasNext()){
            System.out.println(playlist.playAndRemove().getTitle());
        }
    }
}
