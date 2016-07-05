package com.trying.die.or.rich.get.applicationthatwillmakemerich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class OneActivityToRuleThemAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_rule_them_all);
    }

    public void onShowMeClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        TextView textView = (TextView)findViewById(R.id.textView);
        String textToGoWhereNoTextWentBefore = textView.getText().toString();
        intent.putExtra("text_to_show", textToGoWhereNoTextWentBefore);
        startActivity(intent);
    }
}
