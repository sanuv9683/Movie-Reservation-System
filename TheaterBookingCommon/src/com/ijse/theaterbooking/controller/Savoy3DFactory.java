/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sanu Vithanage
 */
public interface Savoy3DFactory extends Remote {

    public UserController getUserController() throws RemoteException;

    public MovieController getMovieController() throws RemoteException;

    public BookController getBookController() throws RemoteException;

    public BookDetailsController getBookDetailsController() throws RemoteException;

    public BoxSeatsController getBoxSeatsController() throws RemoteException;

    public GoldClassController getGoldClassController() throws RemoteException;

    public ODCController getODCController() throws RemoteException;

}
