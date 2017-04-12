package cn.ifmvo.github.sp;

import cn.droidlover.xdroidmvp.utils.JsonExplain;
import cn.droidlover.xdroidmvp.utils.sharedPreference.PreferBaseUtil;
import cn.ifmvo.github.bean.BeanUser;

/**
 * Created by ifmvo on 17-4-7.
 */

public class SPUtil extends PreferBaseUtil{

    private static SPUtil spUtil;

    public static SPUtil getInstance(){
        synchronized (SPUtil.class){
            if (spUtil == null)
                spUtil = new SPUtil();
            return spUtil;
        }
    }

    /**
     * User 信息
     * @param beanUser
     */
    public void saveUser(BeanUser beanUser){
        String str = JsonExplain.toJson(beanUser);
        putString("beanUser", str);
    }

    public BeanUser getUser(){
        return JsonExplain.explainJson(getString("beanUser", ""), BeanUser.class);
    }

    public boolean clearUser(){
        return remove("beanUser");
    }


    /**
     * 登录是否记住用户名
     * @param isRemeber
     */
//    public void saveIsRemeber(boolean isRemeber){
//        putBoolean("isRemeber", isRemeber);
//    }
//
//    public boolean getIsRemeber(){
//        return getBoolean("isRemeber", false);
//    }
//
//    public boolean clearIsRemember(){
//        return remove("isRemeber");
//    }

}
