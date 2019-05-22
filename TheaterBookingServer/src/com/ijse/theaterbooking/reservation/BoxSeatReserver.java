/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.reservation;

import com.ijse.theaterbooking.controller.BoxSeatsController;
import com.ijse.theaterbooking.controller.UserController;
import java.util.HashMap;

/**
 *
 * @author Sanu Vithanage
 */
public class BoxSeatReserver {
      private HashMap<String, BoxSeatsController> reserveData = new HashMap<>();

    public boolean reserveBoxSeat(String id, BoxSeatsController boxSeatController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == boxSeatController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, boxSeatController);
            return true;
        }

    }

    public boolean releaseBoxSeat(String id, BoxSeatsController boxSeatController) {
        if (reserveData.get(id) == boxSeatController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
