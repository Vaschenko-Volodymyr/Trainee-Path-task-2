package com.traineepath.volodymyrvashchenko.trainee_path_task_2.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.traineepath.volodymyrvashchenko.trainee_path_task_2.R;
import com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments.AnimateViaCodeFragment;
import com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments.AnimateViaXmlFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String XML = "Xml";
    private static final String CODE = "Code";

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Method: onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        Log.v(TAG, "Method: setupViewPager()");
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AnimateViaCodeFragment(), CODE);
        adapter.addFragment(new AnimateViaXmlFragment(), XML);
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            Log.v(TAG, "Inner class: ViewPagerAdapter, Method: getItem()");
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            Log.v(TAG, "Inner class: ViewPagerAdapter, Method: getCount()");
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            Log.v(TAG, "Inner class: ViewPagerAdapter, Method: addFragment()");
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.v(TAG, "Inner class: ViewPagerAdapter, Method: getPageTitle()");
            return mFragmentTitleList.get(position);
        }
    }
}
