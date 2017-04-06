package cn.droidlover.xdroidmvp.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JsonExplain {

    public class StringConverter implements JsonSerializer<String>,
            JsonDeserializer<String> {
        public JsonElement serialize(String src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            if (src == null) {
                return new JsonPrimitive("");
            } else {
                return new JsonPrimitive(src.toString());
            }
        }

        public String deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context)
                throws JsonParseException {
            return json.getAsJsonPrimitive().getAsString();
        }
    }

    public static <T> T[] explainArrayJson(String josnData, Class<T[]> clazz) {
        try {
            return getGson().fromJson(josnData, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> List<T> explainListJson(String josnData, Class<? extends Object[]> clazz) {
        try {
            Object[] arr = getGson().fromJson(josnData, clazz);
            return (List<T>) Arrays.asList(arr);
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }

    public static <T> T explainJson(String jsonData, Class<T> c) {
        try {
            Gson gson = getGson();
            return gson.fromJson(jsonData, c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Gson getGson() {
        return new Gson();
    }


    /**
     * JSon数据解析
     */
    public static String getStringValue(String response, String key) {

        try {
            if (TextUtils.isEmpty(response)) {
                return "";
            }
            JSONObject ob = new JSONObject(response);
            String value = ob.getString(key);
            if ("null".equals(value)) {
                value = "";
            }
            return value;
        } catch (JSONException e) {
            return "";
        }
    }

    /**
     * JSon数据解析
     */
    public static Integer getIntValue(String response, String key) {
        try {
            JSONObject ob = new JSONObject(response);
            int value = ob.getInt(key);
            return value;
        } catch (JSONException e) {
            return -1;
        }
    }

    /**
     * JSon数据解析
     */
    public static Long getLongValue(String response, String key) {

        try {
            JSONObject ob = new JSONObject(response);
            return ob.getLong(key);
        } catch (JSONException e) {
            return -1l;
        }
    }

    /**
     * JSon数据解析
     */
    public static Double getDoubleValue(String response, String key) {

        try {
            JSONObject ob = new JSONObject(response);
            double value = ob.getDouble(key);
            return value;
        } catch (JSONException e) {
            return -1d;
        }
    }

    /**
     * 把对象转json
     */
    public static String toJson(Object object) {
        if (object == null) return "";
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
