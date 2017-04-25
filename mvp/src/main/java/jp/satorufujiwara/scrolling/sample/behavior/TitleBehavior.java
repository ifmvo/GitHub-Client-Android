package jp.satorufujiwara.scrolling.sample.behavior;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;

import cn.droidlover.xdroidmvp.R;
import jp.satorufujiwara.scrolling.Behavior;


public class TitleBehavior extends Behavior {

    private final int scrollLimitHeight;

    public TitleBehavior(Resources r) {
        scrollLimitHeight = r.getDimensionPixelOffset(R.dimen.title_scroll_height);
    }

    @Override
    protected void onScrolled(View target, int scrollY, int dy) {
        ViewCompat.setTranslationY(target, -Math.min(scrollY, scrollLimitHeight));
    }
}
