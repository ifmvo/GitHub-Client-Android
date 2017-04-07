package cn.ifmvo.github.ui;

import android.view.View;

import java.util.ArrayList;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTab;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.sp.SPUtil;
import cn.ifmvo.github.ui.index.ReposListFragment;
import cn.ifmvo.github.ui.login.LoginActivity;
import cn.ifmvo.github.ui.mine.MineFragment;

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
        items.add(new TabItem(R.drawable.ic_home_black_24dp, R.drawable.ic_home_theme_24dp, "首页", new ReposListFragment()));
        items.add(new TabItem(R.drawable.ic_mine_black_24dp, R.drawable.ic_mine_theme_24dp, "我的", new MineFragment()));
        return items;
    }

    @Override
    public View getCenterView() {
        return null;
    }
}
