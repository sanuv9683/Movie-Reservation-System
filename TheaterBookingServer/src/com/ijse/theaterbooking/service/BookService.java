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
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.ijse.theaterbooking.model.Book;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.model.Users;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class BookService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addBooking(Book book, ArrayList<BookDetails> bookDetails) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookFileAccses().addBooking(book, bookDetails);
    }

    public Book searchBooking(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookFileAccses().searchBooking(id);
    }

    public boolean deleteBooking(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookFileAccses().deleteBooking(id);
    }

    public boolean updateBooking(Book book, ArrayList<BookDetails> bookDetail) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookFileAccses().updateBooking(book, bookDetail);

    }

    public ArrayList<Book> getBookings() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBookFileAccses().getBookings();
    }

}
