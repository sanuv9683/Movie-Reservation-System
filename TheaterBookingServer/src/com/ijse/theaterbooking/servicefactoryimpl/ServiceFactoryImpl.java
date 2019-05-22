/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.servicefactoryimpl;

import com.ijse.theaterbooking.service.BookDetailsService;
import com.ijse.theaterbooking.service.BookService;
import com.ijse.theaterbooking.service.BoxService;
import com.ijse.theaterbooking.service.GoldClassService;
import com.ijse.theaterbooking.service.MovieService;
import com.ijse.theaterbooking.service.ODCService;
import com.ijse.theaterbooking.service.UserService;
import com.ijse.theaterbooking.servicefactory.ServiceFactory;

/**
 *
 * @author Sanu Vithanage
 */
public class ServiceFactoryImpl implements ServiceFactory {

    @Override
    public UserService getUserService() {
        return new UserService();
    }

    @Override
    public MovieService getMovieService() {
        return new MovieService();
    }

    @Override
    public BookService getBookService() {
        return new BookService();

    }

    @Override
    public BookDetailsService getBookDetailsService() {
        return new BookDetailsService();
    }

    @Override
    public BoxService getBoxSeatsService() {
        return new BoxService();
    }

    @Override
    public GoldClassService getGoldClassService() {
        return new GoldClassService();
    }

    @Override
    public ODCService getODCService() {
        return new ODCService();
    }

}
