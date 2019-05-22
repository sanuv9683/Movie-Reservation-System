/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.observerimpl;

import com.ijse.theaterbooking.view.Loging;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.ijse.theaterbooking.observer.UserObserver;
import com.ijse.theaterbooking.view.UserManager;

/**
 *
 * @author Sanu Vithanage
 */
public class UserObserverImpl extends UnicastRemoteObject implements UserObserver {
    com.ijse.theaterbooking.view.UserManager userManger;
    
    public UserObserverImpl(UserManager userManger)throws RemoteException{
    this.userManger=userManger;
    }

    @Override
    public void update(String message) throws RemoteException {
        userManger.setMassege(message);
    }
    
}
