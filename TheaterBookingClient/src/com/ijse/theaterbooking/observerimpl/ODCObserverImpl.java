/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.observerimpl;

import com.ijse.theaterbooking.observer.ODCObserver;
import com.ijse.theaterbooking.view.GoldClassBook;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Sanu Vithanage
 */
public class ODCObserverImpl extends UnicastRemoteObject implements ODCObserver {

    public ODCObserverImpl() throws RemoteException {

    }

    @Override
    public void update(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
