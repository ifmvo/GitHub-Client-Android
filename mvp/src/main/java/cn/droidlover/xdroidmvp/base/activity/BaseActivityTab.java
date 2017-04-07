package cn.droidlover.xdroidmvp.base.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import cn.droidlover.xdroidmvp.R;
import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;

/**
 *
 * Created by ifmvo on 17-3-22.
 */

public abstract class BaseActivityTab extends BaseActivityTopBar {

    /**
     * 显示 Fragment 的
     */
    View lay_baseContent;
    /*
     * Tab 和 Fragment 之间的线
     */
//    View lay_baseLine;
    /**
     * Tab
     */
    LinearLayout lay_bottomTabs;
    /**
     *
     */
    private FragmentManager fragmentManager;
    /**
     * 所有的 Tab
     */
    private ArrayList<TabItem> tabItems;

    @Override
    protected int getLayout() {
        return R.layout.base_activity_tab;
    }

    @Override
    protected void init() {
        lay_baseContent = findViewById(R.id.lay_baseContent);
//        lay_baseLine = findViewById(R.id.lay_baseLine);
        lay_bottomTabs = (LinearLayout) findViewById(R.id.lay_bottomTabs);

        fragmentManager = getSupportFragmentManager();
        tabItems = new ArrayList<>();

    }

    @Override
    protected void postLoad() {
        initBottomTab();

        //默认是 0 的位置
        switchBottomTab(0);
    }

    /**
     * 初始化底部的Tab
     */
    private void initBottomTab() {
        tabItems.addAll(getTabItems());

        int centerIndex = tabItems.size() / 2;

        for (int i = 0; i < tabItems.size(); i++) {

            if (centerIndex == i) {
                View view = getCenterView();
                if (view != null) {
                    lay_bottomTabs.addView(view);
                }
            }

            View viewTabItem = LayoutInflater.from(context).inflate(R.layout.base_lay_tab_item, null);
            TextView tvTitle = (TextView) viewTabItem.findViewById(R.id.tvTabItemTitle);
            ImageView ivTabImg = (ImageView) viewTabItem.findViewById(R.id.ivTabItemImg);
            TextView tvCirclePoint = (TextView) viewTabItem.findViewById(R.id.tvCirclePoint);
            TabItem item = tabItems.get(i);
            ivTabImg.setImageResource(item.defDrawableResId);
            tvTitle.setText(item.title);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            viewTabItem.setLayoutParams(layoutParams);
            lay_bottomTabs.addView(viewTabItem);

            tabItems.get(i).index = i;
            tabItems.get(i).imageView = ivTabImg;
            tabItems.get(i).tvCircular = tvCirclePoint;

            final int finalI = i;
            viewTabItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchBottomTab(finalI);
                }
            });
//            tabItems.get(i).setTvCircular(hzf_tvCircular);
        }
    }

    /**
     * 跳转到 index 位置
     */
    public void switchBottomTab(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < tabItems.size(); i++) {
            TabItem tabItem = tabItems.get(i);
            if (!tabItem.fragment.isAdded()) {
                fragmentTransaction.add(R.id.lay_baseContent, tabItem.fragment);
            }
            if (index == i) {
                fragmentTransaction.show(tabItem.fragment);
                tabItem.imageView.setImageResource(tabItem.pressDrawableResId);
            } else {
                fragmentTransaction.hide(tabItem.fragment);
                tabItem.imageView.setImageResource(tabItem.defDrawableResId);
            }
        }
        fragmentTransaction.commit();
    }

    /**
     * 从继承此类的 Activity 获取
     */
    public abstract ArrayList<TabItem> getTabItems();

    /**
     * 获取底部 Tab 中间的centerView
     */
    public abstract View getCenterView();

    /**
     *
     */
    public class TabItem implements Serializable {
        /**
         * 默认的图片资源
         */
        private int defDrawableResId;
        /**
         * 点击状态的图片资源
         */
        private int pressDrawableResId;
        /**
         * 标题
         */
        private String title;
        /**
         *
         */
        private XLazyFragment fragment;
        /**
         * 索引
         */
        private int index;
        /**
         * 显示标题的TextView
         */
        private TextView textView;
        /**
         * 显示tab图片的ImageView
         */
        private ImageView imageView;
        /**
         * 小红点
         */
        private TextView tvCircular;

        public TabItem(int defDrawableResId, int pressDrawableResId, String title, XLazyFragment fragment) {
            super();
            this.defDrawableResId = defDrawableResId;
            this.pressDrawableResId = pressDrawableResId;
            this.title = title;
            this.fragment = fragment;
        }
    }


    @Override
    public Object newP() {
        return null;
    }


}
