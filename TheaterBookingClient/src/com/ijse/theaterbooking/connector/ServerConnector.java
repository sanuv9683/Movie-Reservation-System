/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.connector;

import com.ijse.theaterbooking.controller.BookController;
import com.ijse.theaterbooking.controller.BookDetailsController;
import com.ijse.theaterbooking.controller.BoxSeatsController;
import com.ijse.theaterbooking.controller.GoldClassController;
import com.ijse.theaterbooking.controller.MovieController;
import com.ijse.theaterbooking.controller.ODCController;
import com.ijse.theaterbooking.controller.Savoy3DFactory;
import com.ijse.theaterbooking.controller.UserController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Sanu Vithanage
 */
public class ServerConnector {

    private static ServerConnector serverConnector;
    private Savoy3DFactory savoy3DFactory;
    private UserController userController;
    private MovieController movieController;
    private ODCController oDCController;
    private GoldClassController goldClassController;
    private BoxSeatsController boxSeatsController;
    private BookController bookController;
    private BookDetailsController bookDetailsController;

    public ServerConnector() throws NotBoundException, MalformedURLException, RemoteException, ClassCastException {
        savoy3DFactory = (Savoy3DFactory) Naming.lookup("rmi://localhost:5050/Savoy3DServer");
    }

    public UserController getUserController() throws RemoteException {
        if (userController == null) {
            userController = savoy3DFactory.getUserController();
        }
        return userController;
    }

    public MovieController getMovieController() throws RemoteException {
        if (movieController == null) {
            movieController = savoy3DFactory.getMovieController();
        }
        return movieController;
    }

    public ODCController getODCController() throws RemoteException {
        if (oDCController == null) {
            oDCController = savoy3DFactory.getODCController();
        }
        return oDCController;
    }

    public GoldClassController getGoldClassController() throws RemoteException {
        if (goldClassController == null) {
            goldClassController = savoy3DFactory.getGoldClassController();
        }
        return goldClassController;
    }

    public BoxSeatsController getBoxSeatsController() throws RemoteException {
        if (boxSeatsController == null) {
            boxSeatsController = savoy3DFactory.getBoxSeatsController();
        }
        return boxSeatsController;
    }

    public BookController getBookController() throws RemoteException {
        if (bookController == null) {
            bookController = savoy3DFactory.getBookController();
        }
        return bookController;
    }

    public BookDetailsController getBookDetailsController() throws RemoteException {
        if (bookDetailsController == null) {
            bookDetailsController = savoy3DFactory.getBookDetailsController();
        }
        return bookDetailsController;
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }

}
