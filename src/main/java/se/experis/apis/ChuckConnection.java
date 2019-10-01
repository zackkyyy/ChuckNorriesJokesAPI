package se.experis.apis;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;



public class ChuckConnection {
    final String startPointURl ="https://api.chucknorris.io/";

    public ArrayList<String> getAllCategories() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
       JSONArray jsonArray= new JSONArray(requestURL(startPointURl+"/jokes/categories"));
        for (int i = 0; i <jsonArray.length() ; i++) {
            arrayList.add(jsonArray.get(i).toString());
        }

        return arrayList;
    }

    public String getRandomJoke() throws Exception{
        JSONObject joke = new JSONObject(requestURL("https://api.chucknorris.io/jokes/random"));
        return joke.get("value").toString();
    }
    public JSONObject getRandomJokes() throws Exception{
        JSONObject joke = new JSONObject(requestURL("https://api.chucknorris.io/jokes/random"));
        return joke;
    }

    public String  getRandomFromCategory(String cat) throws Exception {
        JSONObject jsonObject= new JSONObject(requestURL(startPointURl+ "jokes/random?category="+cat));
       // System.out.println(jsonObject.get("value").toString());
         return jsonObject.get("value").toString();
    }


    public  String requestURL(String url) throws Exception{
        // Set URL
        URLConnection connection = new URL(url).openConnection();
        // Set property - avoid 403 (CORS)
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        // Create connection
        connection.connect();
        // Create a buffer of the input
        BufferedReader buffer  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        // Convert the response into a single string
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = buffer.readLine()) != null) {
            stringBuilder.append(line);
        }
        // return the response
        return stringBuilder.toString();
    }
}
