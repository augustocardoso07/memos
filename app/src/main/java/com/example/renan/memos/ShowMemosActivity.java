package com.example.renan.memos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class ShowMemosActivity extends AppCompatActivity {

    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_memos);

        tag = getIntent().getExtras().getString("tag");

        List<String> memosList = getMemosList();

        ListView memosListView = (ListView) findViewById(R.id.lv_show_memos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, memosList);
        memosListView.setAdapter(adapter);


        TextView tagTextView = (TextView) findViewById(R.id.tv_show_tag);
        tagTextView.setText(tag);

    }

    private List<String> getMemosList() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<MemoModel> result = realm.where(MemoModel.class).equalTo("tag", tag).findAll().sort("date", Sort.DESCENDING);

        List<String> list = new ArrayList<>();

        for (MemoModel m: result) {
            list.add(m.getMemo());
        }
        return list;
    }
}
