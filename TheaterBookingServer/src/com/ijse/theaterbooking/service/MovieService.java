/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.service;

import com.ijse.theaterbooking.fileaccses.*;
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
import com.ijse.theaterbooking.model.Movies;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class MovieService {

    private FileAccessFactory fileAccessFactory = new FileAccessFactoryImpl();

    public boolean addMovie(Movies movies) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getMovieFileAccses().addMovie(movies);
    }

    public Movies searcMovie(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getMovieFileAccses().searcMovie(id);
    }

    public boolean deleteMovie(String id) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getMovieFileAccses().deleteMovie(id);
    }

    public boolean updateMovie(Movies movie) throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getMovieFileAccses().updateMovie(movie);
    }

    public ArrayList<Movies> getAllMovies() throws IOException, FileNotFoundException, ParseException, NotBoundException, RemoteException, ClassNotFoundException, SQLException {
        return fileAccessFactory.getMovieFileAccses().getAllMovies();
    }

}
