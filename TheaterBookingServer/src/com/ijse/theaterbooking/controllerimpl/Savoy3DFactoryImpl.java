/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.BookController;
import com.ijse.theaterbooking.controller.BookDetailsController;
import com.ijse.theaterbooking.controller.BoxSeatsController;
import com.ijse.theaterbooking.controller.GoldClassController;
import com.ijse.theaterbooking.controller.MovieController;
import com.ijse.theaterbooking.controller.ODCController;
import com.ijse.theaterbooking.controller.Savoy3DFactory;
import com.ijse.theaterbooking.controller.UserController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Sanu Vithanage
 */
public class Savoy3DFactoryImpl extends UnicastRemoteObject implements Savoy3DFactory {

    public Savoy3DFactoryImpl() throws RemoteException {

    }

    @Override
    public UserController getUserController() throws RemoteException {
        return new UserControllerImpl();

    }

    @Override
    public MovieController getMovieController() throws RemoteException {
        return new MovieControllerImpl();
        //return (MovieController) new MovieControllerImpl();
    }

    @Override
    public BookController getBookController() throws RemoteException {
        return new BookControllerImpl();
    }

    @Override
    public BookDetailsController getBookDetailsController() throws RemoteException {
        return new BookDetailsControllerImpl();
    }

    @Override
    public BoxSeatsController getBoxSeatsController() throws RemoteException {
        return new BoxControllerImpl();
    }

    @Override
    public GoldClassController getGoldClassController() throws RemoteException {
        return new GoldClassControllerImpl();
    }

    @Override
    public ODCController getODCController() throws RemoteException {
        return new ODCControllerImpl();
    }

}
