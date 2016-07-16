package com.endava.bootcamp.androiduibasics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> mPlatforms = null;
    ListView mListViewPlatforms = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mPlatforms =
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.platforms)));
        ArrayAdapter<String> platformsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mPlatforms);
        platformsAdapter.setNotifyOnChange(true);

        mListViewPlatforms = (ListView) findViewById(R.id.listPlatforms);
        mListViewPlatforms.setAdapter(platformsAdapter);
    }
}
