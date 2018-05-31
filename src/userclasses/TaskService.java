/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.codename1.ui.Dialog;
import com.parse4cn1.ParseException;
import com.parse4cn1.ParseObject;
import com.parse4cn1.ParseQuery;
import com.parse4cn1.ParseUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author mLab
 */
public class TaskService {

    public static boolean addTask(ParseObject parseObject) {
        boolean flag;
        try {
            parseObject.save();
            flag = true;
        } catch (ParseException e) {
            flag = false;
            Log.p("[TaskService.addTask(..)] ParseException=" + e);
        }
        return flag;
    }

    public static List<Task> getTasks(String status) {

        List<ParseObject> objects = new ArrayList<ParseObject>();
        List<Task> tasks = new ArrayList<Task>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery(Const.PARSE_CLASS_TASK);
        query.whereEqualTo("status", status);

        try {
            objects = query.find();
            for (ParseObject object : objects) {
                HashMap<String, ParseObject> hash = new HashMap<>();
                Task o = new Task();
                o.setParseObject(object);
                o.setTitle(object.getString("title"));
                o.setDate(object.getDate("dateDue"));

                List<ParseObject> list = (List<ParseObject>) object.get("taskUsers");
                for (ParseObject tempUser : list) {
                    hash.put(tempUser.getObjectId(), tempUser);
                }

                o.setTaskUsers(hash);
                tasks.add(o);
            }
        } catch (ParseException e) {
            Log.p("[TaskService.getTasksToday(..) ParseException=" + e.getMessage(), Log.DEBUG);
        }

        return tasks;

    }

    public List<Task> getTasks(ParseUser user, String taskType, boolean isDashboard) {

        List<Task> tasks = new ArrayList<Task>();
        DateCustom custom = new DateCustom();
        Date start = null;
        Date end = null;

        switch (taskType) {
            case Const.TASK_TODAY: {
                start = custom.getDateTodayStart();
                end = custom.getDateTodayEnd();
            }
            break;
            case Const.TASK_THIS_WEEK: {
                start = custom.getDateWeekStart();
                end = custom.getDateWeekEnd();
            }
            break;
            case Const.TASK_NEXT_30_DAYS: {
                start = custom.getDateTodayStart();
                end = custom.getDateMonthNext30Days();
            }
            break;
        }

        //Log.p("calStartTime=" + start, Log.DEBUG);
        //Log.p("calEndTime=" + end, Log.DEBUG);
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Const.PARSE_CLASS_TASK);

        if (isDashboard == true) {
            query.whereEqualTo("user", user)
                    .whereGreaterThan("dateDue", start)
                    .whereLessThan("dateDue", end).addAscendingOrder("dateDue");
        } else {
            query/*.whereEqualTo("user", user)*/
                    .whereGreaterThan("dateDue", start)
                    .whereLessThan("dateDue", end).addAscendingOrder("dateDue");
        }

        try {
            List<ParseObject> parseTasks = query.find();
            if (parseTasks == null) {
                Log.p("parseTasks null=", Log.DEBUG);
            } else {
                Log.p("parseTasks size=" + parseTasks.size(), Log.DEBUG);
            }

            for (ParseObject object : parseTasks) {
                HashMap<String, ParseObject> hash = new HashMap<>();
                Task o = new Task();
                o.setParseObject(object);
                o.setTitle(object.getString("title"));
                o.setDate(object.getDate("dateDue"));

                List<ParseObject> list = (List<ParseObject>) object.get("taskUsers");
                for (ParseObject tempUser : list) {
                    hash.put(tempUser.getObjectId(), tempUser);
                }

                o.setTaskUsers(hash);
                tasks.add(o);
            }
        } catch (ParseException e) {
            //Log.p("[TaskService.getTasksToday(..) ParseException=" + "",
            //Log.DEBUG);
        }

