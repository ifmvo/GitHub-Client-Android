package cn.ifmvo.github.ui.login;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.ifmvo.github.R;
import cn.ifmvo.github.presenter.UserPresenter;

/**
 * Created by ifmvo on 17-4-7.
 */

public class LoginActivity extends BaseActivityTopBar<UserPresenter> {
    @Override
    public UserPresenter newP() {
        return new UserPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void postLoad() {

    }
}
