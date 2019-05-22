/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.UserController;
import com.ijse.theaterbooking.fileaccses.UserFileAccses;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.theaterbooking.model.Users;
import com.ijse.theaterbooking.observable.UserObservable;
import com.ijse.theaterbooking.observer.UserObserver;
import com.ijse.theaterbooking.reservation.UserRerserver;
import com.ijse.theaterbooking.servicefactory.ServiceFactory;
import com.ijse.theaterbooking.servicefactoryimpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.sql.SQLException;

/**
 *
 * @author Sanu Vithanage
 */
public class UserControllerImpl extends UnicastRemoteObject implements
        UserController {
    
    private static UserObservable userObservable = new UserObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static UserRerserver userRerserver = new UserRerserver();
    
    public UserControllerImpl() throws RemoteException {
    }
    
    @Override
    public void setMessage(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addUserObserver(UserObserver userObserver) throws 
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException, 
            SQLException {
        userObservable.addUserObserver(userObserver);
    }
    
    @Override
    public void removeUserObserver(UserObserver userObserver) throws
            RemoteException, IOException, FileNotFoundException,
            ParseException, NotBoundException, ClassNotFoundException, 
            SQLException {
        userObservable.removeUserObserver(userObserver);
    }
    
    @Override
    public boolean checkRegisteredUser(String uName, String password) throws
            RemoteException, IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getUserService().checkRegisteredUser(uName, 
                password);
    }
    
    @Override
    public void setPrivateMessage(String message, String sender, String reciever) 
            throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void userBookingHistory(String loginDateTime, String logoutTime,
            String sender, String reciever, String[] message) throws
            RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Users> getAllUsers() throws RemoteException, IOException,
            FileNotFoundException, ParseException, NotBoundException,
            ClassNotFoundException, SQLException {
        return serviceFactory.getUserService().getAllUsers();
    }
    
    @Override
    public boolean reserveUser(String id) throws RemoteException {
        return userRerserver.reserveUser(id, this);
        
    }
    
    @Override
    public boolean releaseUser(String id) throws RemoteException {
        return userRerserver.releaseUser(id, this);
        
    }
    
    @Override
    public boolean registerUsert(Users user) throws RemoteException,
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        
        boolean res = serviceFactory.getUserService().addUser(user);
        if (res) {
            userObservable.notifyUserObservers(user.getUserName()+ " "
                    + "is Registred");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateUser(Users users) throws RemoteException,
            ClassNotFoundException, IOException, FileNotFoundException, 
            ParseException, NotBoundException, SQLException {
        if (userRerserver.reserveUser(users.getUserID(), this)) {
            if (serviceFactory.getUserService().updateUser(users)) {
                userObservable.notifyUserObservers("User " + users.getUserName()
                        + " Updated");
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public Users searchUser(String uName) throws RemoteException, 
            ClassNotFoundException, IOException, FileNotFoundException,
            ParseException, NotBoundException, SQLException {
        return serviceFactory.getUserService().searchUser(uName);
    }
    
    @Override
    public boolean deleteUser(String id) throws RemoteException, IOException,
            FileNotFoundException, ParseException, NotBoundException,
            ClassNotFoundException, SQLException {
        if (userRerserver.reserveUser(id, this)) {
            if (serviceFactory.getUserService().deleteUser(id)) {
                userObservable.notifyUserObservers("User " + id + " Deleted");
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Users checkUserName(String uName) throws RemoteException, 
            IOException, FileNotFoundException, ParseException,
            NotBoundException, ClassNotFoundException, SQLException {
        return serviceFactory.getUserService().checkUsername(uName);
        
    }
    
}
