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
import com.ijse.theaterbooking.model.Users;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Sanu Vithanage
 */
public class UserFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/"
            + "file/Users.txt");

    private final static ReentrantReadWriteLock readWriteLock = new 
        ReentrantReadWriteLock();

    public boolean addUser(Users users) throws IOException,
            FileNotFoundException, ParseException {
        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            String data = "";
            data += users.getUserName() + "#";
            data += users.getUserID() + "#";
            data += users.getUserEmail() + "#";
            data += users.getUserTPNo() + "#";
            data += users.getUserBday() + "#";
            data += users.getuPassWord();

            BufferedWriter bufferedWriter = null;
            try {

                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(data);

                bufferedWriter.newLine();
                return isUserAvailable(users.getUserID());
            } finally {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public Users checkUsername(String uName) throws RemoteException,
            FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            Users user = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[0].equals(uName)) {
                        user = new Users();
                        user.setUserName(data[0]);
                        user.setUserID(data[1]);
                        user.setUserEmail(data[2]);
                        user.setUserTPNo(data[3]);
                        user.setUserBday(data[4]);
                        user.setuPassWord(data[5]);
                    }
                }
                return user;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteUser(String id) throws RemoteException, 
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
                    if (!data[1].equals(id)) {
                        fileData.add(line);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isUserAvailable(id);
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

    public boolean updateUser(Users users) throws RemoteException,
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
                    if (!data[1].equals(users.getUserID())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += users.getUserName() + "#";
                        updLine += users.getUserID() + "#";
                        updLine += users.getUserEmail() + "#";
                        updLine += users.getUserTPNo() + "#";
                        updLine += users.getUserBday() + "#";
                        updLine += users.getuPassWord();
                        fileData.add(updLine);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isUserAvailable(users.getUserID());
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

    public ArrayList<Users> getAllUsers() throws RemoteException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<Users> user = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    Users usr = new Users();
                    usr.setUserName(data[0]);
                    usr.setUserID(data[1]);
                    usr.setUserEmail(data[2]);
                    usr.setUserTPNo(data[3]);
                    usr.setUserBday(data[4]);
                    usr.setuPassWord(data[5]);
                    user.add(usr);
                }
                return (ArrayList<Users>) user;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean checkRegisteredUser(String uName, String password) throws 
            RemoteException, FileNotFoundException, IOException {
        BufferedReader reader = null;
        Users user = null;

        FileReader fileReader = new FileReader(file);
        reader = new BufferedReader(fileReader);
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("#");
            if (data[0].equals(uName) & data[5].equals(password)) {
                return true;
            }
        }
        return false;

    }

    public Users searchUser(String id) throws RemoteException,
            FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            Users user = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[1].equals(id)) {
                        user = new Users();
                        user.setUserName(data[0]);
                        user.setUserID(data[1]);
                        user.setUserEmail(data[2]);
                        user.setUserTPNo(data[3]);
                        user.setUserBday(data[4]);
                        user.setuPassWord(data[5]);
                    }
                }
                return user;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isUserAvailable(String userID) throws IOException, 
            FileNotFoundException, ParseException {
        Users users = searchUser(userID);
        return users == null;
    }

}
