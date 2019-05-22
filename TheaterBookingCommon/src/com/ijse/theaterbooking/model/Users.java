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
public class Users implements Serializable{
    private String userName;
    private String userID;
    private String userEmail;
    private String userTPNo;
    private String userBday;
    private String uPassWord;

    public Users() {
    }

    public Users(String userName, String userID, String userEmail, String userTPNo, String userBday, String uPassWord) {
        this.userName = userName;
        this.userID = userID;
        this.userEmail = userEmail;
        this.userTPNo = userTPNo;
        this.userBday = userBday;
        this.uPassWord = uPassWord;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userTPNo
     */
    public String getUserTPNo() {
        return userTPNo;
    }

    /**
     * @param userTPNo the userTPNo to set
     */
    public void setUserTPNo(String userTPNo) {
        this.userTPNo = userTPNo;
    }

    /**
     * @return the userBday
     */
    public String getUserBday() {
        return userBday;
    }

    /**
     * @param userBday the userBday to set
     */
    public void setUserBday(String userBday) {
        this.userBday = userBday;
    }

    /**
     * @return the uPassWord
     */
    public String getuPassWord() {
        return uPassWord;
    }

    /**
     * @param uPassWord the uPassWord to set
     */
    public void setuPassWord(String uPassWord) {
        this.uPassWord = uPassWord;
    }

   
    
}
