/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.MovieController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.Movies;
import com.ijse.theaterbooking.observable.MovieObservable;
import com.ijse.theaterbooking.observer.MovieObserver;
import com.ijse.theaterbooking.reservation.MovieReserver;
import com.ijse.theaterbooking.servicefactory.ServiceFactory;
import com.ijse.theaterbooking.servicefactoryimpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public class MovieControllerImpl extends UnicastRemoteObject implements
        MovieController {

    private static MovieObservable movieObservable = new MovieObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static MovieReserver movieReserver = new MovieReserver();

    public MovieControllerImpl() throws RemoteException {

    }

    @Override
    public void addMovieObserver(MovieObserver movieObserver)
            throws RemoteException {
        movieObservable.addMovieObserver(movieObserver);
    }

    @Override
    public void removeMovieObserver(MovieObserver movieObserver)
            throws RemoteException {
        movieObservable.removeMovieObserver(movieObserver);
    }

    @Override
    public boolean reserveMovie(String id) throws RemoteException {
        return movieReserver.movieReserve(id, this);
    }

    @Override
    public boolean releaseMovie(String id) throws RemoteException {
        return movieReserver.movieRelease(id, this);
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Movies> getAllMovies() throws RemoteException, 
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getMovieService().getAllMovies();
    }

    @Override
    public boolean addMovie(Movies movies) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {

        if (serviceFactory.getMovieService().addMovie(movies)) {
            movieObservable.notifyMovieObservers(movies.getMovieName() + 
                    " Aded");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMovieDetils(Movies movies) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException, 
            FileNotFoundException, ParseException, NotBoundException {

        if (movieReserver.movieReserve(movies.getMovieID(), this)) {
            if (serviceFactory.getMovieService().updateMovie(movies)) {
                movieObservable.notifyMovieObservers(movies.getMovieID() 
                        + " is Updated");
                return true;
            }
        }

        return false;

    }

    @Override
    public Movies searchMovie(String movieName) throws RemoteException, 
            ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException, NotBoundException {
        return serviceFactory.getMovieService().searcMovie(movieName);
    }

    @Override
    public boolean deleteMovie(String movieName) throws RemoteException,
            ClassNotFoundException, SQLException, IOException, 
            FileNotFoundException, ParseException, NotBoundException {

        if (serviceFactory.getMovieService().deleteMovie(movieName)) {
            movieObservable.notifyMovieObservers(movieName + " is Deleted");
            return true;
        }

        return false;

    }

}
