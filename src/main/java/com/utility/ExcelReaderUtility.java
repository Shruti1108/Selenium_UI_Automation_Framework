package com.utility;
import com.ui.pojo.UserData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
public static void main(String[]args)
{
             XSSFWorkbook  xssfworkbook=null;
             XSSFSheet sheet = null;
             Row row;
             Cell email;
             Cell password;

             //Noraml data reading
            File fp = new File(System.getProperty("user.dir")+"/loginData.numbers");

            try {
                xssfworkbook = new XSSFWorkbook(fp);
                sheet = xssfworkbook.getSheet("LoginData");
                Iterator<Row> iterator= sheet.iterator();
                while(iterator.hasNext())
                {
                    row = iterator.next();
                    email = row.getCell(0);
                    password = row.getCell(1);
                    System.out.println(email +" "+password);
                }

            }catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
            catch(org.apache.poi.openxml4j.exceptions.InvalidFormatException e)
            {
                System.out.println(e.getMessage());
            }
}

public static Iterator<UserData> readExcelData(String fileName)
{
    XSSFWorkbook  xssfworkbook=null;
    XSSFSheet sheet = null;
    Row row;
    Cell email;
    Cell password;
    List<UserData> list = null;
    UserData userData = null;

    //Noraml data reading
    File fp = new File(System.getProperty("user.dir")+"/loginData.numbers");

    try {
        xssfworkbook = new XSSFWorkbook(fp);
        sheet = xssfworkbook.getSheet("LoginData");
        Iterator<Row> rowIterator= sheet.iterator();
        list = new ArrayList<UserData>();
        rowIterator.next();//-> to skip 1st row
        while(rowIterator.hasNext())
        {
            row = rowIterator.next();
            email = row.getCell(0);
            password = row.getCell(1);
            userData= new UserData(email.toString(),password.toString());
            list.add(userData);
        }
        xssfworkbook.close();
    }catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
    catch(org.apache.poi.openxml4j.exceptions.InvalidFormatException e)
    {
        System.out.println(e.getMessage());
    }
    return list.iterator();
}
}
//
