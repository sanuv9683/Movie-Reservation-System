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
public class BookDetails implements Serializable {

    private String bookingId;
    private String movieId;
    private String sheetId;
    private double price;
    private String bDate;

    public BookDetails() {
    }

    public BookDetails(String bookingId, String movieId, String sheetId, double price, String bDate) {
        this.bookingId = bookingId;
        this.movieId = movieId;
        this.sheetId = sheetId;
        this.price = price;
        this.bDate = bDate;
    }

    /**
     * @return the bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the sheetId
     */
    public String getSheetId() {
        return sheetId;
    }

    /**
     * @param sheetId the sheetId to set
     */
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the bDate
     */
    public String getbDate() {
        return bDate;
    }

    /**
     * @param bDate the bDate to set
     */
    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

}
