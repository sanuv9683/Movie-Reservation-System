/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.fileaccses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.ijse.theaterbooking.model.Book;
import com.ijse.theaterbooking.model.BookDetails;
import com.ijse.theaterbooking.model.Users;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sanu Vithanage
 */
public class BookFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/"
            + "file/Book.txt");
    private static final File file1 = new File("./src/com/ijse/theaterbooking/"
            + "file/BookDetails.txt");

    private final static ReentrantReadWriteLock readWriteLock = new 
        ReentrantReadWriteLock();

    public boolean addBooking(Book book, ArrayList<BookDetails> bookDetails)
            throws RemoteException, ClassNotFoundException, SQLException, 
            IOException, FileNotFoundException, ParseException {
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter2 = null;

        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        if (!file1.exists()) {
            boolean createNewFile = file1.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        FileWriter fileWriter1 = new FileWriter(file1, true);
        bufferedWriter2 = new BufferedWriter(fileWriter1);

        String data = "";
        String data2 = "";
        data += book.getBookId() + "#";
        data += book.getBookDate() + "#";
        data += book.getUserId() + "#";

        for (BookDetails bookDetail : bookDetails) {
            data2 += bookDetail.getBookingId() + "#";
            data2 += bookDetail.getMovieId() + "#";
            data2 += bookDetail.getSheetId() + "#";
            data2 += bookDetail.getPrice() + "#";
            data2 += bookDetail.getbDate()+ "#\n";

        }

        try {

            bufferedWriter.write(data);
            bufferedWriter2.write(data2);

            bufferedWriter.newLine();

            return true;
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
        }

    }

    public Book searchBooking(String id) throws RemoteException,
            FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            Book book = null;

            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[0].equals(id)) {
                        book = new Book();
                        book.setBookId(data[0]);
                        book.setBookDate(data[1]);
                        book.setUserId(data[2]);

                    }
                }

                return book;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean deleteBooking(String id) throws RemoteException,
            FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        BufferedReader reader1 = null;
        BufferedWriter writer = null;
        BufferedWriter writer1 = null;
        try {
            readWriteLock.writeLock().lock();

            try {

                FileReader fileReader = new FileReader(file);
                FileReader fileReader1 = new FileReader(file1);
                reader = new BufferedReader(fileReader);
                reader1 = new BufferedReader(fileReader1);
                List<String> fileData = new ArrayList<>();
                List<String> fileData1 = new ArrayList<>();
                String line = null;
                String line1 = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (!data[0].equals(id)) {
                        fileData.add(line);
                    }
                }

                while ((line1 = reader1.readLine()) != null) {
                    String[] data1 = line1.split("#");
                    if (!data1[0].equals(id)) {
                        fileData1.add(line1);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                FileWriter fileWriter1 = new FileWriter(file1);
                writer = new BufferedWriter(fileWriter);
                writer1 = new BufferedWriter(fileWriter1);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                for (String lineData1 : fileData1) {
                    writer1.write(lineData1);
                    writer1.newLine();
                }
                return isBookAvailable(id);
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (reader1 != null) {
                    reader1.close();
                }
                if (writer1 != null) {
                    writer1.close();
                }
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public boolean updateBooking(Book book, ArrayList<BookDetails> bookDetail) 
            throws RemoteException, FileNotFoundException, IOException, 
            ParseException {
        BufferedReader reader = null;
        BufferedReader reader1 = null;
        BufferedWriter writer = null;
        BufferedWriter writer1 = null;
        try {
            readWriteLock.writeLock().lock();

            try {
                FileReader fileReader = new FileReader(file);
                FileReader fileReader1 = new FileReader(file1);
                reader = new BufferedReader(fileReader);
                reader1 = new BufferedReader(fileReader1);
                List<String> fileData = new ArrayList<>();
                List<String> fileData1 = new ArrayList<>();
                String line = null;
                String line1 = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (!data[0].equals(book.getBookId())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += book.getBookId() + "#";
                        updLine += book.getBookDate() + "#";
                        updLine += book.getUserId();
                        fileData.add(updLine);
                    }
                }

                while ((line1 = reader1.readLine()) != null) {
                    String[] data1 = line1.split("#");
                    if (!data1[0].equals(book.getBookId())) {
                        fileData1.add(line1);
                    } else {
                        String updLine1 = "";
                        for (BookDetails BookDetails1 : bookDetail) {
                            updLine1 += BookDetails1.getBookingId() + "#";
                            updLine1 += BookDetails1.getMovieId() + "#";
                            updLine1 += BookDetails1.getSheetId() + "#";
                            updLine1 += BookDetails1.getPrice() + "#";
                            updLine1 += BookDetails1.getbDate()+ "#";
                            fileData1.add(updLine1);
                        }

                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                FileWriter fileWriter1 = new FileWriter(file1);
                writer = new BufferedWriter(fileWriter);
                writer1 = new BufferedWriter(fileWriter1);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                for (String lineData1 : fileData1) {
                    writer1.write(lineData1);
                    writer1.newLine();
                }
                return isBookAvailable(book.getBookId());
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (reader1 != null) {
                    reader1.close();
                }
                if (writer1 != null) {
                    writer1.close();
                }
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public ArrayList<Book> getBookings() throws RemoteException,
            FileNotFoundException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<Book> book = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    Book bk = new Book();
                    bk.setBookId(data[0]);
                    bk.setBookDate(data[1]);
                    bk.setUserId(data[2]);
                    book.add(bk);
                }
                return (ArrayList<Book>) book;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isBookAvailable(String bookId) throws IOException, 
            FileNotFoundException, ParseException {
        Book book = searchBooking(bookId);
        return book == null;
    }

}
