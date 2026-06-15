package com.utility;

import com.constants.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {

    public static String readProperties(Environment env, String property)
    {

        FileReader fileReader;
        Properties prop  = new Properties();;

        //read property file 1st
        //1. tell location
        File file = new File(System.getProperty("user.dir")+"//src//main//resources//"+env+".properties");

        //2. read file
        try{

            fileReader = new FileReader(file);
            // 3. read specific file
            prop.load(fileReader);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found"+ e);
        }
        catch(IOException e)
        {
            System.out.println("Error: File not found"+ e);
        }

        String url = prop.getProperty(property.toUpperCase());
        return url;
    }
}
//file class form java.io.file
//methods ->System.getproperty()-> give root folder where file is, File.separator -> avoid '/''\' confusion,
//FileReader() reads file & accept File param
