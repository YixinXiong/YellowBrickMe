package com.tally.yellowbrickme.app;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.cengalabs.flatui.FlatUI;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FragmentActivity {

    private Button button;
    ViewPager viewPager;
    List<Fragment> fragments = getFragments();

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(CalendarFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(BlockerFragment.newInstance());

        return fragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlatUI.setDefaultTheme(FlatUI.GRASS);
        super.onCreate(savedInstanceState);
        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        setContentView(viewPager);

        FragmentManager fm = getSupportFragmentManager();

        viewPager.setCurrentItem(1);
        viewPager.setAdapter(new PagerAdapter(fm, fragments));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
