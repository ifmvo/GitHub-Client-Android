package cn.ifmvo.github.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.fragment.XFragment;
import cn.ifmvo.github.R;
import jp.satorufujiwara.scrolling.MaterialScrollingViewPager;

/**
 * Created by ifmvo on 17-4-25.
 */

public class MineFragment2 extends XFragment {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    MaterialScrollingViewPager viewPager;
    @BindView(R.id.overlayView)
    View overlayView;
    @BindView(R.id.topView)
    View topView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine2;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
//        FragmentPagerItemAdapter pagerAdapter = new FragmentPagerItemAdapter.Builder(context)
//                .add("牛肉面", TabFragment.class)
//                .add("米粉", TabFragment.class)
//                .add("麻辣烫", TabFragment.class)
//                .add("盖饭", TabFragment.class)
//                .add("手抓饼", TabFragment.class)
//                .add("小火锅", TabFragment.class)
//                .add("烤肉", TabFragment.class)
//                .add("烤羊腿", TabFragment.class)
//                .add("喜家德", TabFragment.class)
//                .add("兰州拉面", TabFragment.class)
//                .build();
    }

    @Override
    public Object newP() {
        return null;
    }
}
