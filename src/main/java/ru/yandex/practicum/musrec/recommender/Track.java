package ru.yandex.practicum.musrec.recommender;

public class Track {

    private String title;
    private String author;
    private int creationYear;
    private int mark;

    public Track(String title, String author, int creationYear) {
        this.title = title;
        this.author = author;
        this.creationYear = creationYear;
    }

    public Track(String title, String author, int creationYear, int mark) {
        this.title = title;
        this.author = author;
        this.creationYear = creationYear;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
