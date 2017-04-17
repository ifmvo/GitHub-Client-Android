package cn.ifmvo.github.ui.mine;

import android.view.View;
import android.widget.TextView;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.GitHubApp;
import cn.ifmvo.github.R;
import cn.ifmvo.github.ui.login.LoginActivity;

/**
 * Created by Matthew_Chen on 2017/4/12.
 */

public class SettingActivity extends BaseActivityTopBar {

    TextView tvLogout;


    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        setTitle("设置");
        setTopLeftButton();
//        setTopRightButton(R.drawable.ic_mine_black_24dp, new OnClickListener() {
//            @Override
//            public void onClick() {
//
//            }
//        });

        tvLogout = (TextView) findViewById(R.id.tvLogout);

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GitHubApp.getAppContextBase().finishAllActivity();
                Router.newIntent(context)
                        .to(LoginActivity.class)
                        .launch();
            }
        });

    }

    @Override
    protected void postLoad() {

    }
}
