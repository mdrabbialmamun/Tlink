package com.theexecutinglab.tlink.model;

import java.io.Serializable;

public class Data implements Serializable {

    String normalVidLink;
    String hdVidLink;
    String musicLink;

    public Data(String normalVidLink, String hdVidLink, String musicLink) {
        this.normalVidLink = normalVidLink;
        this.hdVidLink = hdVidLink;
        this.musicLink = musicLink;
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
}
