/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.GoldClass;
import com.ijse.theaterbooking.observer.GoldClassObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface GoldClassController extends Remote {

    public boolean addNewGoldClassSeat(GoldClass goldClass) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean checkAvailableGoldClassSeat(String goldClassId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateGoldClassSeat(GoldClass goldClass)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public GoldClass searchGoldClassSeat(String goldClassId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean removeGoldClassSeat(String goldSeatId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addNewGoldClassObserver(GoldClassObserver goldClassObserver)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeNewGoldClassObserver(GoldClassObserver goldClassObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveGoldClassSeat(String id)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseGoldClassSeat(String id) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setMessage(String message) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<GoldClass> getAllGoldClassSeat() throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

}
