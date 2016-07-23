package com.sonjakesic.masterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.sonjakesic.masterdetail.dummy.DummyContent;

import java.util.List;

/**
 * An activity representing a list of Countries. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CountryDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CountryListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);


        if (findViewById(R.id.country_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp) and in landscape.
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        DummyContent.createDummyItems(this);
        final ListView listView = (ListView) findViewById(R.id.country_list);
        setupListView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = (String) ((TextView) view
                        .findViewById(android.R.id.text1)).getText();
                if (mTwoPane) {
                    replaceDetailFragment(country);
                } else {
                    startDetailActivity(country);
                }
            }
        });

        // If we are running on tablet and this is a freshly created activity, display the first
        // item in the list in the detail view
        if (mTwoPane && savedInstanceState == null) {
            replaceDetailFragment(DummyContent.ITEM_LIST.get(0));
        }
    }

    private void setupListView(ListView listView) {
        List<String> items = DummyContent.ITEM_LIST;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout
                .simple_list_item_1,
                items);
        listView.setAdapter(adapter);
    }

    private void replaceDetailFragment(String item) {
        Bundle arguments = new Bundle();
        arguments.putString(CountryDetailFragment.ARG_COUNTRY, item);
        CountryDetailFragment fragment = new CountryDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.country_detail_container, fragment)
                .commit();
    }

    private void startDetailActivity(String item) {
        Intent intent = new Intent(CountryListActivity.this, CountryDetailActivity
                .class);
        intent.putExtra(CountryDetailFragment.ARG_COUNTRY, item);
        startActivity(intent);
    }
}
