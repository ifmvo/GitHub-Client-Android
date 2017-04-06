package cn.droidlover.xdroidmvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import cn.droidlover.xdroidmvp.base.adapter.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.mvp.IPresent;

/**
 * Created by ifmvo on 17-3-23.
 */

public abstract class BaseFragmentRecyclerView<T, P extends IPresent> extends XLazyFragment<P> {

    @Override
    public int getLayoutId() {
        return 0;
    }


    @Override
    public void initData(Bundle savedInstanceState) {

    }
    @NonNull
    protected abstract SimpleRecAdapter getAdapter();
    protected abstract void getData(int page);

}
