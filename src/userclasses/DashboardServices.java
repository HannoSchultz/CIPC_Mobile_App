/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userclasses;

import ca.weblite.codename1.json.JSONArray;
import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.parse4cn1.ParseCloud;
import com.parse4cn1.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author sandraarnolds
 */
public class DashboardServices {

    public static List<Weather> getWeather() {

        java.util.List<Weather> list = new ArrayList<Weather>();

        HashMap<String, String> map = new HashMap<>();
        map.put("param1", "value1");
        try {
            String json = ParseCloud.callFunction("getWeather", map);//taskReport
            //JSONObject json = ParseCloud.callFunction("taskGraph", map);//taskReport

            JSONObject root = new JSONObject(json);
            JSONArray arr = root.getJSONArray("list");

            for (int i = 0; i < arr.length(); i++) {

                JSONObject o = arr.getJSONObject(i);

                JSONArray weather = o.getJSONArray("weather");
                String description = weather.getJSONObject(0).getString("description");

                JSONObject main = o.getJSONObject("main");
                String id = o.getString("id");
                String name = o.getString("name");

                String temp = main.getString("temp");
                String temp_min = main.getString("temp_min");
                String humidity = main.getString("humidity");
                String temp_max = main.getString("temp_max");
                //SimpleDateFormat s = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");

                Weather w = new Weather();
                w.setDescription(description);
                w.setId(id);
                w.setName(name);
                w.setTemp(temp);
                w.setTemp_min(temp_min);
                w.setTemp_max(temp_max);
                w.setHumidity(humidity);
                list.add(w);

            }

            //Log.p("Weather: " + list, Log.DEBUG);
            //Log.p("json=" + json, Log.DEBUG);
        } catch (JSONException e) {
            Log.p("Error parsing weather json: " + "", Log.DEBUG);
        } catch (ParseException e) {
            Log.p("Error gettting weather ParseException=" + e);
        }

        return list;
    }

    public static List<Tweet> getTweets(String screen_name_param) {

        java.util.List<Tweet> list = new ArrayList<Tweet>();
        ConnectionRequest request = new ConnectionRequest();
        request.setUrl("https://mobilityera.co.za:1338/tweets/" + screen_name_param);
        request.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(request);
        String data = new String(request.getResponseData());
        Log.p("Got Tweets for screen name=" + screen_name_param, Log.DEBUG);
        try {
            JSONArray arr = new JSONArray(data);

            for (int i = 0; i < arr.length(); i++) {

                JSONObject o = arr.getJSONObject(i);
                JSONObject userJson = o.getJSONObject("user");

                String created_at = o.getString("created_at");
                String text = o.getString("text");
                String screen_name = userJson.getString("screen_name");

                SimpleDateFormat s = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
                Date date = null;

                try {
                    date = s.parse(created_at);
                } catch (com.codename1.l10n.ParseException e) {
                    Log.p("Error parsing Twitter date created. " + "", Log.DEBUG);
                }

                //Log.p(created_at + " created_at: " + date + "text: " + text + "screen_name: " + screen_name, Log.DEBUG);
                Tweet tweet = new Tweet();
                tweet.setCreated_at(date);
                tweet.setScreen_name(screen_name);
                tweet.setText(text);
                list.add(tweet);

            }
            Log.p("Get Tweets=" + list.size(), Log.DEBUG);

        } catch (JSONException e) {
            Log.p("Error parsing twitter json: " + "", Log.DEBUG);
        }
        return list;
    }

    public static Hashtable getCurrencies() {
        Hashtable hash = new Hashtable<String, String>();
        ConnectionRequest cr = new ConnectionRequest();
        cr.setPost(false);
        cr.setUrl("https://download.finance.yahoo.com/d/quotes.csv?s=USDZAR=X&f=sl1d1t1ba&e=.csv");
        NetworkManager.getInstance().addToQueueAndWait(cr);
        String USDoller_to_Rand = new String(cr.getResponseData());
        cr.setUrl("https://download.finance.yahoo.com/d/quotes.csv?s=GBPZAR=X&f=sl1d1t1ba&e=.csv");
        NetworkManager.getInstance().addToQueueAndWait(cr);
        String Pound_to_Rand = new String(cr.getResponseData());
        cr.setUrl("https://download.finance.yahoo.com/d/quotes.csv?s=EURZAR=X&f=sl1d1t1ba&e=.csv");
        NetworkManager.getInstance().addToQueueAndWait(cr);
        String Euro_to_Rand = new String(cr.getResponseData());

        hash.put("dollar", tokenize(USDoller_to_Rand));
        hash.put("pound", tokenize(Pound_to_Rand));
        hash.put("euro", tokenize(Euro_to_Rand));

        return hash;
    }

    public static String tokenize(String currency) {
        StringTokenizer st = new StringTokenizer(currency, ",");
        ArrayList list = new ArrayList();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        return list.get(1).toString();
    }

}
