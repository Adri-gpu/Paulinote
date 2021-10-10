package src.main;

import java.text.ParseException;

/**
 * @author louis
 */
public class Date {
    
    public static void main(String[]args) throws ParseException{
        String str = "20-04-2016";
String[] splitArray = str.split("-");
int day = Integer.parseInt(splitArray[0]);
int month = Integer.parseInt(splitArray[1]);
int year = Integer.parseInt(splitArray[2]);
    
int full  = day+month+year;

        String str2 = "15-02-2016";

int day1 = Integer.parseInt(splitArray[0]);
int month1= Integer.parseInt(splitArray[1]);
int year1 = Integer.parseInt(splitArray[2]);

int full1  = day1+month1+year1;

int finish = full - full1;

System.out.println(finish);

    }
}
