/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.BookDetailsController;
import com.ijse.theaterbooking.fileaccses.BookDetailsFileAccses;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.observable.BookDetailsObservable;
import com.ijse.theaterbooking.reservation.BookReserver;
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
public class BookDetailsControllerImpl extends UnicastRemoteObject
implements BookDetailsController {

    private static BookDetailsObservable bookDetailsObservable = new 
        BookDetailsObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static BookReserver bookReserver = new BookReserver();

    public BookDetailsControllerImpl() throws RemoteException {

    }

    @Override
    public ArrayList<BookDetails> getBookDetail(String orderId) throws
            RemoteException, ClassNotFoundException, IOException,
            FileNotFoundException, ParseException, NotBoundException, SQLException {
        return serviceFactory.getBookDetailsService().getBookDetail(orderId);
    }

    @Override
    public ArrayList<BookDetails> getAllBookDetail() throws RemoteException,
            ClassNotFoundException, IOException, FileNotFoundException,
            ParseException, NotBoundException, SQLException {
        return serviceFactory.getBookDetailsService().getAllBookDetails();
    }

    @Override
    public boolean checkFile() throws RemoteException, ClassNotFoundException,
            FileNotFoundException, SQLException, IOException, ParseException,
            NotBoundException {
        return serviceFactory.getBookDetailsService().checkFile();
    }

    @Override
    public BookDetails searchBookDetail(String id) throws RemoteException,
            ClassNotFoundException, FileNotFoundException, SQLException,
            IOException, ParseException, NotBoundException {
       return serviceFactory.getBookDetailsService().searchBookDetails(id);
    }

    @Override
    public ArrayList<BookDetails> searchFromDate(String movieID, String dateID,
            String seatID) throws RemoteException, ClassNotFoundException,
            FileNotFoundException, SQLException, IOException, ParseException,
            NotBoundException {
        return serviceFactory.getBookDetailsService().searchFromDate(movieID,
                dateID, seatID);
    }

}
