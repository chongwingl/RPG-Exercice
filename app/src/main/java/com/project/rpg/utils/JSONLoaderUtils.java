package com.project.rpg.utils;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laetitia on 5/5/15.
 */
public final class JSONLoaderUtils {

    private static String getJsonFromMapping(Context context, String fileName){
        String json;
        try {

            InputStream is = context.getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");
            json = json.replace("\n", "").replace(" ", "");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static JSONObject getItemsClass(Context context) {
        String json = getJsonFromMapping(context, "item_mapping.json");
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getMonstersClass(Context context) {
        String json = getJsonFromMapping(context, "monster_mapping.json");
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
