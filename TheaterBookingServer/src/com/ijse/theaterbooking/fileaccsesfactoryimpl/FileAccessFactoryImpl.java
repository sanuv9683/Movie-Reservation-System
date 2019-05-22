/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccsesfactoryimpl;

import com.ijse.theaterbooking.fileaccses.BookDetailsFileAccses;
import com.ijse.theaterbooking.fileaccses.BookFileAccses;
import com.ijse.theaterbooking.fileaccses.BoxFileAccses;
import com.ijse.theaterbooking.fileaccses.GoldClassFileAccses;
import com.ijse.theaterbooking.fileaccses.MovieFileAccses;
import com.ijse.theaterbooking.fileaccses.ODCFileAccses;
import com.ijse.theaterbooking.fileaccses.UserFileAccses;
import com.ijse.theaterbooking.fileaccsesfactory.FileAccessFactory;
import java.rmi.RemoteException;

/**
 *
 * @author Sanu Vithanage
 */
public class FileAccessFactoryImpl implements FileAccessFactory {

    @Override
    public BookDetailsFileAccses getBookDetailsFileAccses() throws RemoteException {
        return new BookDetailsFileAccses();
    }

    @Override
    public BookFileAccses getBookFileAccses() throws RemoteException {
        return new BookFileAccses();
    }

    @Override
    public BoxFileAccses getBoxFileAccses() throws RemoteException {
        return new BoxFileAccses();
    }

    @Override
    public GoldClassFileAccses getGoldClassFileAccses() throws RemoteException {
        return new GoldClassFileAccses();
    }

    @Override
    public MovieFileAccses getMovieFileAccses() throws RemoteException {
        return new MovieFileAccses();
    }

    @Override
    public ODCFileAccses getODCFileAccses() throws RemoteException {
        return new ODCFileAccses();
    }

    @Override
    public UserFileAccses getUserFileAccses() throws RemoteException {
        return new UserFileAccses();
    }

}
