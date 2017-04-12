package cn.ifmvo.github.ui.index;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.droidlover.xdroidmvp.base.fragment.BaseFragmentRecyclerView;
import cn.droidlover.xdroidmvp.utils.Logger.Logger;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.net.Common;
import cn.ifmvo.github.presenter.ReposPresenter;
import cn.ifmvo.github.sp.SPUtil;
import space.sye.z.library.adapter.BaseViewHolder;
import space.sye.z.library.adapter.QuickRecycleAdapter;

/**
 *
 * Created by ifmvo on 17-4-6.
 */
public class ReposListFragment extends BaseFragmentRecyclerView<ReposPresenter> {

    QuickRecycleAdapter<BeanRepos> adapter;

    @Override
    public ReposPresenter newP() {
        return new ReposPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void getData(int indexPage, int pageSize) {
        BeanUser user = SPUtil.getInstance().getUser();
        if (user != null){
            getP().listUserRepos("ifmvo", indexPage, pageSize, "", Common.sort.created, "");
        }
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new QuickRecycleAdapter<BeanRepos>(getContext(), R.layout.list_item_repos) {
            @Override
            protected void onSetItemData(BaseViewHolder holder, BeanRepos item, int viewType) {
                holder.setText(R.id.tvTitle, item.clone_url);
            }
        };
        return adapter;
    }

    @Override
    public void onListItemClick(RecyclerView.ViewHolder holder, int position) {
        Logger.e(adapter.getItem(position).clone_url);
    }

    public void showData(List<BeanRepos> reposes){
        adapter.addAll(reposes);
    }
}
