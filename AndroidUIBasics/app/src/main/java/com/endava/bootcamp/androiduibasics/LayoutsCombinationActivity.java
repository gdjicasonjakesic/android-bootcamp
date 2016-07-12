package com.endava.bootcamp.androiduibasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LayoutsCombinationActivity extends AppCompatActivity {
    /**
     * Reference to the TextView instance which denotes direction.
     */
    TextView mTextViewDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts_combination);

        mTextViewDirection = (TextView) findViewById(R.id.textViewDirection);
    }

    public void onLeft(View view) {
        mTextViewDirection.setText(getString(R.string.textLeft));
    }

    public void onRight(View view) {
        mTextViewDirection.setText(getString(R.string.textRight));
    }

    public void onText(View view) {
        mTextViewDirection.setText(getString(R.string.textCenter));
    }
}
