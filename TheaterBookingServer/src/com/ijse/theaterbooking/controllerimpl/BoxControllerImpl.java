/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.BoxSeatsController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.observable.BoxSeatsObservable;
import com.ijse.theaterbooking.observer.BoxSeatsObserver;
import com.ijse.theaterbooking.reservation.BoxSeatReserver;
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
public class BoxControllerImpl extends UnicastRemoteObject implements
        BoxSeatsController {

    private static BoxSeatsObservable boxSeatsObservable = new BoxSeatsObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static BoxSeatReserver boxSeatReserver = new BoxSeatReserver();

    public BoxControllerImpl() throws RemoteException {

    }

    @Override
    public boolean checkAvailableBox(String boxId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBoxSeatObserver(BoxSeatsObserver boxSeatsObserver)
            throws RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException, 
            SQLException {
        boxSeatsObservable.addBoxSeatsObserver(boxSeatsObserver);
    }

    @Override
    public void removeBoxSeatObserver(BoxSeatsObserver boxSeatsObserver)
            throws RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException,
            SQLException {
        boxSeatsObservable.removeBoxSeatsObserver(boxSeatsObserver);
    }

    @Override
    public boolean reserveBoxSeat(String id) throws RemoteException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return boxSeatReserver.reserveBoxSeat(id, this);
    }

    @Override
    public boolean releaseBoxSeat(String id) throws RemoteException,
            IOException, FileNotFoundException, ParseException, 
            NotBoundException, ClassNotFoundException, SQLException {
        return boxSeatReserver.releaseBoxSeat(id, this);
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BoxSeat> getAllBoxSeats() throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getBoxSeatsService().getAllBoxSeats();
    }

    @Override
    public boolean addNewBoxSeat(BoxSeat boxSeat) throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getBoxSeatsService().addBoxSeat(boxSeat);
    }

    @Override
    public boolean updateBoxSeat(BoxSeat boxSeat) throws RemoteException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getBoxSeatsService().updateBoxSeat(boxSeat);
    }

    @Override
    public BoxSeat searchBoxSeat(String boxId) throws RemoteException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getBoxSeatsService().searchBoxSeat(boxId);
    }

    @Override
    public boolean removeBoxSeat(String boxID) throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getBoxSeatsService().deleteBoxSeat(boxID);
    }

}
