package cn.ifmvo.github.presenter;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubcriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.droidlover.xdroidmvp.utils.event.BusProvider;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.event.LoginSuccessEvent;
import cn.ifmvo.github.net.Api;
import cn.ifmvo.github.sp.SPUtil;
import cn.ifmvo.github.ui.login.LoginActivity;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class UserPresenter extends XPresent<LoginActivity> {

    public void getUser(String user){

        Api.getGitHubService().getUser(user)
                .compose(XApi.<BeanUser>getScheduler())
                .compose(XApi.<BeanUser>getApiTransformer())
                .compose(getV().<BeanUser>bindToLifecycle())
                .subscribe(new ApiSubcriber<BeanUser>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error.getMessage());
                        getV().closeLoading();
                    }

                    @Override
                    protected void onPre() {
                        getV().showLoading(false);
                    }

                    @Override
                    public void onNext(BeanUser beanUser) {
                        SPUtil.getInstance().saveUser(beanUser);
                        BusProvider.getBus().post(new LoginSuccessEvent());

                        getV().closeLoading();

                        getV().actionMain();

                    }
                });
    }

}
