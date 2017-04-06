package cn.ifmvo.github.ui.index;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.List;

import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;

import cn.ifmvo.github.adapter.ReposAdapter;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.net.Common;
import cn.ifmvo.github.presenter.ReposPresenter;

import static cn.droidlover.xdroidmvp.R.id.recyclerView;

/**
 * Created by ifmvo on 17-4-6.
 */

public class ReposListFragment extends XLazyFragment<ReposPresenter> {

//    @BindView(R.id.recyclerViewContentLayout)

    ReposAdapter reposAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_repos;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        recyclerView = (XRecyclerView) $(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        reposAdapter = new ReposAdapter(context);
        recyclerView.setAdapter(reposAdapter);
        reposAdapter.setRecItemClick(new RecyclerItemCallback<BeanRepos, ReposAdapter.ReposViewHolder>() {
            @Override
            public void onItemClick(int position, BeanRepos model, int tag, ReposAdapter.ReposViewHolder holder) {
                Toast.makeText(context, model.clone_url, Toast.LENGTH_SHORT).show();
            }
        });
        getP().listUserRepos("ifmvo", 1, 10, "", Common.sort.created, "");
    }

    @Override
    public ReposPresenter newP() {
        return new ReposPresenter();
    }

    public void showData(int page, List<BeanRepos> list) {
        reposAdapter.setData(list);
        reposAdapter.notifyDataSetChanged();
//        recyclerContentLayout.showContent();
//        if (page > 1) {
//            reposAdapter.addData(list);
//        } else {
//            reposAdapter.setData(list);
//        }
//        recyclerContentLayout.getRecyclerView().setPage(page, 10);

//        if (getAdapter().getItemCount() < 1) {
//            showEmpty();
//        }
    }

}
