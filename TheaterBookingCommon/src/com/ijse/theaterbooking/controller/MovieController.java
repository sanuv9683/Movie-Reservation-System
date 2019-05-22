/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import com.ijse.theaterbooking.model.Movies;
import com.ijse.theaterbooking.observer.MovieObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Sanu Vithanage
 */
public interface MovieController extends Remote {

    public boolean addMovie(Movies movies) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean updateMovieDetils(Movies movies) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public Movies searchMovie(String movieName)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean deleteMovie(String movieName) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void addMovieObserver(MovieObserver movieObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void removeMovieObserver(MovieObserver movieObserver) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean reserveMovie(String id)throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public boolean releaseMovie(String id) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public void setMessage(String message) throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

    public ArrayList<Movies> getAllMovies() throws RemoteException, ClassNotFoundException,FileNotFoundException, SQLException, IOException, ParseException, NotBoundException;

}
