package org.rome.ancient.crosstheriverandrollthedice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class RollTheDiceActivity extends AppCompatActivity {

    private Integer maxValueForRandomization = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_the_dice);

        // In this case, spinner is used, but for the sake of simplicity, you can use EditText too.
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dice_sides, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Handle change of the values in the spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedValue = (String)adapterView.getItemAtPosition(i);
                maxValueForRandomization = Integer.parseInt(selectedValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                maxValueForRandomization = 6;
            }
        });

        // This is how button can get method that handles click too.
        Button rollTheDice = (Button)findViewById(R.id.button);
        rollTheDice.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) // This will be needed in case ThreadLocalRandom is used.
            @Override
            public void onClick(View view) {
                Random random = new Random();
                Integer randomNumber = random.nextInt(maxValueForRandomization) + 1;
                TextView resultView = (TextView) RollTheDiceActivity.this.findViewById(R.id.rolled_value);
                resultView.setText(String.valueOf(randomNumber));
//                ThreadLocalRandom.current().nextInt(1, maxValueForRandomization); // This one is not used, because it needs API level Lollipop to work.
            }
        });
    }
}
