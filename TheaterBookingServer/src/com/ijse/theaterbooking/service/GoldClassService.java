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
import com.ijse.theaterbooking.model.GoldClass;
import com.ijse.theaterbooking.model.ODC;
import com.ijse.theaterbooking.model.Users;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addGoldClass(GoldClass goldClass) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getGoldClassFileAccses().addGoldClass(goldClass);
    }

    public GoldClass searchGoldClassSeat(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getGoldClassFileAccses().searchGoldClassSeat(id);
    }

    public boolean deleteGoldClass(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getGoldClassFileAccses().deleteGoldClass(id);
    }

    public boolean updateGoldClass(GoldClass goldClass) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getGoldClassFileAccses().updateGoldClass(goldClass);

    }

    public ArrayList<GoldClass> getAllGoldClasses() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getGoldClassFileAccses().getAllGoldClasses();
    }

}
