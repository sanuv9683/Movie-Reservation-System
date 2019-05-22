/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.reservation;

import com.ijse.theaterbooking.controller.BookController;
import java.util.HashMap;

/**
 *
 * @author Sanu Vithanage
 */
public class BookReserver {

    private HashMap<String, BookController> reserveMovie1 = new HashMap<>();
    private HashMap<String, BookController> reserveMovie2 = new HashMap<>();
    private HashMap<String, BookController> reserveMovie3 = new HashMap<>();
    private HashMap<String, BookController> reserveMovie4 = new HashMap<>();

    public boolean reserveMov1(String seat, BookController bookController) {
        if (reserveMovie1.containsKey(seat)) {
            if (reserveMovie1.get(seat) == bookController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveMovie1.put(seat, bookController);
            return true;
        }

    }

    public boolean releaseMov1(String seat, BookController bookController) {
        if (reserveMovie1.get(seat) == bookController) {
            reserveMovie1.remove(seat);
            return true;
        } else {
            return false;
        }
    }

    public boolean reserveMov2(String seat, BookController bookController) {
        if (reserveMovie2.containsKey(seat)) {
            if (reserveMovie2.get(seat) == bookController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveMovie2.put(seat, bookController);
            return true;
        }

    }

    public boolean releaseMov2(String seat, BookController bookController) {
        if (reserveMovie2.get(seat) == bookController) {
            reserveMovie2.remove(seat);
            return true;
        } else {
            return false;
        }
    }

    public boolean reserveMov3(String seat, BookController bookController) {
        if (reserveMovie3.containsKey(seat)) {
            if (reserveMovie3.get(seat) == bookController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveMovie3.put(seat, bookController);
            return true;
        }

    }

    public boolean releaseMov3(String seat, BookController bookController) {
        if (reserveMovie3.get(seat) == bookController) {
            reserveMovie3.remove(seat);
            return true;
        } else {
            return false;
        }
    }

    public boolean reserveMov4(String seat, BookController bookController) {
        if (reserveMovie4.containsKey(seat)) {
            if (reserveMovie4.get(seat) == bookController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveMovie4.put(seat, bookController);
            return true;
        }

    }

    public boolean releaseMov4(String seat, BookController bookController) {
        if (reserveMovie4.get(seat) == bookController) {
            reserveMovie4.remove(seat);
            return true;
        } else {
            return false;
        }
    }
}
