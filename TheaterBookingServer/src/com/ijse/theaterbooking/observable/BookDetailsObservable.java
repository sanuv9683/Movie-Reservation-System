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
import com.ijse.theaterbooking.observer.BookDetailsObserver;
import com.ijse.theaterbooking.observer.BookObserver;
import com.ijse.theaterbooking.observer.UserObserver;

/**
 *
 * @author Sanu Vithanage
 */
public class BookDetailsObservable {
     private ArrayList<BookDetailsObserver> bookDetailsObservers = new ArrayList<>();

    public boolean addBookDetailsObserver(BookDetailsObserver bookDetailsObserver) {
        return bookDetailsObservers.add(bookDetailsObserver);
    }

    public boolean removeBookDetailsObserver(BookDetailsObserver bookDetailsObserver) {
        return bookDetailsObservers.remove(bookDetailsObserver);
    }

    public void notifyBookDetailsObservers(String message) throws RemoteException {
        for (BookDetailsObserver bookDetailsObserver : bookDetailsObservers) {
            new Thread() {
                public void run() {
                    try {
                        bookDetailsObserver.update(message);
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
