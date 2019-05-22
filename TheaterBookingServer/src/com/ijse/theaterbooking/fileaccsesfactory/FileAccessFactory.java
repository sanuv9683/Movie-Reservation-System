/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccsesfactory;

import com.ijse.theaterbooking.fileaccses.BookDetailsFileAccses;
import com.ijse.theaterbooking.fileaccses.BookFileAccses;
import com.ijse.theaterbooking.fileaccses.BoxFileAccses;
import com.ijse.theaterbooking.fileaccses.GoldClassFileAccses;
import com.ijse.theaterbooking.fileaccses.MovieFileAccses;
import com.ijse.theaterbooking.fileaccses.ODCFileAccses;
import com.ijse.theaterbooking.fileaccses.UserFileAccses;
import java.rmi.RemoteException;

/**
 *
 * @author Sanu Vithanage
 */
public interface FileAccessFactory {

    public BookDetailsFileAccses getBookDetailsFileAccses() throws RemoteException;

    public BookFileAccses getBookFileAccses() throws RemoteException;

    public BoxFileAccses getBoxFileAccses() throws RemoteException;

    public GoldClassFileAccses getGoldClassFileAccses() throws RemoteException;

    public MovieFileAccses getMovieFileAccses() throws RemoteException;

    public ODCFileAccses getODCFileAccses() throws RemoteException;

    public UserFileAccses getUserFileAccses() throws RemoteException;
}
