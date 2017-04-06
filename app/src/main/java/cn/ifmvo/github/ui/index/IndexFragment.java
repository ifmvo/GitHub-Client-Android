package cn.ifmvo.github.ui.index;

import android.support.annotation.NonNull;

import cn.droidlover.xdroidmvp.base.adapter.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.base.fragment.BaseFragmentRecyclerView;
import cn.ifmvo.github.adapter.ReposAdapter;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.net.Common;
import cn.ifmvo.github.presenter.ReposPresenter;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class IndexFragment extends BaseFragmentRecyclerView<BeanRepos, ReposPresenter> {

    ReposAdapter reposAdapter;

    @Override
    public ReposPresenter newP() {
        return new ReposPresenter();
    }

    @NonNull
    @Override
    protected SimpleRecAdapter getAdapter() {
        if (reposAdapter == null){
            reposAdapter = new ReposAdapter(context);
        }
        return reposAdapter;
    }

    @Override
    protected void getData(int page) {
        getP().listUserRepos("ifmvo", page, 10, "", Common.sort.created, "");
    }
}
