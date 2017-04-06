package cn.droidlover.xdroidmvp.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.droidlover.xdroidmvp.R;


/**
 * Created by ifmvo on 17-3-23.
 */

public class ErrorView extends RelativeLayout {

    TextView tvError;
    Button btnRefresh;

    public ErrorView(Context context) {
        super(context);
        setUpView(context);
    }

    private void setUpView(Context context){
        View inflate = View.inflate(context, R.layout.view_error, this);
        tvError = (TextView) inflate.findViewById(R.id.tvErrorMsg);
        btnRefresh = (Button) inflate.findViewById(R.id.btnRefresh);

    }

    public void setOnErrorClickListener(final OnClickListener onClickListener){
        btnRefresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v);
            }
        });
    }

    public void setErrorMsg(String msg){
        if (!TextUtils.isEmpty(msg)){
            tvError.setText(msg);
        }
    }

}
