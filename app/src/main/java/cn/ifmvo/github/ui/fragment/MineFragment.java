package cn.ifmvo.github.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;
import cn.droidlover.xdroidmvp.utils.imageloader.ILFactory;
import cn.droidlover.xdroidmvp.utils.imageloader.ILoader;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.sp.SPUtil;
import cn.ifmvo.github.ui.activity.ReposListActivity;
import cn.ifmvo.github.ui.activity.SettingActivity;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class MineFragment extends XLazyFragment {

    ImageView ivHead;
    TextView tvName, tvLoginName, tvCompany, tvPosition, tvEmail, tvWebsite, tvReposNum;
    View viewRepos, viewSetting;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ivHead = (ImageView) $(R.id.ivHead);
        tvName = (TextView) $(R.id.tvName);
        tvLoginName = (TextView) $(R.id.tvLoginName);
        tvReposNum = (TextView) $(R.id.tvReposNum);
        viewRepos = $(R.id.viewRepos);
        viewSetting = $(R.id.viewSetting);
//        tvCompany = (TextView) $(R.id.tvCompany);
//        tvPosition = (TextView) $(R.id.tvPosition);
//        tvEmail = (TextView) $(R.id.tvEmail);
//        tvWebsite = (TextView) $(R.id.tvWebsite);
        refreshData();

        viewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.newIntent(context)
                        .to(SettingActivity.class)
                        .launch();
            }
        });

//        BusProvider.getBus().toObservable(LoginSuccessEvent.class)
//                .subscribe(new Action1<LoginSuccessEvent>() {
//                    @Override
//                    public void call(LoginSuccessEvent loginSuccessEvent) {
//                        refreshData();
//                    }
//                });
    }


    public void refreshData(){
        BeanUser user = SPUtil.getInstance().getUser();
        if (user != null){
            ILFactory.getLoader().loadNet(ivHead, user.avatar_url, new ILoader.Options(R.mipmap.ic_default_github, R.mipmap.ic_default_github));
            tvName.setText(user.name);
            tvLoginName.setText(user.login);
            tvReposNum.setText(String.valueOf(user.public_repos));
            if (user.public_repos != 0){
                viewRepos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Router.newIntent(context)
                                .to(ReposListActivity.class)
                                .launch();
                    }
                });
            }
    //        tvCompany.setText(user.company);
    //        tvEmail.setText(user.email);
    //        tvWebsite.setText(user.blog);
    //        tvPosition.setText(user.location);
        }
    }

    @Override
    public Object newP() {
        return null;
    }
}
