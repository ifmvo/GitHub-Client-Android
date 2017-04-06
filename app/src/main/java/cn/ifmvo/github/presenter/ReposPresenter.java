package cn.ifmvo.github.presenter;

import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubcriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import cn.ifmvo.github.bean.BeanGitHubResult;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.net.Api;
import cn.ifmvo.github.ui.index.IndexFragment;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class ReposPresenter extends XPresent<IndexFragment> {

    /**
     * 获取 username 的仓库
     */
    public void listUserRepos(String username,int page, int per_page, String type, String sort, String direction){
        Api.getGitHubService().listUserRepos(username, page, per_page, type, sort, direction)
                .compose(XApi.<BeanGitHubResult<List<BeanRepos>>>getApiTransformer())
                .compose(XApi.<BeanGitHubResult<List<BeanRepos>>>getScheduler())
                .compose(getV().<BeanGitHubResult<List<BeanRepos>>>bindToLifecycle())
                .subscribe(new ApiSubcriber<BeanGitHubResult<List<BeanRepos>>>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error.getMessage());
                    }

                    @Override
                    public void onNext(BeanGitHubResult<List<BeanRepos>> listBeanGitHubResult) {
                        getV().showData(1, listBeanGitHubResult.data);
                    }
                });
    }
}
