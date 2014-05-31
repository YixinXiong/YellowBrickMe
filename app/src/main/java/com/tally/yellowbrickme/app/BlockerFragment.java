package com.tally.yellowbrickme.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Berries on 2014-04-29.
 */
public class BlockerFragment extends Fragment {

    public static BlockerFragment newInstance(){
        BlockerFragment blockerFragment = new BlockerFragment();
        return blockerFragment;
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
