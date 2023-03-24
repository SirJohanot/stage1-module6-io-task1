package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (java.io.FileReader fileReader = new java.io.FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String nameLine = bufferedReader.readLine();
            String nameOnly = nameLine.replace("Name: ", "");

            String ageLine = bufferedReader.readLine();
            String ageOnly = ageLine.replace("Age: ", "");
            int ageNumber = Integer.parseInt(ageOnly);

            String emailLine = bufferedReader.readLine();
            String emailOnly = emailLine.replace("Email: ", "");

            String phoneLine = bufferedReader.readLine();
            String phoneOnly = phoneLine.replace("Phone: ", "");
            Long phoneNumber = Long.parseLong(phoneOnly);

            return new Profile(nameOnly, ageNumber, emailOnly, phoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
