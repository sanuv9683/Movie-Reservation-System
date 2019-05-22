/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.reservation;

import com.ijse.theaterbooking.controller.MovieController;
import com.ijse.theaterbooking.controller.UserController;
import java.util.HashMap;

/**
 *
 * @author Sanu Vithanage
 */
public class MovieReserver {
      private HashMap<String, MovieController> reserveData = new HashMap<>();

    public boolean movieReserve(String id, MovieController movieController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == movieController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, movieController);
            return true;
        }

    }

    public boolean movieRelease(String id, MovieController movieController) {
        if (reserveData.get(id) == movieController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
