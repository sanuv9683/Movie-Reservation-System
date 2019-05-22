/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.ODCController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.ODC;
import com.ijse.theaterbooking.observable.ODCSeatsObservable;
import com.ijse.theaterbooking.observer.ODCObserver;
import com.ijse.theaterbooking.reservation.ODCSeatsReserver;
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
public class ODCControllerImpl extends UnicastRemoteObject implements
        ODCController {

    private static ODCSeatsObservable oDCSeatsObservable = new
         ODCSeatsObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static ODCSeatsReserver oDCSeatsReserver = new ODCSeatsReserver();

    public ODCControllerImpl() throws RemoteException {
    }

    @Override
    public boolean checkAvailableODCSeats(String ODCId) throws RemoteException,
            ClassNotFoundException, SQLException, IOException, 
            FileNotFoundException, ParseException, NotBoundException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addODCObserver(ODCObserver odcObserver) throws 
            RemoteException, ClassNotFoundException, SQLException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException {
        oDCSeatsObservable.addODCObserver(odcObserver);
    }

    @Override
    public void removeODCObserver(ODCObserver odcObserver) throws 
            RemoteException, ClassNotFoundException, SQLException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException {
        oDCSeatsObservable.removeODCObserver(odcObserver);
    }

    @Override
    public boolean reserveODCSeat(String ODCId) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException, 
            FileNotFoundException, ParseException, NotBoundException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean releaseODCSeat(String ODCId) throws RemoteException,
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMessage(String message) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ODC> getAllODCSeats() throws RemoteException,
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getODCService().getAllODCSeats();
    }

    @Override
    public boolean addNewODCSeat(ODC odc) throws RemoteException,
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getODCService().addODC(odc);
    }

    @Override
    public boolean updateODCSeats(ODC odc) throws RemoteException,
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getODCService().updateODC(odc);
    }

    @Override
    public ODC searchODCSeat(String ODCId) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getODCService().searchODC(ODCId);
    }

    @Override
    public boolean removeODCSeat(String odc) throws RemoteException,
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getODCService().deleteODC(odc);
    }

}
