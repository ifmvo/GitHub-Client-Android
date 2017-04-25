package cn.ifmvo.github.ui.activity;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.utils.Logger.Logger;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.presenter.UserPresenter;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */
public class UserActivity extends BaseActivityTopBar<UserPresenter> {
    @Override
    public UserPresenter newP() {
        return new UserPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user;
    }

    @Override
    protected void init() {
        getP().getUser("ifmvo");
    }

    @Override
    protected void postLoad() {

    }

    public void showError(String msg){
        Logger.e(msg);
    }

    public void showData(BeanUser beanUser){
        Logger.e(beanUser.toString());
    }
}
