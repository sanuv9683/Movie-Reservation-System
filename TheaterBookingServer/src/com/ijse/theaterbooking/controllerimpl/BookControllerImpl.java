/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.controllerimpl;

import com.ijse.theaterbooking.controller.BookController;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.theaterbooking.model.Book;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.observable.BookObservable;
import com.ijse.theaterbooking.observer.BookObserver;
import com.ijse.theaterbooking.reservation.BookReserver;
import com.ijse.theaterbooking.servicefactory.ServiceFactory;
import com.ijse.theaterbooking.servicefactoryimpl.ServiceFactoryImpl;
import java.io.FileNotFoundException;
import java.rmi.NotBoundException;

/**
 *
 * @author Sanu Vithanage
 */
public class BookControllerImpl extends UnicastRemoteObject implements
        BookController {

    private static BookObservable bookObservable = new BookObservable();
    private ServiceFactory serviceFactory = new ServiceFactoryImpl();
    private static BookReserver bookReserver = new BookReserver();

    public BookControllerImpl() throws RemoteException {

    }

    @Override
    public Book getBooking(String bookId) throws RemoteException,
            ClassNotFoundException, IOException, FileNotFoundException, 
            ParseException, NotBoundException, SQLException {
        return serviceFactory.getBookService().searchBooking(bookId);
    }

    @Override
    public void addBookObserver(BookObserver bookObserver) throws RemoteException,
            ClassNotFoundException {
        bookObservable.addBookObserver(bookObserver);
    }

    @Override
    public void removeBookObserver(BookObserver bookObserver) throws
            RemoteException, ClassNotFoundException {
        bookObservable.removeBookObserver(bookObserver);
    }

    @Override
    public ArrayList<Book> getAllBookings() throws RemoteException, 
            ClassNotFoundException, IOException, FileNotFoundException,
            ParseException, NotBoundException, SQLException {
        return serviceFactory.getBookService().getBookings();

    }
    private String sheetId;
    private String movieId;

    @Override
    public boolean addBooking(Book book, ArrayList<BookDetails> bookDetail)
            throws RemoteException, ClassNotFoundException, 
            FileNotFoundException, NotBoundException {

        for (BookDetails bookDetail1s : bookDetail) {
            sheetId = bookDetail1s.getSheetId();
            movieId = bookDetail1s.getMovieId();

        }

        if (movieId.equals("mov1")) {

            if (bookReserver.reserveMov1(sheetId, this)) {
                try {
                    if (serviceFactory.getBookService().addBooking(book,
                            bookDetail)) {
                        bookObservable.notifyBookObservers("Seat " + sheetId + 
                                " is Booked");
                        return true;

                    }
                    return false;
                } catch (SQLException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } else {
                return false;
            }
        }
        if (movieId.equals("mov2")) {
            if (bookReserver.reserveMov2(sheetId, this)) {
                try {
                    if (serviceFactory.getBookService().addBooking(book,
                            bookDetail)) {
                        bookObservable.notifyBookObservers("Seat " + sheetId +
                                " is Booked");
                        return true;
                    }
                    return false;
                } catch (SQLException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            } else {
                return false;
            }
        }

        if (movieId.equals("mov3")) {
            if (bookReserver.reserveMov3(sheetId, this)) {
                try {
                    if (serviceFactory.getBookService().addBooking(book, 
                            bookDetail)) {
                        bookObservable.notifyBookObservers("Seat " + sheetId + 
                                " is Booked");
                        return true;
                    }
                    return false;
                } catch (SQLException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName())
                            .log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } else {
                return false;
            }
        }

        if (movieId.equals("mov4")) {
            if (bookReserver.reserveMov4(sheetId, this)) {
                try {
                    if (serviceFactory.getBookService().addBooking(book, bookDetail)) {
                        bookObservable.notifyBookObservers("Seat " + sheetId + " is Booked");
                        return true;
                    }
                    return false;
                } catch (SQLException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean updateBooking(Book book, ArrayList<BookDetails> bookDetail) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        if (serviceFactory.getBookService().updateBooking(book, bookDetail)) {
            bookObservable.notifyBookObservers("Booking " + book.getBookId() + " is Updated");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBooking(String bookId) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        if (serviceFactory.getBookService().deleteBooking(bookId)) {
            bookObservable.notifyBookObservers("Booking " + bookId + " is Removed");
            return true;
        }
        return false;

    }

    @Override
    public boolean reserveMov1(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.reserveMov1(seat, this);
    }

    @Override
    public boolean releaseMov1(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.releaseMov1(seat, this);
    }

    @Override
    public boolean reserveMov2(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.reserveMov2(seat, this);
    }

    @Override
    public boolean releaseMov2(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.releaseMov2(seat, this);
    }

    @Override
    public boolean reserveMov3(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.reserveMov3(seat, this);
    }

    @Override
    public boolean releaseMov3(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.releaseMov3(seat, this);
    }

    @Override
    public boolean reserveMov4(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.reserveMov4(seat, this);
    }

    @Override
    public boolean releaseMov4(String seat) throws RemoteException, ClassNotFoundException, FileNotFoundException, SQLException, IOException, ParseException, NotBoundException {
        return bookReserver.releaseMov4(seat, this);
    }
}
