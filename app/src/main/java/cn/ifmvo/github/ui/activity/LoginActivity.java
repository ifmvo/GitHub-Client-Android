package cn.ifmvo.github.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import cn.droidlover.xdroidmvp.base.activity.BaseActivityTopBar;
import cn.droidlover.xdroidmvp.utils.router.Router;
import cn.ifmvo.github.R;
import cn.ifmvo.github.presenter.UserPresenter;

/**
 * Created by ifmvo on 17-4-7.
 */

public class LoginActivity extends BaseActivityTopBar<UserPresenter> {
    Button btnLogin;
    TextInputEditText etUsername;
//    RadioButton rbRemember;

    @Override
    public UserPresenter newP() {
        return new UserPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etUsername = (TextInputEditText) findViewById(R.id.etUsername);
//        rbRemember = (RadioButton)findViewById(R.id.rbRemember);

//        if (rbRemember.isSelected()){
//            SPUtil.getInstance().saveIsRemeber(true);
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = etUsername.getText().toString();
                getP().getUser(username);
            }
        });
    }

    @Override
    protected void postLoad() {

    }

    public void actionMain(){

        Router.newIntent(context)
                .to(MainActivity.class)
                .launch();

        finish();
    }


}
