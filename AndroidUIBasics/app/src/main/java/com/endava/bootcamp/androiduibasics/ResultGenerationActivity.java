package com.endava.bootcamp.androiduibasics;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultGenerationActivity extends AppCompatActivity {

    // Tags used to pass data to previous activity (same logic as when passing data to new activity)
    public final static String RESULT_DATA_TAG = "com.endava.androiduibasics.RESULT_DATA_TAG";
    public final static String RESULT_DATA_INT_TAG =
            "com.endava.androiduibasics.RESULT_DATA_INT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_generation);
    }

    public void onFinish(View view) {
        // Read data user has entered in edit-box
        String enteredData =
                ((EditText) findViewById(R.id.editTextResultData)).getText().toString();

        Intent intentDataContainer = new Intent();
        // Adding entered data.
        intentDataContainer.putExtra(RESULT_DATA_TAG, enteredData);
        // Adding additional data (i.e. number 78)
        intentDataContainer.putExtra(RESULT_DATA_INT_TAG, 78);

        // Setting result to RESULT_OK, which will notify us on NavigationActivity that everything
        // went fine. Additional data is also being passed via provided Intent instance.
        setResult(Activity.RESULT_OK, intentDataContainer);

        // Calling finish() so that ResultGenerationActivity gets killed and removed from
        // task stack.
        finish();
    }
}
