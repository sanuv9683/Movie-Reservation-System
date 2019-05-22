/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.BookDetails;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface BookDetailsController extends Remote {

    public ArrayList<BookDetails> getBookDetail(String orderId) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<BookDetails> getAllBookDetail() throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean checkFile() throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public BookDetails searchBookDetail(String id) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;
    
    public ArrayList<BookDetails> searchFromDate(String movieID,String dateID,String seatID) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;
}
