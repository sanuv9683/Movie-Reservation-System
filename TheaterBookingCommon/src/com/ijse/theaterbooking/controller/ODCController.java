/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.ODC;
import com.ijse.theaterbooking.observer.ODCObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface ODCController extends Remote {

    public boolean addNewODCSeat(ODC odc) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean checkAvailableODCSeats(String ODCId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateODCSeats(ODC odc) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ODC searchODCSeat(String ODCId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean removeODCSeat(String odc) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addODCObserver(ODCObserver odcObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeODCObserver(ODCObserver odcObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveODCSeat(String ODCId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseODCSeat(String ODCId) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setMessage(String message) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<ODC> getAllODCSeats()throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;
}
