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
public class Book implements Serializable{
    private String bookId;
    private String bookDate;
    private String userId;

    public Book() {
    }

    public Book(String bookId, String bookDate, String userId) {
        this.bookId = bookId;
        this.bookDate = bookDate;
        this.userId = userId;
    }

    /**
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the bookDate
     */
    public String getBookDate() {
        return bookDate;
    }

    /**
     * @param bookDate the bookDate to set
     */
    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
     
}
