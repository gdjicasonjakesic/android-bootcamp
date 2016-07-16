package com.sonjakesic.onefragmentapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BlankActivity extends Activity {

    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        mButton = (Button) findViewById(R.id.activity_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBlankFragment();
            }
        });
    }

    void addBlankFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(android.R.id.content, BlankFragment.newInstance());
        // make sure fragment is removed when user presses back button
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
