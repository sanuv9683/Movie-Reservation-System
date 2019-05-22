/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.model.Users;

/**
 *
 * @author Sanu Vithanage
 */
public class BoxFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/"
            + "file/BoxSeats.txt");
    private final static ReentrantReadWriteLock readWriteLock = new 
        ReentrantReadWriteLock();

    public boolean addBoxSeat(BoxSeat boxSeat) throws RemoteException,
            ClassNotFoundException, IOException, FileNotFoundException,
            ParseException {
        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            String data = "";
            data += boxSeat.getNoOFBoxSeats() + "#";
            data += boxSeat.getBoxId() + "#";
            data += boxSeat.getBoxPrice();

            BufferedWriter bufferedWriter = null;
            try {

                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(data);

                bufferedWriter.newLine();
                return isBoxAvailable(boxSeat.getBoxId());
            } finally {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public BoxSeat searchBoxSeat(String id) throws RemoteException {
        try {
            readWriteLock.readLock().lock();

            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteBoxSeat(String id) throws RemoteException {
        try {
            readWriteLock.writeLock().lock();

            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public boolean updateBoxSeat(BoxSeat boxSeat) throws RemoteException, 
            IOException, FileNotFoundException, ParseException {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            readWriteLock.writeLock().lock();

            try {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                List<String> fileData = new ArrayList<>();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (!data[0].equals(boxSeat.getBoxId())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += boxSeat.getBoxId() + "#";
                        updLine += boxSeat.getBoxPrice() + "#";
                        updLine += boxSeat.getNoOFBoxSeats();
                        fileData.add(updLine);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isBoxAvailable(boxSeat.getBoxId());
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public ArrayList<BoxSeat> getAllBoxSeats() throws RemoteException {
        try {
            readWriteLock.readLock().lock();

            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isBoxAvailable(String boxId) throws IOException,
            FileNotFoundException, ParseException {
        BoxSeat boxSeat = searchBoxSeat(boxId);
        return boxSeat == null;
    }

}
