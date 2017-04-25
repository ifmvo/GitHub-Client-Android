package cn.ifmvo.github.ui.fragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.droidlover.xdroidmvp.base.fragment.BaseFragmentRecyclerView;
import cn.droidlover.xdroidmvp.utils.Logger.Logger;
import cn.droidlover.xdroidmvp.utils.toast.Toaster;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.net.Common;
import cn.ifmvo.github.presenter.ReposPresenter;
import cn.ifmvo.github.sp.SPUtil;
import space.sye.z.library.adapter.BaseViewHolder;
import space.sye.z.library.adapter.QuickRecycleAdapter;

import static cn.ifmvo.github.R.id.viewColor;

/**
 *
 * Created by ifmvo on 17-4-6.
 */
public class ReposListFragment extends BaseFragmentRecyclerView<ReposPresenter> {

    QuickRecycleAdapter<BeanRepos> adapter;

    int space = 16;

    @Override
    public ReposPresenter newP() {
        return new ReposPresenter();
    }

    @Override
    public void initView() {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = space/2;
                outRect.bottom = space/2;
                outRect.left = space;
                outRect.right = space;
            }
        });
    }

    @Override
    public void getData(int indexPage, int pageSize) {
        BeanUser user = SPUtil.getInstance().getUser();
        if (user != null){
            getP().listUserRepos(user.login, indexPage, pageSize, Common.ReposType.all, Common.ReposSort.created, "");
        }
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new QuickRecycleAdapter<BeanRepos>(getContext(), R.layout.list_item_repos) {
            @Override
            protected void onSetItemData(BaseViewHolder holder, BeanRepos item, int viewType) {
                //名
                holder.setText(R.id.tvName, item.name);

                //描述
                if (item.description == null){
                    holder.setVisible(R.id.tvDescription, false);
                }else{
                    holder.setVisible(R.id.tvDescription, true);
                    holder.setText(R.id.tvDescription, item.description);
                }
                //语言
                TextView tvLanguage = holder.getView(R.id.tvLanguage);
                View view = holder.getView(viewColor);
                if (item.language != null){
                    tvLanguage.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                    tvLanguage.setText(item.language);
                    view.setBackgroundResource(Common.LanguageColor.getColor(item.language));
                }else{
                    tvLanguage.setVisibility(View.GONE);
                    view.setVisibility(View.GONE);
                }
                //收藏
                TextView tvWatchers = holder.getView(R.id.tvWatchers);
                if (item.watchers_count == 0){
                    tvWatchers.setVisibility(View.GONE);
                }else{
                    tvWatchers.setVisibility(View.VISIBLE);
                    tvWatchers.setText(String.valueOf(item.watchers_count));
                    tvWatchers.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_watchers, 0, 0, 0);
                }

                //fork
                TextView tvFork = holder.getView(R.id.tvFork);
                if (item.forks_count == 0){
                    tvFork.setVisibility(View.GONE);
                }else{
                    tvFork.setVisibility(View.VISIBLE);
                    tvFork.setText(String.valueOf(item.forks_count));
                    tvFork.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_fork, 0, 0, 0);
                }

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

    public void showError(String msg){
        Toaster.showLong(context, msg);
    }
}
