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
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author PC
 */
public class CommunicationService {

    public List<Communication> getAllCommunication(ParseUser user) {

        List<Communication> comm = new ArrayList<Communication>();
        List<ParseObject> parseComm = new ArrayList<ParseObject>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery(Const.PARSE_CLASS_COMMUNICATION);
        //query.whereEqualTo("user", user);

        try {
            parseComm = query.find();
            for (ParseObject object : parseComm) {

                Communication c = new Communication();

                String email = object.getString("email");
                String userName = object.getString("userName");
                if (userName == null || userName.length() == 0) {
                    c.setUserName(email);
                } else {
                    c.setUserName(userName);
                }
                c.setEmail(email);

                c.setTitle(object.getString("message"));
                c.setMessage(object.getString("message"));
                c.setDate(object.getCreatedAt());
                c.setParseObject(object);

                comm.add(c);
            }
        } catch (ParseException e) {
            Log.p("[CommunicationService.getAllCommunication(..) ParseException=" + "",
                    Log.DEBUG);
        }

        return comm;

    }
}
