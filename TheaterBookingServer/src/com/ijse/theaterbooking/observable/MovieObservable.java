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
import com.ijse.theaterbooking.observer.MovieObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class MovieObservable {
     private ArrayList<MovieObserver> movieObservers = new ArrayList<>();

    public boolean addMovieObserver(MovieObserver movieObserver) {
        return movieObservers.add(movieObserver);
    }

    public boolean removeMovieObserver(MovieObserver movieObserver) {
        return movieObservers.remove(movieObserver);
    }

    public void notifyMovieObservers(String message) throws RemoteException {
        for (MovieObserver movieObserver : movieObservers) {
            new Thread() {
                public void run() {
                    try {
                        movieObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
