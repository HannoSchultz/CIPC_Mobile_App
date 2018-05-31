/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.cipc.webservices;

import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;
import com.codename1.util.MathUtil;
import com.codename1.util.StringUtil;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author blessingmobile
 */
public class Utility {

    public static String getDate(String datetime) {
        String result = "";

        Vector tokens = (Vector) StringUtil.tokenize(datetime, "-");

        Vector time = (Vector) StringUtil.tokenize(datetime, " ");

        String timeAlone = time.get(1).toString();

        Vector timeVector = (Vector) StringUtil.tokenize(timeAlone, ":");
        String minutes = timeVector.get(1).toString();
        String hour = timeVector.get(0).toString();

        String day = tokens.get(2).toString();
        String month = tokens.get(1).toString();
        String year = tokens.get(0).toString();

        Hashtable months = new Hashtable();

        months.put("01", "January");
        months.put("02", "February");
        months.put("03", "March");
        months.put("04", "April");
        months.put("05", "May");
        months.put("06", "June");
        months.put("07", "July");
        months.put("08", "August");
        months.put("09", "September");
        months.put("10", "October");
        months.put("11", "November");
        months.put("12", "December");

        String shortMonth = months.get(month).toString().substring(0, 3);
        String shortDate = day.substring(0, 2);

        result = shortDate + " " + shortMonth + " " + year;

        return result;
    }
    
     public static InputStreamReader convertStringtoInputStreamReader(String data) {

        byte[] resultByte = data.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(resultByte);
        InputStreamReader is = new InputStreamReader(bis);
        return is;

    }

    public static String getDateWithTime(String datetime) {
        String result = "";

        Vector tokens = (Vector) StringUtil.tokenize(datetime, "-");

        Vector time = (Vector) StringUtil.tokenize(datetime, " ");

        String timeAlone = time.get(1).toString();

        Vector timeVector = (Vector) StringUtil.tokenize(timeAlone, ":");
        String minutes = timeVector.get(1).toString();
        String hour = timeVector.get(0).toString();

        String day = tokens.get(2).toString();
        String month = tokens.get(1).toString();
        String year = tokens.get(0).toString();

        Hashtable months = new Hashtable();

        months.put("01", "January");
        months.put("02", "February");
        months.put("03", "March");
        months.put("04", "April");
        months.put("05", "May");
        months.put("06", "June");
        months.put("07", "July");
        months.put("08", "August");
        months.put("09", "September");
        months.put("10", "October");
        months.put("11", "November");
        months.put("12", "December");

        String shortMonth = months.get(month).toString().substring(0, 3);
        String shortDate = day.substring(0, 2);

        result = shortDate + " " + shortMonth + " " + hour + ":" + minutes;

        return result;
    }

    public String getFullDateWithTime() {
        String datetime = getDateTime();
        String result = "";

        Vector tokens = (Vector) StringUtil.tokenize(datetime, "-");

        Vector time = (Vector) StringUtil.tokenize(datetime, " ");

        String timeAlone = time.get(1).toString();

        Vector timeVector = (Vector) StringUtil.tokenize(timeAlone, ":");
        String minutes = timeVector.get(1).toString();
        String hour = timeVector.get(0).toString();

        String day = tokens.get(2).toString();
        String month = tokens.get(1).toString();
        String year = tokens.get(0).toString();

        Hashtable months = new Hashtable();

        months.put("01", "January");
        months.put("02", "February");
        months.put("03", "March");
        months.put("04", "April");
        months.put("05", "May");
        months.put("06", "June");
        months.put("07", "July");
        months.put("08", "August");
        months.put("09", "September");
        months.put("10", "October");
        months.put("11", "November");
        months.put("12", "December");

        String shortMonth = months.get(month).toString();
        String shortDate = day.substring(0, 2);

        result = shortDate + " " + shortMonth + " " + year + " " + hour + ":" + minutes;

        return result;
    }

