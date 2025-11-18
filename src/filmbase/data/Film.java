package filmbase.data;

import java.util.*;

public class Film {
    private String title;
    private int year;
    private Set<Genre> genres = new HashSet<>();

    public Set<Genre> getGenres() {
        return genres;
    }

    public Film(String title, int year, Genre... genre) {
        this.title = title;
        this.year = year;
        this.genres.addAll(List.of(genre));
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
