package cn.ifmvo.github.presenter;

import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubcriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.net.Api;
import cn.ifmvo.github.ui.index.ReposListFragment;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class ReposPresenter extends XPresent<ReposListFragment> {

    /**
     * 获取 username 的仓库
     */
    public void listUserRepos(String username, final int page, int per_page, String type, String sort, String direction){
        Api.getGitHubService().listUserRepos(username, page, per_page, type, sort, direction)
                .compose(XApi.<List<BeanRepos>>getApiTransformer())
                .compose(XApi.<List<BeanRepos>>getScheduler())
                .compose(getV().<List<BeanRepos>>bindToLifecycle())
                .subscribe(new ApiSubcriber<List<BeanRepos>>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error.getMessage());
//                        Logger.e(error.getMessage());
                    }

                    @Override
                    protected void onPre() {
//                        getV().showLoading();
                    }

                    @Override
                    public void onNext(List<BeanRepos> beanReposes) {
                        getV().showData(beanReposes);
                    }
                });
    }
}
