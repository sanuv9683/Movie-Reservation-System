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
import com.ijse.theaterbooking.observer.GoldClassObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassObservable {
     private ArrayList<GoldClassObserver> goldClassObservers = new ArrayList<>();

    public boolean addGoldClassObserver(GoldClassObserver goldClassObserver) {
        return goldClassObservers.add(goldClassObserver);
    }

    public boolean removeGoldClassObserver(GoldClassObserver goldClassObserver) {
        return goldClassObservers.remove(goldClassObserver);
    }

    public void notifyGoldClassObservers(String message) throws RemoteException {
        for (GoldClassObserver goldClassObserver : goldClassObservers) {
            new Thread() {
                public void run() {
                    try {
                        goldClassObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
