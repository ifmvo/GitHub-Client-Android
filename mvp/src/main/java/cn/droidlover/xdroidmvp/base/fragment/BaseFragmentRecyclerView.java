package cn.droidlover.xdroidmvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import cn.droidlover.xdroidmvp.R;
import cn.droidlover.xdroidmvp.base.ErrorView;
import cn.droidlover.xdroidmvp.base.adapter.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.utils.Logger.Logger;
import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import cn.droidlover.xrecyclerview.XRecyclerView;

import static android.view.View.inflate;

/**
 * Created by ifmvo on 17-3-23.
 */

public abstract class BaseFragmentRecyclerView<T, P extends IPresent> extends XLazyFragment<P> {

    XRecyclerContentLayout recyclerContentLayout;
    XRecyclerView recyclerView;
    ErrorView errorView;

    @Override
    public int getLayoutId() {
        return R.layout.base_fragment_recyclerview;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        recyclerContentLayout = (XRecyclerContentLayout) $(R.id.recyclerViewContentLayout);
        recyclerView = recyclerContentLayout.getRecyclerView();

        recyclerContentLayout.loadingView(inflate(context, R.layout.view_loading, null));

        errorView = new ErrorView(context);
        errorView.setOnErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(1);
            }
        });
        recyclerContentLayout.errorView(errorView);
        recyclerView.useDefLoadMoreView();

        recyclerView.setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                getData(1);
            }

            @Override
            public void onLoadMore(int page) {
                getData(page);
            }
        });

        recyclerView.setAdapter(getAdapter());
        getAdapter().setRecItemClick(new RecyclerItemCallback<T, RecyclerView.ViewHolder>(){
            @Override
            public void onItemClick(int position, T model, int tag, RecyclerView.ViewHolder holder) {
                Logger.e("position:" + position + ",model:" + model + ",tag:" + tag);
            }
        });


        getData(1);
    }
    @NonNull
    protected abstract SimpleRecAdapter getAdapter();
    protected abstract void getData(int page);

    public void showLoading(){
        recyclerContentLayout.showLoading();
    }

    public void showData(int page, List<?> list) {
        if (page > 1) {
            getAdapter().addData(list);
        } else {
            getAdapter().setData(list);
        }

        if (getAdapter().getItemCount() < 1) {
            showEmpty();
        }
    }

    public void showError(String msg){
        errorView.setErrorMsg(msg);
        recyclerContentLayout.showError();
    }

    public void showEmpty(){
        recyclerContentLayout.showEmpty();
    }

}
