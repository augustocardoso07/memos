package com.example.renan.memos;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by renan on 23/09/2017.
 */

public class MyUtil {
    public static List<String> getTagsArray() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<MemoModel> results = realm.where(MemoModel.class).distinct("tag").sort("tag");

        List<String> list = new ArrayList<>();

        for (MemoModel m: results) {
            list.add(m.getTag());
        }

        return list;
    }
}
