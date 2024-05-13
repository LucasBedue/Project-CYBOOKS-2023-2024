package com.example.cybooks;

public class Genre {
    private String Genre;

    /**
     * Constructor for the genre
     * @param Genre
     */
    public Genre(String Genre){
        this.Genre = Genre;
    }

    /**
     * Getter for the genre
     * @return this genre
     */
    public String getGenre(){
        return this.Genre;
    }

    /**
     * Return the genre as a string
     * @return this genre as a string
     */
    @Override
    public String toString(){
        return this.getGenre();
    }
}
