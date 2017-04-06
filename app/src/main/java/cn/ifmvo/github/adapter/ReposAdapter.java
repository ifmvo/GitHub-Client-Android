package cn.ifmvo.github.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.adapter.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.utils.KnifeKit;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanRepos;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class ReposAdapter extends SimpleRecAdapter<BeanRepos, ReposAdapter.ReposViewHolder> {


    public ReposAdapter(Context context) {
        super(context);
    }

    @Override
    public ReposViewHolder newViewHolder(View itemView) {
        return new ReposViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_repos;
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).name);
    }

    class ReposViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public ReposViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(itemView);
        }
    }
}
