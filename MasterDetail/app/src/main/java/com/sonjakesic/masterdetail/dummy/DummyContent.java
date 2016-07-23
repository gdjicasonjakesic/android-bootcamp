package com.sonjakesic.masterdetail.dummy;

import android.content.Context;
import android.content.res.Resources;

import com.sonjakesic.masterdetail.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for creating dummy content.
 * <p/>
 */
public class DummyContent {

    /**
     * A string array of sample (dummy) items.
     */
    public static List<String> ITEM_LIST;

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, String> ITEM_MAP = new HashMap<>();

    public static void createDummyItems(Context context) {
        Resources res = context.getResources();
        ITEM_LIST = Arrays.asList(res.getStringArray(R.array.countries_array));
        String [] details = res.getStringArray(R.array.details_array);
        for (int i = 0; i < ITEM_LIST.size(); i++) {
            ITEM_MAP.put(ITEM_LIST.get(i), details[i]);
        }
    }
}
