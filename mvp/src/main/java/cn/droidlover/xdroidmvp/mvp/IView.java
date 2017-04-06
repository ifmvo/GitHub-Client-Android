package cn.droidlover.xdroidmvp.mvp;

import android.os.Bundle;
import android.view.View;

/**
 * Created by wanglei on 2016/12/29.
 */

public interface IView<P> {
    int getLayoutId();

    void bindUI(View rootView);

    void bindEvent();

    void initData(Bundle savedInstanceState);

    int getOptionsMenuId();

    boolean useEventBus();

    P newP();
}
