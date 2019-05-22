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
import com.ijse.theaterbooking.model.GoldClass;

/**
 *
 * @author Sanu Vithanage
 */
public class GoldClassFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/file/GoldClassSeats.txt");
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addGoldClass(GoldClass goldClass) throws IOException, FileNotFoundException, ParseException {
        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            String data = "";
            data += goldClass.getGoldClassId() + "#";
            data += goldClass.getFullPriceGC() + "#";
            data += goldClass.getHalfPriceGC() + "#";
            data += goldClass.getNoOfGoldClassSeats();

            BufferedWriter bufferedWriter = null;
            try {

                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(data);

                bufferedWriter.newLine();
                return isGoldClassAvailable(goldClass.getGoldClassId());
            } finally {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public GoldClass searchGoldClassSeat(String id) throws RemoteException {
        try {
            readWriteLock.readLock().lock();

            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteGoldClass(String id) throws RemoteException {
        try {
            readWriteLock.writeLock().lock();

            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public boolean updateGoldClass(GoldClass goldClass) throws RemoteException, IOException, FileNotFoundException, ParseException {

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
                    if (!data[0].equals(goldClass.getGoldClassId())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += goldClass.getGoldClassId() + "#";
                        updLine += goldClass.getFullPriceGC() + "#";
                        updLine += goldClass.getHalfPriceGC() + "#";
                        updLine += goldClass.getNoOfGoldClassSeats();
                        fileData.add(updLine);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isGoldClassAvailable(goldClass.getGoldClassId());
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

    public ArrayList<GoldClass> getAllGoldClasses() throws RemoteException {
        try {
            readWriteLock.readLock().lock();

            return null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isGoldClassAvailable(String goldClassId) throws IOException, FileNotFoundException, ParseException {
        GoldClass goldClass = searchGoldClassSeat(goldClassId);
        return goldClass == null;
    }
}
