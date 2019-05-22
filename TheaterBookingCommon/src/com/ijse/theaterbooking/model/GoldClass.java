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
public class GoldClass implements Serializable{
    private int noOfGoldClassSeats;
    private String goldClassId;
    private double fullPriceGC;
    private double halfPriceGC;

    public GoldClass() {
    }

    public GoldClass(int noOfGoldClassSeats, String goldClassId, double fullPriceGC, double halfPriceGC) {
        this.noOfGoldClassSeats = noOfGoldClassSeats;
        this.goldClassId = goldClassId;
        this.fullPriceGC = fullPriceGC;
        this.halfPriceGC = halfPriceGC;
    }

    /**
     * @return the noOfGoldClassSeats
     */
    public int getNoOfGoldClassSeats() {
        return noOfGoldClassSeats;
    }

    /**
     * @param noOfGoldClassSeats the noOfGoldClassSeats to set
     */
    public void setNoOfGoldClassSeats(int noOfGoldClassSeats) {
        this.noOfGoldClassSeats = noOfGoldClassSeats;
    }

    /**
     * @return the goldClassId
     */
    public String getGoldClassId() {
        return goldClassId;
    }

    /**
     * @param goldClassId the goldClassId to set
     */
    public void setGoldClassId(String goldClassId) {
        this.goldClassId = goldClassId;
    }

    /**
     * @return the fullPriceGC
     */
    public double getFullPriceGC() {
        return fullPriceGC;
    }

    /**
     * @param fullPriceGC the fullPriceGC to set
     */
    public void setFullPriceGC(double fullPriceGC) {
        this.fullPriceGC = fullPriceGC;
    }

    /**
     * @return the halfPriceGC
     */
    public double getHalfPriceGC() {
        return halfPriceGC;
    }

    /**
     * @param halfPriceGC the halfPriceGC to set
     */
    public void setHalfPriceGC(double halfPriceGC) {
        this.halfPriceGC = halfPriceGC;
    }
    
    
    
    
}
