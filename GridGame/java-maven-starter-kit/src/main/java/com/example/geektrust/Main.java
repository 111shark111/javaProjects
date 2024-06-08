package com.example.geektrust;

import com.example.geektrust.Service.MainService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainService mainService=new MainService();
//        Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" "); // Split the line into parts based on space
                mainService.mainService(parts);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
