package com.endava.bootcamp.androiduibasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ClickHandlerActivity extends AppCompatActivity {

    private final String TAG = ClickHandlerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_handler);

        findViewById(R.id.buttonListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Received click on Listener button.");
            }
        });
    }

    public void onSingleButtonClick(View view) {
        Log.d(TAG, "Received click on Single button.");
    }

    public void onMultipleButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonMultiple1:
                Log.d(TAG, "Received click on Multiple 1 button.");
                break;
            case R.id.buttonMultiple2:
                Log.d(TAG, "Received click on Multiple 2 button.");
                break;
        }
    }
}
