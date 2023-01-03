package com.myProjects.moviecatalogservice.models;

public class Movie {
    private String movieId;
    private String movieDesc;

    public Movie(){

    }
    public Movie(String movieId, String movieDesc) {
        this.movieId = movieId;
        this.movieDesc = movieDesc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }
}
