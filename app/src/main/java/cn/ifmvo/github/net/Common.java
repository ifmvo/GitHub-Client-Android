package cn.ifmvo.github.net;

import cn.ifmvo.github.R;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class Common {

    public static class ReposSort {

        public static final String created = "created";
        public static final String updated = "updated";
        public static final String pushed = "pushed";

    }

    public static class ReposType {
        public static final String all = "all";
        public static final String owner = "owner";
        public static final String member = "member";

    }

    //仓库的语言对应的颜色
    public static class LanguageColor{
        public static int getColor(String langu){
            switch (langu){
                case "Java":
                    return R.drawable.shape_circle_java;
                case "C++":
                    return R.drawable.shape_circle_cpp;
                case "HTML":
                    return R.drawable.shape_circle_html;
                case "Python":
                    return R.drawable.shape_circle_python;
                case "JavaScript":
                    return R.drawable.shape_circle_javascript;
                case "Go":
                    return R.drawable.shape_circle_go;
                default:
                    return R.drawable.shape_circle;
            }
        }
    }

}
