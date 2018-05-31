/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
import com.codename1.io.Log;
import com.parse4cn1.ParseCloud;
import com.parse4cn1.ParseException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author sandraarnolds
 */
public class ReportsService {

    public static Map<String, Integer> getTaskReport() {
        Map<String, Integer> myHashMap = new HashMap<String, Integer>();
        try {
            JSONObject helloWorld = ParseCloud.callFunction("taskGraph", myHashMap);//taskReport
            myHashMap.put("notStarted", helloWorld.getInt("notStarted"));
            myHashMap.put("started", helloWorld.getInt("started"));
            myHashMap.put("completed", helloWorld.getInt("completed"));
            return myHashMap;
        } catch (ParseException e) {
            Log.p("Error calling ParseCloud ParseException: " + "", Log.DEBUG);
        } catch (JSONException e) {
            Log.p("Error calling ParseCloud JSONException: " + "", Log.DEBUG);
        }

        return null;

    }
}
