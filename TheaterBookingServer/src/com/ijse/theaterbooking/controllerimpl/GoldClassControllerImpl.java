/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.GoldClassController;
import com.ijse.theaterbooking.fileaccses.GoldClassFileAccses;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.GoldClass;
import com.ijse.theaterbooking.observable.GoldClassObservable;
import com.ijse.theaterbooking.observer.GoldClassObserver;
import com.ijse.theaterbooking.reservation.GoldClassReserver;
import com.ijse.theaterbooking.servicefactory.ServiceFactory;
import com.ijse.theaterbooking.servicefactoryimpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassControllerImpl extends UnicastRemoteObject implements 
        GoldClassController {

    private static GoldClassObservable goldClassObservable = new 
        GoldClassObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static GoldClassReserver goldClassReserver = new GoldClassReserver();

    public GoldClassControllerImpl() throws RemoteException {

    }

    @Override
    public boolean checkAvailableGoldClassSeat(String goldClassId)
            throws RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNewGoldClassObserver(GoldClassObserver goldClassObserver) 
            throws RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException, 
            SQLException {
        goldClassObservable.addGoldClassObserver(goldClassObserver);
    }

    @Override
    public void removeNewGoldClassObserver(GoldClassObserver goldClassObserver)
            throws RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        goldClassObservable.removeGoldClassObserver(goldClassObserver);
    }

    @Override
    public boolean reserveGoldClassSeat(String id) throws RemoteException {
        return goldClassReserver.reserveGoldClass(id, this);
    }

    @Override
    public boolean releaseGoldClassSeat(String id) throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return goldClassReserver.reserveGoldClass(id, this);
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GoldClass> getAllGoldClassSeat() throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getGoldClassService().getAllGoldClasses();
    }

    @Override
    public boolean addNewGoldClassSeat(GoldClass goldClass) throws
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        return serviceFactory.getGoldClassService().addGoldClass(goldClass);
    }

    @Override
    public boolean updateGoldClassSeat(GoldClass goldClass) throws 
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        return serviceFactory.getGoldClassService().updateGoldClass(goldClass);
    }

    @Override
    public GoldClass searchGoldClassSeat(String goldClassId) throws 
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        return serviceFactory.getGoldClassService().searchGoldClassSeat
        (goldClassId);
    }

    @Override
    public boolean removeGoldClassSeat(String goldSeatId) throws
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        return serviceFactory.getGoldClassService().deleteGoldClass(goldSeatId);
    }

}
