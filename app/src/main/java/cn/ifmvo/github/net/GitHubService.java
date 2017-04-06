package cn.ifmvo.github.net;

import java.util.List;

import cn.ifmvo.github.bean.BeanGitHubResult;
import cn.ifmvo.github.bean.BeanRepos;
import cn.ifmvo.github.bean.BeanUser;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public interface GitHubService {

    @GET("users/{username}")
    Observable<BeanUser> getUser(
            @Path("username") String username);

    /**
     *
     * @param username 用户名
     * @param type Can be one of all, owner, member. Default: owner
     * @param sort Can be one of created, updated, pushed, full_name. Default: full_name
     * @param direction Can be one of asc or desc. Default: when using full_name: asc, otherwise desc
     */
    @GET("users/{username}/repos")
    Observable<BeanGitHubResult<List<BeanRepos>>> listUserRepos(
            @Path("username") String username,
            @Query("page") int page,
            @Query("per_page") int per_page,
            @Query("type") String type,
            @Query("sort") String sort,
            @Query("direction") String direction);
}
