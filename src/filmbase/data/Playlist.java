package filmbase.data;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Film> films = new ArrayList<>();

    public boolean addFilm(Film film){
        //.add
        if (!hasFilm(film)) {
            System.out.println(film.getTitle()+" findes allerede, blev ikke tilføjet");
            return false;
        } else {
            films.add(film);
            return true;
        }
    }
    public Film playAndRemove(){
        //.removeFirst
        if (!films.isEmpty()) {
            return films.removeFirst();
        }
        return null;
    }
    public Film displayNextFilm(){
        //.getFirst
        if (!films.isEmpty()) {
            return films.getFirst();
        }
        return null;
    }
    public int totalNumberOfFilm(){
        //.size
        return films.size();
    }
    public List<Film> listOfFilms(){
        return films;
    }
    public void clearList(){
        //.clear
        films.clear();
    }
    public boolean hasFilm(Film film){
        if (films.contains(film)) {
            return false;
        }else
            return true;
    }
    public boolean hasNext(){
        if (!films.isEmpty()){
            return true;
        }
        return false;
    }
}
