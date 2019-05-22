/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccses;

import com.ijse.theaterbooking.controllerimpl.UserControllerImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.theaterbooking.model.BoxSeat;
import com.ijse.theaterbooking.model.ODC;
import com.ijse.theaterbooking.model.Users;

/**
 *
 * @author Sanu Vithanage
 */
public class ODCFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/file/ODC.txt");
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addODC(ODC odc) throws IOException, FileNotFoundException, ParseException {
        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            String data = "";
            data += odc.getNoOfODCSeats() + "#";
            data += odc.getHalfODCPrice() + "#";
            data += odc.getFullODCPrice() + "#";
            data += odc.getODCId();

            BufferedWriter bufferedWriter = null;
            try {

                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(data);

                bufferedWriter.newLine();
                return isOdcAvailable(odc.getODCId());
            } finally {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public boolean checkODC(String seat) throws RemoteException {

        try {
            readWriteLock.readLock().lock();

            return false;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ODC searchODC(String id) throws RemoteException, FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            ODC odc = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[1].equals(id)) {
                        odc = new ODC();
                        odc.setNoOfODCSeats(Integer.parseInt(data[0]));
                        odc.setODCId(data[1]);
                        odc.setFullODCPrice(Double.parseDouble(data[2]));
                        odc.setHalfODCPrice(Double.parseDouble(data[3]));

                    }
                }
                return odc;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteODC(String id) throws RemoteException, FileNotFoundException, IOException, ParseException {
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
                    if (!data[0].equals(id)) {
                        fileData.add(line);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isOdcAvailable(id);
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

    public boolean updateODC(ODC odc) throws RemoteException, IOException, FileNotFoundException, ParseException {

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
                    if (!data[0].equals(odc.getODCId())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += odc.getODCId() + "#";
                        updLine += odc.getFullODCPrice() + "#";
                        updLine += odc.getHalfODCPrice() + "#";
                        updLine += odc.getNoOfODCSeats();
                        fileData.add(updLine);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isOdcAvailable(odc.getODCId());
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

    public ArrayList<ODC> getAllODCSeats() throws RemoteException, FileNotFoundException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<ODC> odc = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    ODC od = new ODC();
                    od.setNoOfODCSeats(Integer.parseInt(data[0]));
                    od.setODCId((String) data[1]);
                    od.setFullODCPrice(Double.parseDouble(data[2]));
                    od.setHalfODCPrice(Double.parseDouble(data[3]));
                    odc.add(od);
                }
                return (ArrayList<ODC>) odc;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    private boolean isOdcAvailable(String odcId) throws IOException, FileNotFoundException, ParseException {
        ODC odc = searchODC(odcId);
        return odc == null;
    }
}
