package com.sonjakesic.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HostActivity extends AppCompatActivity implements InputFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
    }

    @Override
    public void onTextSubmitted(String text) {
        OutputFragment outputFragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentById(R.id
                        .output_fragment);
        outputFragment.setText(text);
    }
}
