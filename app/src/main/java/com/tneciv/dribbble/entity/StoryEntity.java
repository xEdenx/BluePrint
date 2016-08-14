package com.tneciv.dribbble.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-14 22:52 .
 */

public class StoryEntity implements Serializable {

    private static final long serialVersionUID = -4097040437745567425L;
    /**
     * by : dhouston
     * descendants : 71
     * id : 8863
     * kids : [8952,9224,8917,8884,8887,8943,8869,8958,9005,9671,9067,8940,8908,9055,8865,8881,8872,8873,8955,10403,8903,8928,9125,8998,8901,8902,8907,8894,8878,8980,8870,8934,8876]
     * score : 111
     * time : 1175714200
     * title : My YC app: Dropbox - Throw away your USB drive
     * type : story
     * url : http://www.getdropbox.com/u/2/screencast.html
     */

    private String by;
    private int descendants;
    private int id;
    private int score;
    private int time;
    private String title;
    private String type;
    private String url;
    private List<Integer> kids;

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return "StoryEntity{" +
                "by='" + by + '\'' +
                ", descendants=" + descendants +
                ", id=" + id +
                ", score=" + score +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", kids=" + kids +
                '}';
    }
}
