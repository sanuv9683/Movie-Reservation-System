/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccses;

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
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.model.Users;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Sanu Vithanage
 */
public class BookDetailsFileAccses {

    private static final File file1 = new File("./src/com/ijse/theaterbooking/"
            + "file/Book.txt");
    private static final File file = new File("./src/com/ijse/theaterbooking/"
            + "file/BookDetails.txt");

    private final static ReentrantReadWriteLock readWriteLock = new 
        ReentrantReadWriteLock();

    public boolean addBookDetails(ArrayList<BookDetails> bookDetails) throws
            RemoteException, ClassNotFoundException, SQLException, IOException,
            FileNotFoundException, ParseException {

        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            for (BookDetails bookDetail : bookDetails) {
                String data2 = "";
                data2 += bookDetail.getBookingId() + "#";
                data2 += bookDetail.getMovieId() + "#";
                data2 += bookDetail.getSheetId() + "#";
                data2 += bookDetail.getPrice() + "#";
                data2 += bookDetail.getbDate() + "#\n";
                BufferedWriter bufferedWriter = null;
                try {

                    FileWriter fileWriter = new FileWriter(file, true);
                    bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(data2);

                    bufferedWriter.newLine();
                    return isBookDetailsAvailable(bookDetail.getBookingId());
                } finally {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }
        return false;

    }

    public boolean checkBookDetails(String id) throws RemoteException {
        FileReader fr;
        boolean b = false;
        try {
            readWriteLock.readLock().lock();

            return false;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public BookDetails searchBookDetails(String id) throws RemoteException, 
            FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            BookDetails bookDetails = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[0].equals(id)) {
                        bookDetails = new BookDetails();
                        bookDetails.setBookingId(data[0]);
                        bookDetails.setMovieId(data[1]);
                        bookDetails.setSheetId(data[2]);
                        bookDetails.setPrice(Double.parseDouble(data[3]));
                        bookDetails.setbDate(data[4]);

                    }
                }
                return bookDetails;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteBookDetails(String id) throws RemoteException {
        try {
            readWriteLock.writeLock().lock();

            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public boolean updateBookDetails(Users users) throws RemoteException {
        try {
            readWriteLock.writeLock().lock();

            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public ArrayList<BookDetails> getAllBookDetails() throws RemoteException, 
            FileNotFoundException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<BookDetails> bookDetailses = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    BookDetails bdt = new BookDetails();
                    bdt.setBookingId(data[0]);
                    bdt.setMovieId(data[1]);
                    bdt.setSheetId(data[2]);
                    bdt.setPrice(Double.parseDouble(data[3]));
                    bdt.setbDate(data[4]);
                    bookDetailses.add(bdt);
                }
                return (ArrayList<BookDetails>) bookDetailses;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public ArrayList<BookDetails> getBookDetail(String orderId) throws
            RemoteException, FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            BookDetails bookDetails = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[1].equals(orderId)) {
                        bookDetails = new BookDetails();
                        bookDetails.setBookingId(data[0]);
                        bookDetails.setMovieId(data[1]);
                        bookDetails.setSheetId(data[2]);
                        bookDetails.setPrice(Double.parseDouble(data[3]));
                        bookDetails.setbDate(data[4]);
                    }
                }
                // return (ArrayList<BookDetails>) bookDetailses;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
        return null;
    }

    public boolean checkFile() throws IOException, FileNotFoundException, 
            ParseException {

        FileWriter fwOb = new FileWriter(file, false);
        FileWriter fwOb1 = new FileWriter(file1, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        pwOb1.flush();
        pwOb1.close();
        fwOb1.close();

        return true;
    }

    private boolean isBookDetailsAvailable(String bookingId) throws 
            IOException, FileNotFoundException, ParseException {
        BookDetails bookDetails = searchBookDetails(bookingId);
        return bookDetails == null;
    }

    public ArrayList<BookDetails> searchFromDate(String movieID, 
            String dateID, String seatID) throws RemoteException,
            FileNotFoundException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<BookDetails> bookDetailses = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[1].equals(movieID) && data[2].equals(seatID) 
                            && data[4].equals(dateID)) {
                        BookDetails bdt = new BookDetails();
                        bdt.setBookingId(data[0]);
                        bdt.setMovieId(data[1]);
                        bdt.setSheetId(data[2]);
                        bdt.setPrice(Double.parseDouble(data[3]));
                        bdt.setbDate(data[4]);
                        bookDetailses.add(bdt);
                    }
                }
                return (ArrayList<BookDetails>) bookDetailses;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }

    }

}
