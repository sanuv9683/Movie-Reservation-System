/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.observer.BoxSeatsObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface BoxSeatsController extends Remote {

    public boolean addNewBoxSeat(BoxSeat boxSeat) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean checkAvailableBox(String boxId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateBoxSeat(BoxSeat boxSeat) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public BoxSeat searchBoxSeat(String boxId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean removeBoxSeat(String boxID)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addBoxSeatObserver(BoxSeatsObserver boxSeatsObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeBoxSeatObserver(BoxSeatsObserver boxSeatsObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveBoxSeat(String id) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseBoxSeat(String id) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setMessage(String message) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<BoxSeat> getAllBoxSeats() throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;
}
