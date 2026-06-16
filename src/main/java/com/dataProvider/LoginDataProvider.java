package com.dataProvider;

import com.google.gson.Gson;
import com.ui.pojo.UserData;
import com.ui.pojo.UserList;
import com.utility.ExcelReaderUtility;
import com.utility.csvReaderUtility;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {
    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "//testData//logindata.json");
        FileReader fileReader = new FileReader(testDataFile);
        UserList data = gson.fromJson(fileReader, UserList.class);// deserialization

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for (UserData user : data.getData()) {

            dataToReturn.add(new Object[] { user });
        }

        return dataToReturn.iterator();

    }

    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<UserData> loginCSVDataProvider() {
        return csvReaderUtility.readCSVFile("loginData.csv");
    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<UserData> loginExcelDataProvider() {
        return ExcelReaderUtility.readExcelData("LoginData.xlsx");
    }
}
