package cn.droidlover.xdroidmvp.utils.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import cn.droidlover.xdroidmvp.XDroidConf;

/**
 * Created by Matthew_Chen on 16/9/19.
 */
public class PreferBaseUtil {

    private static String name = XDroidConf.CACHE_SP_NAME;

    protected static SharedPreferences sp;
    protected static SharedPreferences.Editor editor;

    public static void init(Context context, String Preference_Shared_Name) {
        if (sp == null){
            name = Preference_Shared_Name;
            sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        }
        editor = sp.edit();
    }

    public static void init(Context context) {
        if (sp == null){
            sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        }
        editor = sp.edit();
    }

    protected void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    protected long getLong(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    protected void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    protected int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    protected void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    protected String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    protected void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    protected boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    protected boolean remove(String key) {
        return editor.remove(key).commit();
    }
}

