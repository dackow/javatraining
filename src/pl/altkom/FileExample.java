/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class FileExample {

    public static void main(String[] args) {
        longVersion();
        shortVersion();
    }

    private static void shortVersion() throws RuntimeException {
        File file = new File("file.txt");
        System.out.println(file.exists() ? "File exists" : "File not exists");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException("Not able to create the file");
            }
        }

        //some neuance!!!!
        try(FileWriter wr = new FileWriter(file)){
            wr.append("text text");
        } catch (IOException  ex) {
            throw new RuntimeException("Not able to write the file stream",ex);
        }
//        FileWriter wr = null;
//        try {
//            //FileOutputStream os = new FileOutputStream(file);
//            //os.write("content to be written to the file".getBytes());
//            wr = new FileWriter(file);
//            wr.append("text text");
//        } catch (FileNotFoundException a) {
//            throw new RuntimeException("Not able to open the file stream");
//        } catch (IOException b) {
//            throw new RuntimeException("Not able to open the file stream");
//        } finally {
//            if (wr != null) {
//                try {
//                    wr.close();
//                } catch (IOException ex) {
//                    throw new RuntimeException("Not able to close the file stream");
//                }
//            }
//        }
    }

    private static void longVersion() throws RuntimeException {
        File file = new File("file.txt");
        System.out.println(file.exists() ? "File exists" : "File not exists");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException("Not able to create the file");
            }
        }

        FileWriter wr = null;
        try {
            //FileOutputStream os = new FileOutputStream(file);
            //os.write("content to be written to the file".getBytes());
            wr = new FileWriter(file);
            wr.append("text text");
        } catch (FileNotFoundException a) {
            throw new RuntimeException("Not able to open the file stream");
        } catch (IOException b) {
            throw new RuntimeException("Not able to open the file stream");
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (IOException ex) {
                    throw new RuntimeException("Not able to close the file stream");
                }
            }
        }
    }
}
