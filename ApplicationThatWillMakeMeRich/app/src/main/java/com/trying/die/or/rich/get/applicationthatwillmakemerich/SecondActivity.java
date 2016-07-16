package com.trying.die.or.rich.get.applicationthatwillmakemerich;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String newString = (String) getResources().getString(R.string.show_me_the_other_activity);
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(newString);
        String string = getIntent().getStringExtra("text_to_show");
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
