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
public class ODC implements Serializable{
    private int noOfODCSeats;
    private String ODCId;
    private double fullODCPrice;
    private double halfODCPrice;

    public ODC() {
    }

    public ODC(int noOfODCSeats, String ODCId, double fullODCPrice, double halfODCPrice) {
        this.noOfODCSeats = noOfODCSeats;
        this.ODCId = ODCId;
        this.fullODCPrice = fullODCPrice;
        this.halfODCPrice = halfODCPrice;
    }

    /**
     * @return the noOfODCSeats
     */
    public int getNoOfODCSeats() {
        return noOfODCSeats;
    }

    /**
     * @param noOfODCSeats the noOfODCSeats to set
     */
    public void setNoOfODCSeats(int noOfODCSeats) {
        this.noOfODCSeats = noOfODCSeats;
    }

    /**
     * @return the ODCId
     */
    public String getODCId() {
        return ODCId;
    }

    /**
     * @param ODCId the ODCId to set
     */
    public void setODCId(String ODCId) {
        this.ODCId = ODCId;
    }

    /**
     * @return the fullODCPrice
     */
    public double getFullODCPrice() {
        return fullODCPrice;
    }

    /**
     * @param fullODCPrice the fullODCPrice to set
     */
    public void setFullODCPrice(double fullODCPrice) {
        this.fullODCPrice = fullODCPrice;
    }

    /**
     * @return the halfODCPrice
     */
    public double getHalfODCPrice() {
        return halfODCPrice;
    }

    /**
     * @param halfODCPrice the halfODCPrice to set
     */
    public void setHalfODCPrice(double halfODCPrice) {
        this.halfODCPrice = halfODCPrice;
    }
    
    
    
}
