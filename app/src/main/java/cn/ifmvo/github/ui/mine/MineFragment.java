package cn.ifmvo.github.ui.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cn.droidlover.xdroidmvp.base.fragment.XLazyFragment;
import cn.droidlover.xdroidmvp.utils.imageloader.ILFactory;
import cn.droidlover.xdroidmvp.utils.imageloader.ILoader;
import cn.ifmvo.github.R;
import cn.ifmvo.github.bean.BeanUser;
import cn.ifmvo.github.sp.SPUtil;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class MineFragment extends XLazyFragment {

    ImageView ivHead;
    TextView tvName, tvLoginName, tvCompany, tvPosition, tvEmail, tvWebsite;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        ivHead = (ImageView) $(R.id.ivHead);
        tvName = (TextView) $(R.id.tvName);
        tvLoginName = (TextView) $(R.id.tvLoginName);
//        tvCompany = (TextView) $(R.id.tvCompany);
//        tvPosition = (TextView) $(R.id.tvPosition);
//        tvEmail = (TextView) $(R.id.tvEmail);
//        tvWebsite = (TextView) $(R.id.tvWebsite);
        refreshData();
    }


    public void refreshData(){
        BeanUser user = SPUtil.getInstance().getUser();
        if (user != null){
            ILFactory.getLoader().loadNet(ivHead, user.avatar_url, new ILoader.Options(R.mipmap.ic_default_github, R.mipmap.ic_default_github));
            tvName.setText(user.name);
            tvLoginName.setText(user.login);
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
