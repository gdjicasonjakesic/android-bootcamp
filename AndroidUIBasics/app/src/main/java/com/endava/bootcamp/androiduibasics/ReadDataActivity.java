package com.endava.bootcamp.androiduibasics;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDataActivity extends AppCompatActivity {

    private TextView mTextViewReceivedData = null;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        mTextViewReceivedData = (TextView) findViewById(R.id.textViewReceivedData);

        Intent intent = getIntent();
        String receivedStringData = intent.getStringExtra(NavigationActivity.DATA_TAG);
        // In the case that no integer value is received, -1 will be used as a substitute.
        int receivedIntData = intent.getIntExtra(NavigationActivity.DATA_INT_TAG, -1);
        mTextViewReceivedData.setText(
                String.format("'%s' [%d]", receivedStringData, receivedIntData)
        );
    }
}
