package cn.ifmvo.github.bean;

import com.google.gson.annotations.SerializedName;

import cn.droidlover.xdroidmvp.base.bean.BaseBean;

/**
 * Created by Matthew_Chen on 2017/4/6.
 */

public class BeanRepos extends BaseBean {

    /**
     * id : 79778760
     * name : android-tech-frontier
     * full_name : ifmvo/android-tech-frontier
     * owner : {}
     * private : false
     * html_url : https://github.com/ifmvo/android-tech-frontier
     * description : 一个定期翻译国外Android优质的技术、开源库、软件架构设计、测试等文章的开源项目
     * fork : true
     * url : https://api.github.com/repos/ifmvo/android-tech-frontier
     * forks_url : https://api.github.com/repos/ifmvo/android-tech-frontier/forks
     * keys_url : https://api.github.com/repos/ifmvo/android-tech-frontier/keys{/key_id}
     * collaborators_url : https://api.github.com/repos/ifmvo/android-tech-frontier/collaborators{/collaborator}
     * teams_url : https://api.github.com/repos/ifmvo/android-tech-frontier/teams
     * hooks_url : https://api.github.com/repos/ifmvo/android-tech-frontier/hooks
     * issue_events_url : https://api.github.com/repos/ifmvo/android-tech-frontier/issues/events{/number}
     * events_url : https://api.github.com/repos/ifmvo/android-tech-frontier/events
     * assignees_url : https://api.github.com/repos/ifmvo/android-tech-frontier/assignees{/user}
     * branches_url : https://api.github.com/repos/ifmvo/android-tech-frontier/branches{/branch}
     * tags_url : https://api.github.com/repos/ifmvo/android-tech-frontier/tags
     * blobs_url : https://api.github.com/repos/ifmvo/android-tech-frontier/git/blobs{/sha}
     * git_tags_url : https://api.github.com/repos/ifmvo/android-tech-frontier/git/tags{/sha}
     * git_refs_url : https://api.github.com/repos/ifmvo/android-tech-frontier/git/refs{/sha}
     * trees_url : https://api.github.com/repos/ifmvo/android-tech-frontier/git/trees{/sha}
     * statuses_url : https://api.github.com/repos/ifmvo/android-tech-frontier/statuses/{sha}
     * languages_url : https://api.github.com/repos/ifmvo/android-tech-frontier/languages
     * stargazers_url : https://api.github.com/repos/ifmvo/android-tech-frontier/stargazers
     * contributors_url : https://api.github.com/repos/ifmvo/android-tech-frontier/contributors
     * subscribers_url : https://api.github.com/repos/ifmvo/android-tech-frontier/subscribers
     * subscription_url : https://api.github.com/repos/ifmvo/android-tech-frontier/subscription
     * commits_url : https://api.github.com/repos/ifmvo/android-tech-frontier/commits{/sha}
     * git_commits_url : https://api.github.com/repos/ifmvo/android-tech-frontier/git/commits{/sha}
     * comments_url : https://api.github.com/repos/ifmvo/android-tech-frontier/comments{/number}
     * issue_comment_url : https://api.github.com/repos/ifmvo/android-tech-frontier/issues/comments{/number}
     * contents_url : https://api.github.com/repos/ifmvo/android-tech-frontier/contents/{+path}
     * compare_url : https://api.github.com/repos/ifmvo/android-tech-frontier/compare/{base}...{head}
     * merges_url : https://api.github.com/repos/ifmvo/android-tech-frontier/merges
     * archive_url : https://api.github.com/repos/ifmvo/android-tech-frontier/{archive_format}{/ref}
     * downloads_url : https://api.github.com/repos/ifmvo/android-tech-frontier/downloads
     * issues_url : https://api.github.com/repos/ifmvo/android-tech-frontier/issues{/number}
     * pulls_url : https://api.github.com/repos/ifmvo/android-tech-frontier/pulls{/number}
     * milestones_url : https://api.github.com/repos/ifmvo/android-tech-frontier/milestones{/number}
     * notifications_url : https://api.github.com/repos/ifmvo/android-tech-frontier/notifications{?since,all,participating}
     * labels_url : https://api.github.com/repos/ifmvo/android-tech-frontier/labels{/name}
     * releases_url : https://api.github.com/repos/ifmvo/android-tech-frontier/releases{/id}
     * deployments_url : https://api.github.com/repos/ifmvo/android-tech-frontier/deployments
     * created_at : 2017-01-23T06:58:35Z
     * updated_at : 2017-01-23T03:59:43Z
     * pushed_at : 2016-11-25T06:38:33Z
     * git_url : git://github.com/ifmvo/android-tech-frontier.git
     * ssh_url : git@github.com:ifmvo/android-tech-frontier.git
     * clone_url : https://github.com/ifmvo/android-tech-frontier.git
     * svn_url : https://github.com/ifmvo/android-tech-frontier
     * homepage : http://www.devtf.cn
     * size : 42138
     * stargazers_count : 0
     * watchers_count : 0
     * language : null
     * has_issues : false
     * has_projects : true
     * has_downloads : true
     * has_wiki : true
     * has_pages : false
     * forks_count : 0
     * mirror_url : null
     * open_issues_count : 0
     * forks : 0
     * open_issues : 0
     * watchers : 0
     * default_branch : master
     */

    public int id;
    public String name;
    public String full_name;
    public BeanOwner owner;
    @SerializedName("private")
    public boolean privateX;
    public String html_url;
    public String description;
    public boolean fork;
    public String url;
    public String forks_url;
    public String keys_url;
    public String collaborators_url;
    public String teams_url;
    public String hooks_url;
    public String issue_events_url;
    public String events_url;
    public String assignees_url;
    public String branches_url;
    public String tags_url;
    public String blobs_url;
    public String git_tags_url;
    public String git_refs_url;
    public String trees_url;
    public String statuses_url;
    public String languages_url;
    public String stargazers_url;
    public String contributors_url;
    public String subscribers_url;
    public String subscription_url;
    public String commits_url;
    public String git_commits_url;
    public String comments_url;
    public String issue_comment_url;
    public String contents_url;
    public String compare_url;
    public String merges_url;
    public String archive_url;
    public String downloads_url;
    public String issues_url;
    public String pulls_url;
    public String milestones_url;
    public String notifications_url;
    public String labels_url;
    public String releases_url;
    public String deployments_url;
    public String created_at;
    public String updated_at;
    public String pushed_at;
    public String git_url;
    public String ssh_url;
    public String clone_url;
    public String svn_url;
    public String homepage;
    public int size;
    public int stargazers_count;
    public int watchers_count;
    public Object language;
    public boolean has_issues;
    public boolean has_projects;
    public boolean has_downloads;
    public boolean has_wiki;
    public boolean has_pages;
    public int forks_count;
    public Object mirror_url;
    public int open_issues_count;
    public int forks;
    public int open_issues;
    public int watchers;
    public String default_branch;


}
