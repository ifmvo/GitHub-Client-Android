package cn.droidlover.xdroidmvp.base.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.droidlover.xdroidmvp.R;
import cn.droidlover.xdroidmvp.mvp.IPresent;
import space.sye.z.library.RefreshRecyclerView;
import space.sye.z.library.adapter.RefreshRecyclerViewAdapter;
import space.sye.z.library.listener.OnBothRefreshListener;
import space.sye.z.library.listener.OnLoadMoreListener;
import space.sye.z.library.listener.OnPullDownListener;
import space.sye.z.library.manager.RecyclerMode;
import space.sye.z.library.manager.RefreshRecyclerAdapterManager;

/**
 *
 * Created by ifmvo on 17-3-23.
 */
public abstract class BaseFragmentRecyclerView<P extends IPresent> extends XLazyFragment<P> {

    protected RefreshRecyclerView recyclerView;
    protected RefreshRecyclerAdapterManager refreshRecyclerAdapterManager;

    protected LinearLayout listTopLay, listBottomLay, listTopFloatLay;
    protected RelativeLayout layParent;
    protected View errorLay;
    protected Button btnErrorRefresh;

    boolean canLoadMore = true;
    int mIndexPage = 1;
    boolean isLoading = false;
    int pageSize = 20;

    @Override
    public int getLayoutId() {
        return R.layout.base_fragment_recyclerview;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        btnErrorRefresh = (Button) $(R.id.btnErrorRefresh);
        listTopLay = (LinearLayout) $(R.id.listTopLay);
        listBottomLay = (LinearLayout) $(R.id.listBottomLay);
        listTopFloatLay = (LinearLayout) $(R.id.listTopFloatLay);
        layParent = (RelativeLayout) $(R.id.layParent);
        errorLay = $(R.id.errorLay);
        recyclerView = (RefreshRecyclerView) $(R.id.pull_refresh_list);

        refreshRecyclerAdapterManager = new RefreshRecyclerAdapterManager(getAdapter(), getLayoutManager());
        refreshRecyclerAdapterManager.setMode(getRecyclerMode())
                .addHeaderView(getHeadView())
                .addHeaderView(getSecondHeadView())
                .addHeaderView(getThirdHeadView())
                .addFooterView(getFootView())
                .addFooterView(getSecondFootView())
                .addFooterView(getThirdFootView())
                .setOnBothRefreshListener(new OnBothRefreshListener() {
                    @Override
                    public void onPullDown() {
                        refresh();
                    }

                    @Override
                    public void onLoadMore() {
                        loadMore();
                    }
                })
                .setOnPullDownListener(new OnPullDownListener() {
                    @Override
                    public void onPullDown() {
                        refresh();
                    }
                })
                .setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        loadMore();
                    }
                })
                .setOnItemClickListener(new RefreshRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerView.ViewHolder holder, int position) {
                        onListItemClick(holder, position);
                    }
                })
                .into(recyclerView, getContext());

        btnErrorRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onErrorRefreshBtnClick()) {
                    onErrorClick();
                }
            }
        });

        initView();
        getData(mIndexPage, pageSize);

    }

    protected boolean onErrorRefreshBtnClick() {
        return true;
    }

    private void onErrorClick() {
        errorLay.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        refresh();
    }

    protected void setRefreshComplete(long loadingTime) {
        isLoading = false;
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshRecyclerAdapterManager.onRefreshCompleted();
            }
        }, loadingTime);
    }

    protected void setRefreshComplete() {
        isLoading = false;
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshRecyclerAdapterManager.onRefreshCompleted();
            }
        }, 400);
    }

    /**
     * 加载到底的时候调用
     */
    protected void setLoadEnd() {
        refreshRecyclerAdapterManager.onLoadEnd();
        setCanLoadMore(false);
    }

    /**
     * 加载失败的时候调用
     *
     * @param errorStr
     */
    protected void setLoadError(String errorStr) {
        errorLay.setVisibility(View.VISIBLE);
        btnErrorRefresh.setText(errorStr);
//        recyclerView.setVisibility(View.GONE);
    }

    protected void setLoadError(int drawableRes, String errorStr, View.OnClickListener onClickListener) {
        isLoading = false;
        btnErrorRefresh.setCompoundDrawablesWithIntrinsicBounds(0, drawableRes, 0, 0);
        if (onClickListener != null) {
            btnErrorRefresh.setOnClickListener(onClickListener);
        } else {
            btnErrorRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onErrorRefreshBtnClick()) {
                        onErrorClick();
                    }
                }
            });
        }
        setLoadError(errorStr);
    }

    protected void setLoadError(int drawableRes, String errorStr) {
        setLoadError(drawableRes, errorStr, null);
    }


    /**
     * true 上下都可以拉
     * false 都不可以啦
     * @param canRefresh
     */
    public void setCanRefresh(boolean canRefresh) {
        recyclerView.setMode(canRefresh ? RecyclerMode.BOTH : RecyclerMode.NONE);
    }

    /**
     * true 上下都可以拉
     * false 上拉 下不啦
     * @param canLoadMore
     */
    public void setCanLoadMore(boolean canLoadMore) {
        recyclerView.setMode(canLoadMore ? RecyclerMode.BOTH : RecyclerMode.TOP);
        this.canLoadMore = canLoadMore;
        refreshRecyclerAdapterManager.onRefreshCompleted();
    }


    /**
     * 下拉，点击刷新 的时候触发
     */
    protected void refresh() {
        setCanLoadMore(true);
        mIndexPage = 1;
        isLoading = true;
//        startRefresh();
        getData(mIndexPage, pageSize);
    }

    /**
     * 上拉到底的时候触发
     */
    protected void loadMore() {
        if (canLoadMore) {
            mIndexPage++;
            isLoading = true;
            getData(mIndexPage, pageSize);
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    protected RecyclerMode getRecyclerMode() {
        return RecyclerMode.BOTH;
    }

    protected View getHeadView() {
        return null;
    }

    protected View getSecondHeadView() {
        return null;
    }

    protected View getThirdHeadView() {
        return null;
    }

    protected View getFootView() {
        return null;
    }

    protected View getSecondFootView() {
        return null;
    }

    protected View getThirdFootView() {
        return null;
    }

    public abstract void initView();

    public abstract void getData(int indexPage, int pageSize);

    public abstract RecyclerView.Adapter getAdapter();

    public abstract void onListItemClick(RecyclerView.ViewHolder holder, int position);

}
