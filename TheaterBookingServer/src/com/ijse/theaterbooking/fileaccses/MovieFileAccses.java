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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.ijse.theaterbooking.model.Movies;

/**
 *
 * @author Sanu Vithanage
 */
public class MovieFileAccses {

    private static final File file = new File("./src/com/ijse/theaterbooking/file/Movies.txt");
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addMovie(Movies movies) throws RemoteException, ClassNotFoundException, SQLException, IOException, FileNotFoundException, ParseException {
        try {
            readWriteLock.writeLock().lock();
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
            }

            String data = "";
            data += movies.getMovieID() + "#";
            data += movies.getMovieName() + "#";
            data += movies.getMovieTime() + "#";
            data += movies.getMovieType() + "#";
            data += movies.getMovieDuration() + "#";
            data += movies.getMovieTrailer() + "#";
            data += movies.getMovieImageId();

            BufferedWriter bufferedWriter = null;
            try {

                FileWriter fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(data);

                bufferedWriter.newLine();
                return isMovieAvailable(movies.getMovieName());
            } finally {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public Movies searcMovie(String id) throws RemoteException, FileNotFoundException, IOException {
        try {
            readWriteLock.readLock().lock();
            BufferedReader reader = null;
            Movies movi = null;
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    if (data[0].equals(id)) {
                        movi = new Movies();
                        movi.setMovieID(data[0]);
                        movi.setMovieName(data[1]);
                        movi.setMovieTime(data[2]);
                        movi.setMovieType(data[3]);
                        movi.setMovieDuration(data[4]);
                        movi.setMovieTrailer(data[5]);
                        movi.setMovieImageId(data[6]);
                    }
                }
                return movi;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    public boolean deleteMovie(String id) throws RemoteException, FileNotFoundException, IOException, ParseException {
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
                return isMovieAvailable(id);
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

    public boolean updateMovie(Movies movie) throws RemoteException, FileNotFoundException, IOException, ParseException {
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
                    if (!data[0].equals(movie.getMovieID())) {
                        fileData.add(line);
                    } else {
                        String updLine = "";
                        updLine += movie.getMovieID() + "#";
                        updLine += movie.getMovieName() + "#";
                        updLine += movie.getMovieTime() + "#";
                        updLine += movie.getMovieType() + "#";
                        updLine += movie.getMovieDuration() + "#";
                        updLine += movie.getMovieTrailer() + "#";
                        updLine += movie.getMovieImageId();

                        fileData.add(updLine);
                    }
                }

                FileWriter fileWriter = new FileWriter(file);
                writer = new BufferedWriter(fileWriter);
                for (String lineData : fileData) {
                    writer.write(lineData);
                    writer.newLine();
                }
                return isMovieAvailable(movie.getMovieName());
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

    public ArrayList<Movies> getAllMovies() throws RemoteException, FileNotFoundException, IOException {
        readWriteLock.readLock().lock();
        BufferedReader reader = null;
        try {

            List<Movies> movieses = new ArrayList<>();
            try {

                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("#");
                    Movies movi = new Movies();
                    movi.setMovieID(data[0]);
                    movi.setMovieName(data[1]);
                    movi.setMovieTime(data[2]);
                    movi.setMovieType(data[3]);
                    movi.setMovieDuration(data[4]);
                    movi.setMovieTrailer(data[5]);
                    movi.setMovieImageId(data[6]);

                    movieses.add(movi);
                }
                return (ArrayList<Movies>) movieses;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isMovieAvailable(String movieName) throws IOException, FileNotFoundException, ParseException {
        Movies movies = searcMovie(movieName);
        return movies == null;
    }
}
