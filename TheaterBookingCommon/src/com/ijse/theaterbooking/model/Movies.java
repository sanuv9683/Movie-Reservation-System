/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.model;

import java.io.Serializable;

/**
 *
 * @author Sanu Vithanage
 */
public class Movies implements Serializable {

    private String movieID;
    private String movieName;
    private String movieTime;
    private String movieType;
    private String movieDuration;
    private String movieTrailer;
    private String movieImageId;

    public Movies() {
    }

    public Movies(String movieID, String movieName, String movieTime, String movieType, String movieDuration, String movieTrailer, String movieImageId) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.movieType = movieType;
        this.movieDuration = movieDuration;
        this.movieTrailer = movieTrailer;
        this.movieImageId = movieImageId;
    }

    /**
     * @return the movieID
     */
    public String getMovieID() {
        return movieID;
    }

    /**
     * @param movieID the movieID to set
     */
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    /**
     * @return the movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName the movieName to set
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return the movieTime
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * @param movieTime the movieTime to set
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    /**
     * @return the movieType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * @param movieType the movieType to set
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * @return the movieDuration
     */
    public String getMovieDuration() {
        return movieDuration;
    }

    /**
     * @param movieDuration the movieDuration to set
     */
    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    /**
     * @return the movieTrailer
     */
    public String getMovieTrailer() {
        return movieTrailer;
    }

    /**
     * @param movieTrailer the movieTrailer to set
     */
    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    /**
     * @return the movieImageId
     */
    public String getMovieImageId() {
        return movieImageId;
    }

    /**
     * @param movieImageId the movieImageId to set
     */
    public void setMovieImageId(String movieImageId) {
        this.movieImageId = movieImageId;
    }

    
}
