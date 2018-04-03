package com.example.android.visionshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private TextView mTextMessage;

    public Fragment displayFragment(int id)
    {
        Fragment selectedFragment = null;
        switch (id) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                selectedFragment= (Fragment) new Map();
                break;
            case R.id.navigation_trending:
                mTextMessage.setText(R.string.title_trending);
                selectedFragment= (Fragment) new Trending();
                break;
            case R.id.navigation_news:
                mTextMessage.setText(R.string.title_news);
                selectedFragment = (Fragment) new News();
                break;
            case R.id.navigation_submission:
                mTextMessage.setText(R.string.title_submission);
                selectedFragment= Submission.newInstance();
                break;
            case R.id.navigation_my_account:
                mTextMessage.setText(R.string.title_my_account);
                selectedFragment = My_Account.newInstance();
                break;
        }
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
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState==null)
        {
            Fragment selectedFragment = displayFragment(R.id.navigation_home);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, selectedFragment);
            transaction.commit();
        }
    }
}
