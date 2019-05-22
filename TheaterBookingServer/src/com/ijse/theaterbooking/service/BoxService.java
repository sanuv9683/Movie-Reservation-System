/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.service;

import com.ijse.theaterbooking.fileaccses.*;
import com.ijse.theaterbooking.fileaccsesfactory.FileAccessFactory;
import com.ijse.theaterbooking.fileaccsesfactoryimpl.FileAccessFactoryImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.model.Users;
import java.rmi.NotBoundException;
import java.sql.SQLException;

/**
 *
 * @author Sanu Vithanage
 */
public class BoxService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addBoxSeat(BoxSeat boxSeat) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBoxFileAccses().addBoxSeat(boxSeat);
    }

    public BoxSeat searchBoxSeat(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBoxFileAccses().searchBoxSeat(id);
    }

    public boolean deleteBoxSeat(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBoxFileAccses().deleteBoxSeat(id);
    }

    public boolean updateBoxSeat(BoxSeat boxSeat) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBoxFileAccses().updateBoxSeat(boxSeat);
    }

    public ArrayList<BoxSeat> getAllBoxSeats() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getBoxFileAccses().getAllBoxSeats();
    }

}
