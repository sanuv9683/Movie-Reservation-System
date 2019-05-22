/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.observable;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.theaterbooking.observer.ODCObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class ODCSeatsObservable {
     private ArrayList<ODCObserver> odcObservers = new ArrayList<>();

    public boolean addODCObserver(ODCObserver odcObserver) {
        return odcObservers.add(odcObserver);
    }

    public boolean removeODCObserver(ODCObserver odcObserver) {
        return odcObservers.remove(odcObserver);
    }

    public void notifyODCObservers(String message) throws RemoteException {
        for (ODCObserver odcObserver : odcObservers) {
            new Thread() {
                public void run() {
                    try {
                        odcObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
