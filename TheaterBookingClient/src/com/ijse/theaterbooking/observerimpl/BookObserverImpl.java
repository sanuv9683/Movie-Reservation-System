/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.observerimpl;

import com.ijse.theaterbooking.observer.BookObserver;
import com.ijse.theaterbooking.observer.UserObserver;
import com.ijse.theaterbooking.view.FirstMovieView;
import com.ijse.theaterbooking.view.GoldClassBook;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanu Vithanage
 */
public class BookObserverImpl extends UnicastRemoteObject implements BookObserver {

    com.ijse.theaterbooking.view.GoldClassBook GoldClassBook;

    public BookObserverImpl(GoldClassBook GoldClassBook) throws RemoteException {
        this.GoldClassBook = GoldClassBook;
    }

    @Override
    public void update(String message) throws RemoteException {
        try {
            GoldClassBook.setMessgae(message);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BookObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(BookObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
