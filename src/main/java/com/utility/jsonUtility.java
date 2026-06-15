package com.utility;

import com.constants.Environment;
import com.google.gson.Gson;
import com.ui.pojo.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputFilter;

public class jsonUtility {

    public static void readJson() {

        FileReader fileReader = null;
        Gson gson = new Gson();

        File jsonFile = new File(System.getProperty("user.dir") + "//src//main//resources//" + "config.json");

        try {
            fileReader = new FileReader(jsonFile);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        ObjectInputFilter.Config config = gson.fromJson(fileReader, ObjectInputFilter.Config.class);

        //Environment environment = config.getEnvironments().get("QA");

        //System.out.println(environment.getUrl());
        //return environment.getUrl();
    }
}
// read the json file - when data is in json format/file
// as theer
// config object maps the config.json file with config.java that is POJO for serealization
//environament will help us to read the env value from .json file