package com.endava.bootcamp.androiduibasics;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {
    // Tags used to pass data to started activity
    public final static String DATA_TAG = "com.endava.androiduibasics.DATA_TAG";
    public final static String DATA_INT_TAG = "com.endava.androiduibasics.DATA_INT_TAG";

    // Request code(s) used to start new activity for result
    public final static int GET_RESULT_REQCODE = 1;

    private EditText mEditTextData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mEditTextData = (EditText) findViewById(R.id.editTextData);
    }

    /**
     * Starts ReadDataActivity activity with additional data (string and integer values)
     */
    public void onSendData(View view) {
        String dataToSend = mEditTextData.getText().toString();

        Intent intent = new Intent(this, ReadDataActivity.class);
        intent.putExtra(DATA_TAG, dataToSend);
        intent.putExtra(DATA_INT_TAG, 54);
        startActivity(intent);
    }

    /**
     * Starts ResultGenerationActivity from which is expected to provide a result/response.
     * NOTE: Result/Response has to be processed within overridden onActivityResult method.
     */
    public void onStartForResult(View view) {
        Intent intent = new Intent(this, ResultGenerationActivity.class);
        startActivityForResult(intent, GET_RESULT_REQCODE);
    }

    /**
     * Method that will process result/data received from ResultGenerationActivity
     */
    @SuppressLint("DefaultLocale")
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        if (reqCode == GET_RESULT_REQCODE && resultCode == RESULT_OK) {
            // User completed work on ResultGenerationActivity.
            // NOTE: Logic is same as when reading the data from previous activity.
            String resultData = data.getStringExtra(ResultGenerationActivity.RESULT_DATA_TAG);

            // NOTE: Second argument of getIntExra is default value that will be used in the case
            // that we haven't received any from previous activity.
            int resultIntData = data.getIntExtra(ResultGenerationActivity.RESULT_DATA_INT_TAG, -1);

            // Update NavigationActivity with obtained results;
            ((TextView) findViewById(R.id.textViewReceivedResultAndData)).setText(
                    String.format("'%s' [%d]", resultData, resultIntData));
        }
    }
}
