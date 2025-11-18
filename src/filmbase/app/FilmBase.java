package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.Playlist;

import java.util.*;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();

    public FilmBase(){

    }
    public void start(){
        System.out.println("--- FilmBasen er startet ---");
        initFilms();
        //testPlaylist();
        //testFiltering();
        //countGenres();
    }
    private void initFilms(){
        allFilms.add(new Film("The Godfather", 1972, Genre.Crime, Genre.Drama,Genre.Crime, Genre.Drama));
        allFilms.add(new Film("The Shawshank Redemption", 1994, Genre.Drama,Genre.Crime, Genre.Drama));
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
        if (films.isEmpty()){
            System.out.println("--- Listen er tom! ---");
        }
    }
    private void testPlaylist(){
        Playlist playlist = new Playlist();
        System.out.println("--- Tilføjer til playlist ---");
        for (int i = 0; i < allFilms.size(); i++) {
            playlist.addFilm(allFilms.get(i));
        }
        System.out.println("--- Udskriver Playlist ---");
        printList(playlist.listOfFilms());
        while(playlist.hasNext()){
            System.out.println("--- Afspiller næste film i playlist ---");
            System.out.println(playlist.playAndRemove().getTitle());
        }
        printList(playlist.listOfFilms());
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
    private void countGenres(){
        Set<Genre> allGenres = new HashSet<>();
        Map<Genre, Collection<Film>> genreFilms = new HashMap<>();
        for (Film film : allFilms){
            allGenres.addAll(film.getGenres());
        }
        System.out.println("--- Udskriver alle Genres ---");
        System.out.println(allGenres);
        for (Film film : allFilms) {
            for (Genre genre : allGenres){
                if (!genreFilms.containsKey(genre)){
                    Collection<Film> filmMedGenre = new ArrayList<>();
                    filmMedGenre.add(film);
                    genreFilms.put(genre,filmMedGenre);
                } else {
                    Collection<Film> filmMedGenre = genreFilms.get(genre);
                    filmMedGenre.add(film);
                }
            }
        }
        for (Genre genre: genreFilms.keySet()){
            System.out.println("--- Genre ---");
            System.out.println("--- "+genre+" ---");
            System.out.println("--- Film i Genre ---");
            for (Film film : genreFilms.get(genre)){
                System.out.println(film.getTitle());
            }
        }

    }
}
