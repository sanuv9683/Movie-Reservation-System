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
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class UserObservable {

    private ArrayList<UserObserver> userObservers = new ArrayList<>();

    public boolean addUserObserver(UserObserver userObserver) {
        return userObservers.add(userObserver);
    }

    public boolean removeUserObserver(UserObserver userObserver) {
        return userObservers.remove(userObserver);
    }

    public void notifyUserObservers(String message) throws RemoteException {
        for (UserObserver userObserver : userObservers) {
            new Thread() {
                public void run() {
                    try {
                        userObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
