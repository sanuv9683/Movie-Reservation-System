/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.Users;
import com.ijse.theaterbooking.observer.UserObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface UserController extends Remote {

    public boolean registerUsert(Users user) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean checkRegisteredUser(String uName, String password) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public Users checkUserName(String uName) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setPrivateMessage(String message, String sender, String reciever) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void userBookingHistory(String loginDateTime, String logoutTime, String sender, String reciever, String[] message) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateUser(Users users) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public Users searchUser(String uName) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean deleteUser(String id) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addUserObserver(UserObserver userObserver) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeUserObserver(UserObserver userObserver) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveUser(String id) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseUser(String id) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setMessage(String message) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<Users> getAllUsers() throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

}
