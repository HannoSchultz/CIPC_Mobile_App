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
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.parse4cn1.ParseException;
import com.parse4cn1.ParseObject;
import com.parse4cn1.ParseQuery;
import com.parse4cn1.ParseUser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Blessing
 */
public class UserService {

    public static void addUser(ParseUser user) throws ParseException {

        user.signUp();

    }

    public Hashtable[] getUsersHashtable() {

        Hashtable[] table = null;

        List<ParseUser> users = null;

        try {

            //Get Users & assign access 
            ParseQuery<ParseUser> query = ParseQuery.getQuery("_User");
            //query.whereEqualTo("userObjectId", userObjectId);

            users = query.find();
            table = new Hashtable[users.size()];
            for (int i = 0; i < users.size(); i++) {

                ParseUser tempObject = (ParseUser) users.get(i);

                String objectId = tempObject.getObjectId();
                String userEmail = tempObject.getString("username");
                String userImageUrl = tempObject.getString("profileImageUrl");//PROJECT_DESCRIPTION	
                String userName = tempObject.getString("firstName");
                String userSurname = tempObject.getString("lastName");

                String fullName = "";
                if ((userName == null || userName.length() == 0)
                        && (userSurname == null || userSurname.length() == 0)) {
                    fullName = tempObject.getString("email");
                } else {
                    fullName = userName + " " + userSurname;
                }

                //String userRole = "Implement role" //tempObject.get("USER_ROLE").toString();
                //User user = new User(userId +"", userEmail, userImageUrl, userName, userSurname, url);
                Hashtable tempObjectHash = new Hashtable();
                Image img = null;
                try {
                    InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/placeholder.png");//TEMP
                    EncodedImage placeHolder = EncodedImage.create(is);
                    Utility u = new Utility();

                    if (userImageUrl != null) {

                        img = URLImage.createToStorage(placeHolder, userImageUrl, userImageUrl, URLImage.RESIZE_SCALE);

                    } else {
                        img = placeHolder;
                    }
                    img = u.maskImage(img);

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                //list
                tempObjectHash.put("btnIcon", img);
                tempObjectHash.put("lblTitle", fullName);

                //model
                tempObjectHash.put("parseObject", tempObject);

                table[i] = tempObjectHash;

            }

        } catch (ParseException e) {
            Log.p("[UserService.getUsersHashtable(..) ParseException=" + "",
                    Log.DEBUG);
        }

        return table;

    }

    public List<User> getUsers() {

        List<User> users = new ArrayList<User>();
//        String url = "http://" + Const.server + "/TaskManagementApp/UserServices.php";
//        ConnectionRequest cr = new ConnectionRequest();
//        cr.setUrl(url);
//        cr.addArgument("actionType", "allUsers");
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
//             Dialog.show("list", list.toString(), "Okay", null);
//
//
//            for (int i = 0; i < list.size(); i++) {
//
//                Hashtable tempObject = (Hashtable) list.get(i);
//                String userId = tempObject.get("USER_ID").toString();
//                String userEmail = tempObject.get("USER_EMAIL").toString();
//                String userImageUrl = tempObject.get("USER_IMAGE_URL").toString();//PROJECT_DESCRIPTION	
//                String userName = tempObject.get("USER_NAME").toString();
//                String userSurname = tempObject.get("USER_SURNAME").toString();
//                String userRole = tempObject.get("USER_ROLE").toString();
//                User user = new User(userId +"", userEmail, userImageUrl, userName, userSurname, url);
//                users.add(user);
//            }
//        }

        return users;

    }

    public static User getUser(String emailParam, String password) {
        User user = new User();
//        TODO MOVE TO SERVICE
//        String url = "http://mfactoryazure.cloudapp.net:8080/TaskManagementApp/UserServices.php";
//        String url = "http://" + Const.server + "/TaskManagementApp/UserServices.php";
//        ConnectionRequest cr = new ConnectionRequest(url);
//        cr.addArgument("actionType", "login");
//        cr.addArgument("email", emailParam);
//        cr.addArgument("password", password);
//        cr.setPost(true);
//
//        NetworkManager.getInstance().addToQueueAndWait(cr);
//        if (cr.getResponseData() != null) {
//            String data = new String(cr.getResponseData());
//             Dialog.show("Ok", data, "Ok", null);
//
//            Result result = Result.fromContent(data, Result.JSON);
//            String status = result.getAsString("/status");
//            String msg = result.getAsString("/msg");
//            String email = result.getAsString("/userEmail");
//            String userImageUrl = result.getAsString("/userImageUrl");
//            String userName = result.getAsString("/userName");
//            String userSurname = result.getAsString("/userSurname");
//            if (msg.startsWith("Succ")) {
//                user = new User();
//                user.setUserEmail(email);
//                user.setUserImageUrl(userImageUrl);
//                user.setUserId(result.getAsString("/userId"));
//                user.setUserName(userName);
//                user.setUserSurname(userSurname);
//                Dialog.show("Ok", "userId=" + userId, "Ok", null);
//            }
//        }
        return user;
    }

}
