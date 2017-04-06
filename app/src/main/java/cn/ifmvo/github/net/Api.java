package cn.ifmvo.github.net;

import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class Api {
    public static final String API_BASE_URL = "https://api.github.com/";

    private static GitHubService gitHubService;

    public static GitHubService getGitHubService() {
        if (gitHubService == null) {
            synchronized (Api.class) {
                if (gitHubService == null) {
                    gitHubService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(GitHubService.class);
                }
            }
        }
        return gitHubService;
    }
}
