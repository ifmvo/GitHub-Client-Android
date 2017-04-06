package cn.ifmvo.github.presenter;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubcriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.net.Api;
import cn.ifmvo.github.ui.UserActivity;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class UserPresenter extends XPresent<UserActivity> {

    public void getUser(String user){

        Api.getGitHubService().getUser(user)
                .compose(XApi.<BeanUser>getScheduler())
                .compose(XApi.<BeanUser>getApiTransformer())
                .compose(getV().<BeanUser>bindToLifecycle())
                .subscribe(new ApiSubcriber<BeanUser>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error.getMessage());
                    }

                    @Override
                    public void onNext(BeanUser beanUser) {
                        getV().showData(beanUser);
                    }
                });
    }

}
