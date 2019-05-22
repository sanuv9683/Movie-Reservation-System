/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.service;

import com.ijse.theaterbooking.fileaccses.*;
import com.ijse.theaterbooking.fileaccsesfactory.FileAccessFactory;
import com.ijse.theaterbooking.fileaccsesfactoryimpl.FileAccessFactoryImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.model.Users;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class BookDetailsService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addBookDetails(ArrayList<BookDetails> bookDetails) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().addBookDetails(bookDetails);
    }

    public boolean checkBookDetails(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().checkBookDetails(id);
    }

    public BookDetails searchBookDetails(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().searchBookDetails(id);
    }

    public boolean deleteBookDetails(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().deleteBookDetails(id);
    }

    public boolean updateBookDetails(Users users) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().updateBookDetails(users);
    }

    public ArrayList<BookDetails> getAllBookDetails() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().getAllBookDetails();
    }

    public ArrayList<BookDetails> getBookDetail(String orderId) throws RemoteException, ClassNotFoundException, IOException, FileNotFoundException, ParseException, NotBoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().getBookDetail(orderId);
    }

    public boolean checkFile() throws RemoteException, ClassNotFoundException, IOException, FileNotFoundException, ParseException, NotBoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().checkFile();
    }

    public ArrayList<BookDetails> searchFromDate(String movieID, String dateID, String seatID) throws RemoteException, ClassNotFoundException, IOException, FileNotFoundException, ParseException, NotBoundException, SQLException {
        return fileAccessFactory.getBookDetailsFileAccses().searchFromDate(movieID, dateID, seatID);
    }

}
