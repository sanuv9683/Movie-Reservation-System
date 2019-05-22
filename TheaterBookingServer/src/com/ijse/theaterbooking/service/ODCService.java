/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.service;

import com.ijse.theaterbooking.fileaccses.*;
import com.ijse.theaterbooking.controllerimpl.UserControllerImpl;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.model.ODC;
import com.ijse.theaterbooking.model.Users;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class ODCService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addODC(ODC odc) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().addODC(odc);
    }

    public boolean checkODC(String seat) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().checkODC(seat);
    }

    public ODC searchODC(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().searchODC(id);
    }

    public boolean deleteODC(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().deleteODC(id);
    }

    public boolean updateODC(ODC odc) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().updateODC(odc);
    }

    public ArrayList<ODC> getAllODCSeats() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getODCFileAccses().getAllODCSeats();
    }

}
