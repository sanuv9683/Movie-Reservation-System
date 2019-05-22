/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.reservation;

import com.ijse.theaterbooking.controller.GoldClassController;
import java.util.HashMap;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassReserver {
      private HashMap<String, GoldClassController> reserveData = new HashMap<>();

    public boolean reserveGoldClass(String id, GoldClassController 
            goldClassController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == goldClassController) {
                return true;
            } else {
                return false;
            }

        } else {
            reserveData.put(id, goldClassController);
            return true;
        }

    }

    public boolean releaseGoldClass(String id, GoldClassController 
            goldClassController) {
        if (reserveData.get(id) == goldClassController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
