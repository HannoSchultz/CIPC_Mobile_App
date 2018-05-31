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
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author mLab
 */
public class ProjectService {

    public static ParseObject addProject(ParseUser userObjectId, String title,
            String description, Date date) {

        ParseObject object = null;

        try {
            object = ParseObject.create(Const.PARSE_CLASS_PROJECT);
            object.put("userObjectId", userObjectId);
            object.put("title", title);
            object.put("description", description);
            object.put("dateDue", date);
            object.save();
        } catch (ParseException e) {
            object = null;
            Log.p("[ProjectService.addProject(..)] ParseException=" + e);
        }

        //Log.p("[ProjectService.addProject(..) date:" + date);
        return object;
    }

    public static String updateProject(ParseObject project) {
        String response = "Project updated.";

        try {
            project.save();
        } catch (ParseException e) {
            response = "Error updating project.";
            Log.p("[ProjectService.updateProject(..) ParseException=" + "",
                    Log.DEBUG);
        }

        return response;
    }

    public List<Project> getProjectsUI(ParseUser userObjectId) {
        List<Project> projects = new ArrayList<Project>();
        List<ParseObject> parseObjects = getProjects(userObjectId);

        Project p = new Project();
        p.setObjectId("0");
        p.setTitle("Select Project");
        projects.add(p);
        for (ParseObject object : parseObjects) {
            p = new Project();
            p.setObjectId(object.getObjectId());
            p.setTitle(object.getString("title"));
            p.setDescription(object.getString("description"));
            p.setDate(object.getDate("dateDue"));
            p.setParseObject(object);
            projects.add(p);
        }
        return projects;
    }

    public List<ParseObject> getProjects(ParseUser userObjectId) {

        List<ParseObject> projects = new ArrayList<ParseObject>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Project");
        //query.whereEqualTo("userObjectId", userObjectId);

        try {
            projects = query.find();
        } catch (ParseException e) {
            Log.p("[ProjectService.getProjects(..) ParseException=" + "",
                    Log.DEBUG);
        }

//        String url = "http://" + Const.server + "/TaskManagementApp/ProjectServices.php";
//        ConnectionRequest cr = new ConnectionRequest();
//        cr.setUrl(url);
//        cr.addArgument("actionType", "projectbyuser");
//        //cr.addArgument("userid", ProjectUserId);
//        cr.setPost(true);
//        NetworkManager.getInstance().addToQueueAndWait(cr);
//
//        byte[] byteData = cr.getResponseData();
//        String data = new String(cr.getResponseData());
//
//        if (data != null) {
//
//            String data1 = "{\"array\":" + data;
//
//            System.out.println(data1);
//            Result result = Result.fromContent(data1, Result.JSON);
//            List list = result.getAsArray("array");
//            // Dialog.show("list", list.toString(), "Okay", null);
//
//            int userId = Integer.parseInt(projectUserId);
//
//            for (int i = 0; i < list.size(); i++) {
//
//                Hashtable tempObject = (Hashtable) list.get(i);
//                int projectId = (int) Double.parseDouble(tempObject.get("PROJECT_ID").toString());
//                String title = tempObject.get("PROJECT_NAME").toString();
//                String date = tempObject.get("PROJECT_DATE").toString();//PROJECT_DESCRIPTION	
//                String description = tempObject.get("PROJECT_DESCRIPTION").toString();
//
//                Project project = new Project(userId, projectId, title, date, description);
//                projects.add(project);
//            }
//        }
        return projects;

    }
}
