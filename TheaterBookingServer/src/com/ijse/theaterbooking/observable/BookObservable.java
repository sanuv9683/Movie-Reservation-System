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
import com.ijse.theaterbooking.observer.BookObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class BookObservable {
      private ArrayList<BookObserver> bookObservers = new ArrayList<>();

    public boolean addBookObserver(BookObserver bookObserver) {
        return bookObservers.add(bookObserver);
    }

    public boolean removeBookObserver(BookObserver bookObserver) {
        return bookObservers.remove(bookObserver);
    }

    public void notifyBookObservers(String message) throws RemoteException {
        for (BookObserver bookObserver : bookObservers) {
            new Thread() {
                public void run() {
                    try {
                        bookObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
