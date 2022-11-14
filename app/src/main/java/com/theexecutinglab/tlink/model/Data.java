package com.theexecutinglab.tlink.model;

import java.io.Serializable;

public class Data implements Serializable {
    String title;
    String user;
    String likeCount;
    String commentCount;
    String shareCount;
    String viewCount;
    String normalVidLink;
    String hdVidLink;
    String musicLink;
    String coverImageLink;

    public Data(String coverImageLink,String title, String user, String likeCount, String commentCount, String shareCount, String viewCount, String normalVidLink, String hdVidLink, String musicLink) {
        this.title = title;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
        this.viewCount = viewCount;
        this.normalVidLink = normalVidLink;
        this.hdVidLink = hdVidLink;
        this.musicLink = musicLink;
        this.coverImageLink = coverImageLink;
    }

    public String getCoverImageLink() {
        return coverImageLink;
    }

    public String getNormalVidLink() {
        return normalVidLink;
    }

    public String getHdVidLink() {
        return hdVidLink;
    }

    public String getMusicLink() {
        return musicLink;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public String getShareCount() {
        return shareCount;
    }

    public String getViewCount() {
        return viewCount;
    }
}
