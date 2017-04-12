package cn.ifmvo.github.ui;


import android.view.View;

import java.util.concurrent.TimeUnit;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.sp.SPUtil;
import cn.ifmvo.github.ui.login.LoginActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by ifmvo on 17-4-7.
 */

public class SplashActivity extends BaseActivityTopBar {
    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        toolbar.setVisibility(View.GONE);

        Observable.timer(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map(new Func1<Long, Class>() {
                    @Override
                    public Class call(Long aLong) {
                        BeanUser user = SPUtil.getInstance().getUser();
                        if (user != null)

                            return MainActivity.class;
                        return LoginActivity.class;
                    }
                })
                .subscribe(new Action1<Class>() {
                    @Override
                    public void call(Class aClass) {
                        Router.newIntent(context)
                                .to(aClass)
                                .launch();

                        finish();
                    }
                });
    }

    @Override
    protected void postLoad() {

    }
}
