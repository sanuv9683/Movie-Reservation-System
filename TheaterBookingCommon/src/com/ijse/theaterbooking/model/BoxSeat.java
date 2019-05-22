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
public class BoxSeat implements Serializable{
    private int noOFBoxSeats;
    private String boxId;
    private double boxPrice;

    public BoxSeat() {
    }

    public BoxSeat(int noOFBoxSeats, String boxId, double boxPrice) {
        this.noOFBoxSeats = noOFBoxSeats;
        this.boxId = boxId;
        this.boxPrice = boxPrice;
    }

    /**
     * @return the noOFBoxSeats
     */
    public int getNoOFBoxSeats() {
        return noOFBoxSeats;
    }

    /**
     * @param noOFBoxSeats the noOFBoxSeats to set
     */
    public void setNoOFBoxSeats(int noOFBoxSeats) {
        this.noOFBoxSeats = noOFBoxSeats;
    }

    /**
     * @return the boxId
     */
    public String getBoxId() {
        return boxId;
    }

    /**
     * @param boxId the boxId to set
     */
    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    /**
     * @return the boxPrice
     */
    public double getBoxPrice() {
        return boxPrice;
    }

    /**
     * @param boxPrice the boxPrice to set
     */
    public void setBoxPrice(double boxPrice) {
        this.boxPrice = boxPrice;
    }

   
    
    

    
    
}
