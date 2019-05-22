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
import com.ijse.theaterbooking.observer.BoxSeatsObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class BoxSeatsObservable {
     private ArrayList<BoxSeatsObserver> boxSeatsObservers = new ArrayList<>();

    public boolean addBoxSeatsObserver(BoxSeatsObserver boxSeatsObserver) {
        return boxSeatsObservers.add(boxSeatsObserver);
    }

    public boolean removeBoxSeatsObserver(BoxSeatsObserver boxSeatsObserver) {
        return boxSeatsObservers.remove(boxSeatsObserver);
    }

    public void notifyBoxSeatsObservers(String message) throws RemoteException {
        for (BoxSeatsObserver boxSeatsObserver : boxSeatsObservers) {
            new Thread() {
                public void run() {
                    try {
                        boxSeatsObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
