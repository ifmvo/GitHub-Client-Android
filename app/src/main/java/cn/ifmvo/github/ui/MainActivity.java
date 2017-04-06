package cn.ifmvo.github.ui;

import android.view.View;

import java.util.ArrayList;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTab;
import cn.ifmvo.github.R;
import cn.ifmvo.github.ui.index.MineFragment;
import cn.ifmvo.github.ui.index.ReposListFragment;

public class MainActivity extends BaseActivityTab {

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
