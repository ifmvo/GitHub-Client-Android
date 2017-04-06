package cn.ifmvo.github.bean;

import cn.droidlover.xdroidmvp.base.bean.BaseBean;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class BeanUser extends BaseBean{


    /**
     * login : ifmvo
     * id : 14008627
     * avatar_url : https://avatars2.githubusercontent.com/u/14008627?v=3
     * gravatar_id :
     * url : https://api.github.com/users/ifmvo
     * html_url : https://github.com/ifmvo
     * followers_url : https://api.github.com/users/ifmvo/followers
     * following_url : https://api.github.com/users/ifmvo/following{/other_user}
     * gists_url : https://api.github.com/users/ifmvo/gists{/gist_id}
     * starred_url : https://api.github.com/users/ifmvo/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/ifmvo/subscriptions
     * organizations_url : https://api.github.com/users/ifmvo/orgs
     * repos_url : https://api.github.com/users/ifmvo/repos
     * events_url : https://api.github.com/users/ifmvo/events{/privacy}
     * received_events_url : https://api.github.com/users/ifmvo/received_events
     * type : User
     * site_admin : false
     * name : 陈序员
     * company : http://www.hljdami.com.cn
     * blog : http://blog.csdn.net/ifmvo
     * location : Harbin China
     * email : Matthew_Chen_1994@163.com
     * hireable : true
     * bio : Android Developer.
     * public_repos : 11
     * public_gists : 0
     * followers : 0
     * following : 2
     * created_at : 2015-08-28T02:02:28Z
     * updated_at : 2017-03-30T09:23:47Z
     */

    public String login;
    public int id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
    public String name;
    public String company;
    public String blog;
    public String location;
    public String email;
    public boolean hireable;
    public String bio;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return "BeanUser{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable=" + hireable +
                ", bio='" + bio + '\'' +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
