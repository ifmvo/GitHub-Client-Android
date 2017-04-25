package cn.ifmvo.github.ui.activity;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;
import cn.ifmvo.github.R;
import cn.ifmvo.github.ui.fragment.ReposListFragment;

/**
 * Created by Matthew_Chen on 2017/4/12.
 */

public class ReposListActivity extends BaseActivityTopBar{
    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_content;
    }

    @Override
    protected void init() {
        setTitle("我的仓库");
        setTopLeftButton();
        replaceFragment(R.id.viewContent, XLazyFragment.newInstance(context, ReposListFragment.class));
    }

    @Override
    protected void postLoad() {

    }
}