    public static Image getImage(String name) {

        try {
            Resources resFile = Resources.openLayered("/theme");
            Image image = resFile.getImage(name);
            return image;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

    public static double round(double valueToRound, int numberOfDecimalPlaces) {

        double multipicationFactor = MathUtil.pow(10, numberOfDecimalPlaces);
        double interestedInZeroDPs = valueToRound * multipicationFactor;
        return Math.round(interestedInZeroDPs) / multipicationFactor;

    }

    public static String updateFormat(String num) throws NumberFormatException {

        if (num.indexOf(".") < 0) {

            num = num + ".0";

        }

        int len = num.length();
        int index = num.indexOf(".");

        if ((len - 2) == index) {

            num = num + "0";

        }

        double total = Double.parseDouble(num);

        String builder = "";

        if (total > 999.99 && total < 10000.0) {//1 000 and up

            builder = "" + num.charAt(0);
            builder += " ";
            for (int i = 1; i < num.length(); i++) {
                builder += num.charAt(i);
            }
            num = builder;

        } else if (total > 9999.99 && total < 100000.0) {//10 000 and up

            builder = "" + num.charAt(0);
            builder += "" + num.charAt(1);
            builder += " ";
            for (int i = 2; i < num.length(); i++) {
                builder += num.charAt(i);
            }
            num = builder;
        }

        return num;
    }

   

    public static String removeWord(String message, String word) {
        String tempMessage = word;
        message = message.substring(tempMessage.length() + 3);//remove first "message"
        message = message.substring(0, (message.length() - (tempMessage.length() + 3)));//remove first "message"
        return message;
    }

    public String removeQuotationsOnINT(String toConvert) {

        String newString = "";
        int zero = (int) '0';
        int nine = (int) '9';

        for (int i = 0; i < toConvert.length(); i++) {
            int c = (int) toConvert.charAt(i);
            if (c >= zero && c <= nine) {
                newString += (char) c;
            }
        }
        return newString;

    }

    public String removeQuotationsOnSTRING(String toConvert) {//TODO find better way to handle quotations

        String newString = "";
        int sstart = (int) 'A';
        int send = (int) 'z';
        int asterisk = '*';
        int space = 32;//space character
        for (int i = 0; i < toConvert.length(); i++) {
            int c = (int) toConvert.charAt(i);
            if ( (c >= sstart && c <= send) || c == space || c == asterisk) {
                newString += (char) c;
            }
        }
        //remove white spaces
        newString = newString.trim();
        return newString;

    }

    public String removeQuotationsOnDATE(String toConvert) {//TODO find better way to handle quotations

        String newString = "";
        int start = (int) '0';
        int end = (int) '9';
        int colon = (int) ':';
        int dash = (int) '-';
        int T = (int) 'T';
        int dot = (int) '.';

        int space = 32;//space character
        for (int i = 0; i < toConvert.length(); i++) {
            int c = (int) toConvert.charAt(i);
            if (c >= start && c <= end || c == space || c == colon || c == dash || c == T || c == dot) {
                newString += (char) c;
            }
        }
        //remove white spaces at the beginning and the end
        newString = newString.trim();
        return newString;

    }

   

    public static Element parseXML(String data) {

        XMLParser parser = new XMLParser();
        parser.setCaseSensitive(true);
        Element element = parser.parse(convertStringtoInputStreamReader(data));
        return element;

    }

    public static Hashtable parseJSON(String data) {

        JSONParser parse = new JSONParser();

        Hashtable hash = null;

        try {

            hash = parse.parse(convertStringtoInputStreamReader(data));
            return hash;

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }
        return null;
    }

    public static String removeDot(String s) {

        int index = s.indexOf('.');
        return s.substring(0, index);

    }

    public String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public String getIOSDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd MM yyyy HH:mm");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public String getCurrentMonth() {

        Calendar cal = Calendar.getInstance();
        String value = "";

        int currentDate = cal.get(Calendar.MONTH) + 1;//Because 0 is January

        if (currentDate < 10) {

            value = "0" + currentDate;

        }

        return value;

    }

    public String getCurrentYear() {

        Calendar cal = Calendar.getInstance();

        String value = String.valueOf(cal.get(Calendar.YEAR));

        return value;

    }
}