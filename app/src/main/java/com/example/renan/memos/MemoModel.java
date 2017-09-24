package com.example.renan.memos;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by renan on 23/09/2017.
 */

public class MemoModel extends RealmObject {

    private String memo;
    private String tag;
    private Date date;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
