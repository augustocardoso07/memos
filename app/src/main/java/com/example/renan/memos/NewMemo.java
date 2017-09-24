package com.example.renan.memos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class NewMemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_memo);

        Button newMemo = (Button) findViewById(R.id.bt_add_memo);

        final Realm realm = Realm.getDefaultInstance();
        final EditText memo = (EditText) findViewById(R.id.et_memo);
        final AutoCompleteTextView tag = (AutoCompleteTextView) findViewById(R.id.actv_tag);

        List<String> tagsArray = MyUtil.getTagsArray();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, tagsArray);
        tag.setAdapter(adapter);

        newMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memoString = memo.getText().toString().trim();
                String tagString = tag.getText().toString().trim();

                realm.beginTransaction();
                MemoModel memoModel = realm.createObject(MemoModel.class);
                memoModel.setMemo(memoString);
                memoModel.setTag(tagString);
                memoModel.setDate(new Date());
                realm.commitTransaction();

                Toast.makeText(NewMemo.this, "Memo Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
