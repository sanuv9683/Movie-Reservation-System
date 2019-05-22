/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.reservation;

import com.ijse.theaterbooking.controller.BoxSeatsController;
import com.ijse.theaterbooking.controller.ODCController;
import com.ijse.theaterbooking.controller.UserController;
import java.util.HashMap;

/**
 *
 * @author Sanu Vithanage
 */
public class ODCSeatsReserver {
      private HashMap<String, ODCController> reserveData = new HashMap<>();

    public boolean reserveODCSeat(String id, ODCController oDCController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == oDCController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, oDCController);
            return true;
        }

    }

    public boolean releaseODCSeat(String id, ODCController oDCController) {
        if (reserveData.get(id) == oDCController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
