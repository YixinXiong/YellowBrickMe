package com.tally.yellowbrickme.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.cengalabs.flatui.views.FlatButton;
import com.cengalabs.flatui.views.FlatTextView;

/**
 * Created by Berries on 2014-04-28.
 */
public class HomeFragment extends Fragment {

    FlatButton study, settings, clearButton, breakButton;
    TextView timeElapsed, progressTitle;
    private boolean isStudying = false;
    long startTime, timeWhenStopped;
    Chronometer stopWatch;

    public static final HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        settings = (FlatButton) v.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SettingsActivity.class);
                startActivity(i);
            }
        });

        stopWatch = (Chronometer) v.findViewById(R.id.chrono);
        stopWatch.setFormat("HH:MM:SS");
        stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer arg0) {
                long timePassed = (SystemClock.elapsedRealtime() - arg0.getBase()) / 1000;
                String minutes = "";
                String seconds = "";
                if ((timePassed % 60) < 10) {
                    seconds = "0" + String.valueOf(timePassed % 60);
                } else {
                    seconds = String.valueOf(timePassed % 60);
                }
                if ((timePassed / 60) < 10) {
                    minutes = "0" + String.valueOf(timePassed / 60);
                } else {
                    minutes = String.valueOf(timePassed / 60);
                }
                String timeElapsedAsText = minutes + ":" + seconds;
                timeElapsed.setText(timeElapsedAsText);
            }
        });
        timeElapsed = (FlatTextView) v.findViewById(R.id.elapsedTime);
        progressTitle = (FlatTextView) v.findViewById(R.id.progressTitle);
        clearButton = (FlatButton) v.findViewById(R.id.clear_button);
        breakButton = (FlatButton) v.findViewById(R.id.break_button);

        clearButton.setVisibility(View.GONE);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeElapsed.setText("");
                startTime = SystemClock.elapsedRealtime();
                progressTitle.setText("");
                clearButton.setVisibility(View.GONE);
            }
        });

        breakButton.setVisibility(View.GONE);
        breakButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isStudying) {
                    timeWhenStopped = SystemClock.elapsedRealtime() - stopWatch.getBase();
                    stopWatch.stop();
                    breakButton.setText(R.string.ready);
                    isStudying = false;
                } else{
                    stopWatch.setBase(timeWhenStopped + SystemClock.elapsedRealtime());
                    stopWatch.start();
                    breakButton.setText(R.string.need_break);
                    isStudying = true;
                }
            }
        });

        study = (FlatButton) v.findViewById(R.id.study);
        study.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isStudying) {
                    Toast.makeText(getActivity(), R.string.awesome_job, Toast.LENGTH_SHORT).show();
                    study.setText(R.string.study);
                    stopWatch.stop();
                    clearButton.setVisibility(View.VISIBLE);
                    breakButton.setVisibility(View.GONE);
                    isStudying = false;

                } else {
                    Toast.makeText(getActivity(), R.string.here_we_go, Toast.LENGTH_SHORT).show();
                    study.setText(R.string.stop);
                    progressTitle.setText(R.string.progress);
                    startTime = SystemClock.elapsedRealtime();
                    stopWatch.setBase(startTime);
                    stopWatch.start();
                    breakButton.setVisibility(View.VISIBLE);
                    isStudying = true;
                }
            }
        });
        return v;
    }


}
