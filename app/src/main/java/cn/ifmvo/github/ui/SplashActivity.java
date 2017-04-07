package cn.ifmvo.github.ui;


import java.util.concurrent.TimeUnit;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

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
        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Router.newIntent(context)
                        .to(MainActivity.class)
                        .launch();
            }
        });
    }

    @Override
    protected void postLoad() {

    }
}
