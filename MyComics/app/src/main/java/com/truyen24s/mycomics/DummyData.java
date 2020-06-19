package com.truyen24s.mycomics;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.truyen24s.mycomics.model.Story;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static List<Story> getStories(Activity activity) {
        List<Story> results = new ArrayList<>();
        Gson gson = new Gson();
        results = gson.fromJson(loadJSONFromAsset(activity), new TypeToken<List<Story>>(){}.getType());
        return results;
    }
    private static String loadJSONFromAsset(Activity activity) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("stories.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
