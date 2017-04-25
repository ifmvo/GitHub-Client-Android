package cn.ifmvo.github.ui.activity;

import android.view.View;

import java.util.ArrayList;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTab;
import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.sp.SPUtil;
import cn.ifmvo.github.ui.fragment.ReposListFragment;
import cn.ifmvo.github.ui.fragment.MineFragment;

public class MainActivity extends BaseActivityTab {

    @Override
    protected void init() {
        super.init();
        toolbar.setLogo(R.mipmap.ic_title_github);
        BeanUser user = SPUtil.getInstance().getUser();
        if (user == null){
            Router.newIntent(context)
                    .to(LoginActivity.class)
                    .launch();
        }
    }

    @Override
    public ArrayList<TabItem> getTabItems() {
        ArrayList<TabItem> items = new ArrayList<>();
        items.add(new TabItem(R.mipmap.ic_repos_def, R.mipmap.ic_repos_pre, "仓库", XLazyFragment.newInstance(context, ReposListFragment.class)));
        items.add(new TabItem(R.mipmap.ic_mine_def, R.mipmap.ic_mine_pre, "我的", XLazyFragment.newInstance(context, MineFragment.class)));
        return items;
    }

    @Override
    public View getCenterView() {
        return null;
    }
}
