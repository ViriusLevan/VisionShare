package com.example.android.visionshare;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Main extends AppCompatActivity {

//    private TextView mTextMessage;
    ActionBar actionBar;

    public Fragment displayFragment(int id)
    {
        Fragment selectedFragment = null;
        switch (id) {
            case R.id.navigation_home:

                selectedFragment= (Fragment) new Home();
                break;
            case R.id.navigation_trending:
//                mTextMessage.setText(R.string.title_trending);
                selectedFragment= (Fragment) new Dashboard();
                break;
            case R.id.navigation_news:
//                mTextMessage.setText(R.string.title_news);
                selectedFragment = (Fragment) new Dashboard_News();
                break;
            case R.id.navigation_submission:
//                mTextMessage.setText(R.string.title_submission);
                selectedFragment= Submission.newInstance();
                break;
            case R.id.navigation_my_account:
//                mTextMessage.setText(R.string.title_my_account);
                selectedFragment = My_Account.newInstance();
                break;
        }
        BottomNavigationView bottomNavigationView
                = (BottomNavigationView) findViewById(R.id.navigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        return selectedFragment;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = displayFragment(item.getItemId());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#22a7f0")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_actionbar_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        if(savedInstanceState==null)
        {
            Fragment selectedFragment = displayFragment(R.id.navigation_home);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, selectedFragment);
            transaction.commit();
        }
    }
}
