package cn.ifmvo.github.ui.index;

import android.os.Bundle;

import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;
import cn.ifmvo.github.R;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class MineFragment extends XLazyFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public Object newP() {
        return null;
    }
}
