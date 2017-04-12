package cn.droidlover.xdroidmvp.base.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.droidlover.xdroidmvp.R;
import cn.droidlover.xdroidmvp.custom.LoadingDialog;
import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.utils.toast.Toaster;

/**
 * Created by ifmvo on 17-3-21.
 */

public abstract class BaseActivityTopBar<P extends IPresent> extends BaseActivity<P> {

    private LoadingDialog loadingDialog;

    protected RelativeLayout viewSuper;
    protected ImageView ivSuperBg;
    protected LinearLayout viewSubSuper;
    protected Toolbar toolbar;
    protected View line;
    protected FrameLayout viewContent;
    protected TextView tvTitle;

    protected LayoutInflater layoutInflater;

    private int menuResId;
    private String menuStr;

    private View.OnClickListener onClickListener;

    @Override
    public int getLayoutId() {
        return R.layout.base_activity_top_bar;
    }

    @Override
    public void findView() {
        viewSuper = (RelativeLayout) findViewById(R.id.viewSuper);
        ivSuperBg = (ImageView) findViewById(R.id.ivSuperBg);
        viewSubSuper = (LinearLayout) findViewById(R.id.viewSubSuper);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        line = findViewById(R.id.line);
        viewContent = (FrameLayout) findViewById(R.id.viewContent);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        loadingDialog = new LoadingDialog(context);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        layoutInflater = LayoutInflater.from(context);
        if (getLayout() == 0){
            throw new RuntimeException("layoutRes == 0 is true");
        }
        layoutInflater.inflate(getLayout(), viewContent);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        init();
        postLoad();
    }

    protected void setTopLeftButton(int resId){
        toolbar.setNavigationIcon(resId);
    }

    protected void setTopLeftButton(){
        setTopLeftButton(R.drawable.ic_return_white_24dp);
    }

    protected void setTopRightButton(int menuResId, View.OnClickListener onClickListener){
        this.menuResId = menuResId;
        this.onClickListener = onClickListener;
    }

    protected void setTopRightButton(String menuStr, View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
        this.menuStr = menuStr;
    }

    public void showLoading(boolean canceledOnTouchOutside) {
        if (loadingDialog == null)
            loadingDialog = new LoadingDialog(context);
        loadingDialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        loadingDialog.show();
    }

    public void closeLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    public void showError(String msg){
        Toaster.showLong(context, msg);
    }

    /**
     * 设置标题
     * @param title
     */
    protected void setTitle(String title){
        tvTitle.setText(title);
    }

    protected abstract int getLayout();
    protected abstract void init();
    protected abstract void postLoad();


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menuResId != 0){
            menu.findItem(R.id.menu_1).setIcon(menuResId);
        }else{
            if (!TextUtils.isEmpty(menuStr)){
                menu.findItem(R.id.menu_1).setTitle(menuStr);

            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuResId != 0 || !TextUtils.isEmpty(menuStr)){
            getMenuInflater().inflate(R.menu.menu_activity_base_top_bar, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }else if (item.getItemId() == R.id.menu_1){
            onClickListener.onClick(null);
        }

        return true; //告诉系统我们自己处理了点击事件
    }

    protected void replaceFragment(int contentLayoutId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(contentLayoutId, fragment, fragment.getClass().getName());
        transaction.commit();
    }
}
