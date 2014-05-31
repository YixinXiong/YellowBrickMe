package com.tally.yellowbrickme.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Berries on 2014-04-29.
 */
public class CalendarFragment extends Fragment {
    public static CalendarFragment newInstance() {
        CalendarFragment calendarFragment = new CalendarFragment();
        return calendarFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        return v;
    }
}
