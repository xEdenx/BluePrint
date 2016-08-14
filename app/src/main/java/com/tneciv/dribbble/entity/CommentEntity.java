package com.tneciv.dribbble.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tneciv
 * on 2016-08-14 23:07 .
 */

public class CommentEntity implements Serializable {

    private static final long serialVersionUID = 1328250555927254635L;
    /**
     * by : norvig
     * id : 2921983
     * kids : [2922097,2922429,2924562,2922709,2922573,2922140,2922141]
     * parent : 2921506
     * text : Aw shucks, guys ... you make me blush with your compliments.<p>Tell you what, Ill make a deal: I'll keep writing if you keep reading. K?
     * time : 1314211127
     * type : comment
     */

    private String by;
    private int id;
    private int parent;
    private String text;
    private int time;
    private String type;
    private List<Integer> kids;

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }
}
