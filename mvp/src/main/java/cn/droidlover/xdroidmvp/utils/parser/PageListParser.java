package cn.droidlover.xdroidmvp.utils.parser;


import android.text.TextUtils;

import java.util.List;

import cn.droidlover.xdroidmvp.utils.JsonExplain;
import cn.droidlover.xdroidmvp.base.bean.BaseBean;

/**
 * Created by ZongfaHe on 16/3/27.
 */
public class PageListParser<T extends BaseBean> extends BaseParser<PageListBean> {
    String listItemName;
    T[] t;

    public PageListParser(T[] t, String listItemName) {
        this.listItemName = listItemName;
        this.t = t;
    }

    @Override
    public PageListBean parse(String str) {

//        String pageInfo = JsonExplain.getStringValue(str, "pageinfo");
//        Logger.e("str:" + str);
        String list = JsonExplain.getStringValue(str, listItemName);
//        Logger.e("list:" + list);

        PageListBean<T> pageListBean = new PageListBean<>();
//        if (!StringUtil.isEmpty(pageInfo))
//            pageListBean.setPageInfo((PageBean) JsonExplain.explainJson(pageInfo, PageBean.class));
        if (!TextUtils.isEmpty(list)) {
            List<T> tList =  JsonExplain.explainListJson(list, t.getClass());
//            Logger.e("tList:" + tList);
            pageListBean.setList(tList);
        }
//        if (!StringUtil.isEmpty(getRequestUrl()))
        return pageListBean;
    }
}