        return tasks;

    }

    public List<Task> getTasksThisWeek(String UserId) {

        List<Task> tasks = new ArrayList<Task>();
//        String url = "http://" + Const.server + "/TaskManagementApp/TaskServices.php";
//        ConnectionRequest cr = new ConnectionRequest();
//        cr.setUrl(url);
//        cr.addArgument("actionType", "ThisWeekTask");
//        cr.addArgument("userid",UserId);
//        cr.setPost(true);
//        NetworkManager.getInstance().addToQueueAndWait(cr);
//
//        byte[] byteData = cr.getResponseData();
//        String data = new String(cr.getResponseData());
//
//        if (data != null) {
//            String data1 = "{\"array\":" + data;
//
//            System.out.println(data1);
//            Result result = Result.fromContent(data1, Result.JSON);
//            List list = result.getAsArray("array");
//            //Dialog.show("list", list.toString(), "Okay", null);
//
//            for (int i = 0; i < list.size(); i++) {
//                Hashtable tempObject = (Hashtable) list.get(i);
//                int userId = (int) Double.parseDouble(tempObject.get("TASK_ID").toString());
//                String title = tempObject.get("TASK_NAME").toString();
//                 String date = tempObject.get("TASK_DATE").toString();;
//
//                Task task = new Task(userId, title, date);
//                tasks.add(task);
//            }
//        }
//
        return tasks;

    }

    public List<Task> getTasksThisMonth(String UserId) {

        List<Task> tasks = new ArrayList<Task>();
//        String url = "http://" + Const.server + "/TaskManagementApp/TaskServices.php";
//        ConnectionRequest cr = new ConnectionRequest();
//        cr.setUrl(url);
//        cr.addArgument("actionType", "tasksThisMonth");
//        cr.addArgument("userid", UserId);
//        cr.setPost(true);
//        NetworkManager.getInstance().addToQueueAndWait(cr);
//
//        byte[] byteData = cr.getResponseData();
//        String data = new String(cr.getResponseData());
//
//        if (data != null) {
//            String data1 = "{\"array\":" + data;
//
//            System.out.println(data1);
//            Result result = Result.fromContent(data1, Result.JSON);
//            List list = result.getAsArray("array");
//            //Dialog.show("list", list.toString(), "Okay", null);
//
//            for (int i = 0; i < list.size(); i++) {
//                Hashtable tempObject = (Hashtable) list.get(i);
//                int userId = (int) Double.parseDouble(tempObject.get("TASK_ID").toString());
//                String title = tempObject.get("TASK_NAME").toString();
//                 String date = tempObject.get("TASK_DATE").toString();;
//
//                Task task = new Task(userId, title, date);
//                tasks.add(task);
//            }
//        }
        return tasks;

    }

    public List<Task> getAllTask() {
        List<Task> tasks = new ArrayList<Task>();
//        String url = "http://" + Const.server + "/TaskManagementApp/TaskServices.php";
//        ConnectionRequest cr = new ConnectionRequest();
//        cr.setUrl(url);
//        cr.addArgument("actionType", "tasksAll");
//        cr.addArgument("userid", "1");
//        cr.setPost(true);
//        NetworkManager.getInstance().addToQueueAndWait(cr);
//
//        byte[] byteData = cr.getResponseData();
//        String data = new String(cr.getResponseData());
//
//        if (data != null) {
//            String data1 = "{\"array\":" + data;
//
//            System.out.println(data1);
//            Result result = Result.fromContent(data1, Result.JSON);
//            List list = result.getAsArray("array");
//            Dialog.show("list", list.toString(), "Okay", null);
//
//            for (int i = 0; i < list.size(); i++) {
//                Hashtable tempObject = (Hashtable) list.get(i);
//                int userId = (int) Double.parseDouble(tempObject.get("TASK_ID").toString());
//                String title = tempObject.get("TASK_NAME").toString();
//                String date = "---";
//
//                Task task = new Task(userId, title, date);
//                tasks.add(task);
//            }
//        }
        return tasks;

    }

}
