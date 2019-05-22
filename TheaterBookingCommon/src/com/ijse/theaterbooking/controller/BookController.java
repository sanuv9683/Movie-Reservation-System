/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.Book;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.observer.BookObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface BookController extends Remote {

    public boolean addBooking(Book book, ArrayList<BookDetails> bookDetail) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean deleteBooking(String bookId) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public Book getBooking(String bookId) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateBooking(Book book, ArrayList<BookDetails> bookDetail) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addBookObserver(BookObserver bookObserver) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeBookObserver(BookObserver bookObserver) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveMov1(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseMov1(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveMov2(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseMov2(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveMov3(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseMov3(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveMov4(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseMov4(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<Book> getAllBookings() throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

}
