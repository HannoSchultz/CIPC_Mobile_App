/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import com.codename1.io.Log;
import com.parse4cn1.ParseException;
import com.parse4cn1.ParseObject;
import com.parse4cn1.ParseQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sandraarnolds
 */
public class PushNotificationService {

    public static List<ParseObject> getPushDeviceIds(String deviceId) {
        List<ParseObject> listDeviceId = null;
        try {
            ParseQuery<ParseObject> query = ParseQuery.getQuery(Const.PARSE_CLASS_PUSHCLASS);
            if (deviceId != null) {
                query.whereEqualTo("deviceId", deviceId);
            }
            Set<String> targetKeys = new HashSet<String>();
            targetKeys.add("deviceId");
            query.selectKeys(targetKeys);
            listDeviceId = query.find();

        } catch (ParseException e) {
            Log.p("PushNotificationService->getPushDeviceIds", Log.DEBUG);

        }

        return listDeviceId;
    }
}
