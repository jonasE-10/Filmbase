package filmbase.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Film {
    private String title;
    private int year;
    private Collection<Genre> genres = new ArrayList<>();

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenre(Collection<Genre> genres) {
        this.genres = genres;
    }

    public Film(String title, int year, Genre... genre) {
        this.title = title;
        this.year = year;
        this.genres.addAll(List.of(genre));
    }
    public void addGenre(Genre genre) {
        if(genres.contains(genre)) {
            System.out.println("Filmen, indholder allerede "+genre.toString());
        }
        this.genres.add(genre);
    }
    public boolean hasGenre(Genre genre) {
        if (genres.contains(genre)){
            return true;
        }
        return false;
    }

    public String getTitle(){
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
