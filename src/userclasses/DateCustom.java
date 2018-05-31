/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.io.Log;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.spinner.Picker;
import java.util.Calendar;
import java.util.Date;

/**
 * //2017-01-31T00:00:00.510Z
 *
 * @author sandraarnolds
 */
public class DateCustom {

    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;

    public DateCustom() {
    }

    public Date getDateTimeObject(Picker date, Picker time) {

        Date dateObject = null;

        Calendar dateCalender = Calendar.getInstance();
        dateCalender.setTime(date.getDate());

        int total = time.getTime();

        int h = total / 60; //since both are ints, you get an int
        int min = total % 60;

        int y = dateCalender.get(Calendar.YEAR);
        int m = dateCalender.get(Calendar.MONTH);
        int d = dateCalender.get(Calendar.DAY_OF_MONTH);

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.MONTH, m);//Month starts at 0 (zeor)
        cal.set(Calendar.DAY_OF_MONTH, d);
        cal.set(Calendar.HOUR_OF_DAY, h);
        cal.set(Calendar.MINUTE, min);

        dateObject = new Date(cal.getTime().getTime());

        return dateObject;
    }

    public DateCustom(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);

        int h = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);

        this.day = d;
        this.month = m;
        this.year = y;

        this.hour = h;
        this.min = min;
    }

    public Date getPickerDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.MONTH, this.month - 1);//Month starts at 0 (zeor)
        cal.set(Calendar.DAY_OF_MONTH, this.day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date date = new Date(cal.getTime().getTime());

        return date;
    }

    public int getPickerTime() {
        return (60 * this.hour) + this.min;
    }

    public DateCustom(DateSpinner date) {

        this.day = date.getCurrentDay();
        this.month = date.getCurrentMonth();
        this.year = date.getCurrentYear();
    }

    public boolean isDateValid() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);

        int now_y = cal.get(Calendar.YEAR);
        int now_m = cal.get(Calendar.MONTH) + 1;
        int now_d = cal.get(Calendar.DAY_OF_MONTH);

        Log.p("DateCustom now_d=" + now_d + " this.month=" + this.month, Log.DEBUG);

        if (this.day < now_d || this.month < now_m || this.year < now_y) {
            return false;
        }

        return true;

    }

    public boolean isTimeValid() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);

        int now_y = cal.get(Calendar.YEAR);
        int now_m = cal.get(Calendar.MONTH) + 1;
        int now_d = cal.get(Calendar.DAY_OF_MONTH);

        int now_h = cal.get(Calendar.HOUR_OF_DAY);
        int now_min = cal.get(Calendar.MINUTE);

        if (this.day == now_d && this.month == now_m && this.year == now_y) {//If it is today
            if (this.hour < now_h && this.min < now_min) {
                return false;
            }
        }

        return true;

    }

    public String getTimeNow() {

        String time = "";

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);

        int now_h = cal.get(Calendar.HOUR_OF_DAY);
        int now_min = cal.get(Calendar.MINUTE);

        String hour = now_h + "";
        String min = now_min + "";

        if (now_h < 10) {
            hour = "0" + now_h;
        }
        if (now_min < 10) {
            min = "0" + now_min;
        }

        time = hour + "h" + min;

        return time;

    }

    public Date getDate() {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.MONTH, this.month - 1);//Month starts at 0 (zeor)
        cal.set(Calendar.DAY_OF_MONTH, this.day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date date = new Date(cal.getTime().getTime());

        return date;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDateTodayStart() {
        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.set(Calendar.HOUR_OF_DAY, 0);
        calStartTime.set(Calendar.MINUTE, 0);
        calStartTime.set(Calendar.SECOND, 0);
        calStartTime.set(Calendar.MILLISECOND, 0);
        return calStartTime.getTime();
    }

    public Date getDateTodayEnd() {
        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.set(Calendar.HOUR_OF_DAY, 23);
        calStartTime.set(Calendar.MINUTE, 59);
        calStartTime.set(Calendar.SECOND, 59);
        calStartTime.set(Calendar.MILLISECOND, 999);

        return calStartTime.getTime();
    }

    public Date getDateWeekStart() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calStartTime.set(Calendar.HOUR_OF_DAY, 0);
        calStartTime.set(Calendar.MINUTE, 0);
        calStartTime.set(Calendar.SECOND, 0);
        calStartTime.set(Calendar.MILLISECOND, 0);

        return calStartTime.getTime();
    }

    public Date getDateWeekEnd() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calStartTime.set(Calendar.HOUR_OF_DAY, 23);
        calStartTime.set(Calendar.MINUTE, 59);
        calStartTime.set(Calendar.SECOND, 59);
        calStartTime.set(Calendar.MILLISECOND, 999);

        return calStartTime.getTime();
    }

    public Date getDateMonthStart() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);

        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.set(Calendar.DAY_OF_MONTH, 1);
        calStartTime.set(Calendar.HOUR_OF_DAY, 0);
        calStartTime.set(Calendar.MINUTE, 0);
        calStartTime.set(Calendar.SECOND, 0);
        calStartTime.set(Calendar.MILLISECOND, 0);

        return calStartTime.getTime();
    }

    public Date getDateMonthEnd() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);
        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);

        int lastDay = -1;

        int thisMonth = calStartTime.get(Calendar.MONTH);

        switch (thisMonth) {//TODO this code will break after 2017

            case 0:
                lastDay = 31;
                break;//Jan
            case 1:
                lastDay = 28;
                break;//Feb
            case 2:
                lastDay = 31;
                break;//Mar
            case 3:
                lastDay = 30;
                break;//Apr
            case 4:
                lastDay = 31;
                break;//May
            case 5:
                lastDay = 30;
                break;//Jun
            case 6:
                lastDay = 31;
                break;//Jul
            case 7:
                lastDay = 31;
                break;//Aug
            case 8:
                lastDay = 30;
                break;//Sep
            case 9:
                lastDay = 31;
                break;//Oct
            case 10:
                lastDay = 30;
                break;//Nov
            case 11:
                lastDay = 31;
                break;//Dec
            default:
                lastDay = 0;

        }

        calStartTime.set(Calendar.HOUR_OF_DAY, 23);
        calStartTime.set(Calendar.MINUTE, 59);
        calStartTime.set(Calendar.SECOND, 59);
        calStartTime.set(Calendar.MILLISECOND, 999);

        return calStartTime.getTime();
    }

    public Date getDateMonthNext30Days() {

        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);

        Calendar calStartTime = Calendar.getInstance();
        calStartTime.setTime(dateNow);
        calStartTime.add(Calendar.MONTH, 1);

        return calStartTime.getTime();
    }

}
