/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.observerimpl;

import com.ijse.theaterbooking.observer.GoldClassObserver;
import com.ijse.theaterbooking.view.GoldClassBook;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassObserverImpl extends UnicastRemoteObject implements GoldClassObserver{
     private com.ijse.theaterbooking.view.GoldClassBook goldclss;

     public GoldClassObserverImpl(GoldClassBook goldclss)throws RemoteException{
     this.goldclss=goldclss;
     }
     
    @Override
    public void update(String message) throws RemoteException {
         try {
             goldclss.setMessgae(message);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GoldClassObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(GoldClassObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(GoldClassObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(GoldClassObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NotBoundException ex) {
             Logger.getLogger(GoldClassObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     
     
    
}
