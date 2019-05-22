/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.servicefactory;


import com.ijse.theaterbooking.service.BookDetailsService;
import com.ijse.theaterbooking.service.BookService;
import com.ijse.theaterbooking.service.BoxService;
import com.ijse.theaterbooking.service.GoldClassService;
import com.ijse.theaterbooking.service.MovieService;
import com.ijse.theaterbooking.service.ODCService;
import com.ijse.theaterbooking.service.UserService;

/**
 *
 * @author Sanu Vithanage
 */
public interface ServiceFactory {

    public UserService getUserService();

    public MovieService getMovieService();

    public BookService getBookService();

    public BookDetailsService getBookDetailsService();

    public BoxService getBoxSeatsService();

    public GoldClassService getGoldClassService();

    public ODCService getODCService();

}
