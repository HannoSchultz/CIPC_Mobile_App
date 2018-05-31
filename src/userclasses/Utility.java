/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.components.ToastBar;
import com.codename1.io.Log;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.spinner.DateSpinner;
import com.parse4cn1.ParseException;
import com.parse4cn1.ParseFile;
import com.parse4cn1.ParseUser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sandraarnolds
 */
public class Utility {

    public Image getImage(String name) {
        EncodedImage placeHolder = null;
        try {
            InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + name);//TEMP
            placeHolder = EncodedImage.create(is);
        } catch (IOException e) {
            Log.p("Couldn\'t load image=" + "", Log.DEBUG);
        }
        return placeHolder;
    }

    public Image maskImage(Image other) {

        //Image mask = getImage("rounded-mask.png");
        //EncodedImage roundPlaceholder = EncodedImage.createFromImage(other.scaled(mask.getWidth(), mask.getHeight()).applyMask(mask.createMask()), false);
        return other;
    }

    public static void showDialog(String title, String message) {
        //Dialog.show(title, message, "Ok", null);
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(message);
        status.setExpires(5000);
        status.show();

    }

    public static String intToString(int num) {
        String s = "";
        if (num < 10) {
            s = "0" + num;
        } else {
            s = num + "";
        }
        return s;
    }

    public static String convertToDateString(Date date) {

        String dateString = null;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);

        String year = String.valueOf(intToString(y));
        String month = String.valueOf(intToString(m));
        String day = String.valueOf(intToString(d));

        dateString = day + "-" + month + "-" + year;

        Log.p("original=" + date + " string date=" + dateString, Log.DEBUG);

        return dateString;
    }

    public static Date convertToDate(DateSpinner spinner) {

        int year = spinner.getCurrentYear();
        int month = spinner.getCurrentMonth();
        int day = spinner.getCurrentDay();

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);//Month starts at 0 (zeor)
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date date = new Date(cal.getTime().getTime());

        return date;
    }

    public static Image uploadImage(String picture, EncodedImage placeHolder) {
        Log.p("[Utility->uploadImage(..)] Make image upload run in background", Log.DEBUG);
        String newUrl = "";
        try {
            Image raw_img = EncodedImage.createImage(picture);
            EncodedImage img = EncodedImage.createFromImage(raw_img, false);

            ParseFile file = new ParseFile("image.png", img.getImageData(), "image/png");
            file.save();

            String url = file.getUrl();
            int index = url.indexOf(":" + Const.PARSE_SERVER_PORT);
            String sub = url.substring(index);
            newUrl = Const.PARSE_IMAGE_URL + sub;

            Log.p("[Utility->uploadImage(..)] newUrl=" + newUrl, Log.DEBUG);

            ParseUser currentUser = ParseUser.getCurrent();
            currentUser.put("profileImage", file);
            currentUser.put("profileImageUrl", newUrl);
            currentUser.save();
            Log.p("[Utility->uploadImage(..)] saved neWURL to user with email=" + newUrl, Log.DEBUG);
            Log.p("TODO [Utility->uploadImage(..)] return scale height based on Multi-image", Log.DEBUG);
            raw_img = raw_img.scaled(placeHolder.getWidth(), placeHolder.getHeight());
            return raw_img;
        } catch (ParseException e) {
            Log.p("[Utility.uploadImage(..)] ParseException=" + "", Log.DEBUG);
        } catch (IOException e) {
            Log.p("[Utility.uploadImage(..)] IOException=" + "", Log.DEBUG);
        }

        return null;
    }
}
