package com.endava.bootcamp.androiduibasics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLayoutLinearVertical:
                Log.d(TAG, "Vertical linear layout option selected.");
                startActivity(new Intent(this, LinearLayoutVerticalActivity.class));
                break;
            case R.id.buttonLayoutLinearHorizontal:
                Log.d(TAG, "Horizontal linear layout option selected.");
                startActivity(new Intent(this, LinearLayoutHorizontalActivity.class));
                break;
            case R.id.buttonLayoutRelative:
                Log.d(TAG, "Relative layout option selected.");
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case R.id.buttonLayoutCombination:
                Log.d(TAG, "Layout combination option selected.");
                startActivity(new Intent(this, LayoutsCombinationActivity.class));
                break;
            case R.id.buttonNavigation:
                Log.d(TAG, "Navigation option selected.");
                startActivity(new Intent(this, NavigationActivity.class));
                break;
            case R.id.buttonDialogs:
                Log.d(TAG, "Dialogs option selected.");
                startActivity(new Intent(this, DialogsActivity.class));
                break;
            case R.id.buttonListView:
                Log.d(TAG, "List view option selected.");
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.buttonStyles:
                Log.d(TAG, "Styles option selected.");
                startActivity(new Intent(this, StylesActivity.class));
                break;
        }
    }
}
