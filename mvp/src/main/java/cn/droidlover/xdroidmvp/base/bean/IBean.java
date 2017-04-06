package cn.droidlover.xdroidmvp.base.bean;

/**
 * Created by wanglei on 2016/12/26.
 */

public interface IBean {
    boolean isNull();       //空数据

    boolean isAuthError();  //验证错误

    boolean isBizError();   //业务错误

    String getErrorMsg();   //后台返回的错误信息
}
