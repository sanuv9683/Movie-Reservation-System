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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.theaterbooking.model.Users;
import com.ijse.theaterbooking.observable.UserObservable;
import java.rmi.NotBoundException;
import java.sql.SQLException;

/**
 *
 * @author Sanu Vithanage
 */
public class UserService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();
  

    public boolean addUser(Users users) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {

        return fileAccessFactory.getUserFileAccses().addUser(users);

    }

    public Users checkUsername(String uName) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().checkUsername(uName);
    }

    public boolean deleteUser(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().deleteUser(id);
    }

    public boolean updateUser(Users users) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().updateUser(users);
    }

    public ArrayList<Users> getAllUsers() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().getAllUsers();
    }

    public boolean checkRegisteredUser(String uName, String password) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().checkRegisteredUser(uName, password);
    }

    public Users searchUser(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getUserFileAccses().searchUser(id);
    }

}
