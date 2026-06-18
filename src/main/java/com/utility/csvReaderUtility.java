package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.UserData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class csvReaderUtility {

    public static Iterator<UserData> readCSVFile(String filename) {
        File file = new File(System.getProperty("user.dir") +File.separator +"//testData//" + filename);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<UserData> userlist = null;
        UserData userData;
        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
            userlist = new ArrayList<UserData>();
            while ((line = csvReader.readNext()) != null) {
                userData = new UserData(line[0], line[1]);
                userlist.add(userData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        return userlist.iterator();
    }
}