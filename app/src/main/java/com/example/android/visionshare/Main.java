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

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    //selectedFragment = Submission.newInstance();
                    break;
                case R.id.navigation_trending:
                    mTextMessage.setText(R.string.title_trending);
                    //selectedFragment = Submission.newInstance();
                    break;
                case R.id.navigation_news:
                    mTextMessage.setText(R.string.title_news);
                    //selectedFragment = Submission.newInstance();
                    break;
                case R.id.navigation_submission:
                    mTextMessage.setText(R.string.title_submission);
                    selectedFragment= (Fragment) new Submission();
                    break;
                case R.id.navigation_my_account:
                    mTextMessage.setText(R.string.title_my_account);
                    //selectedFragment = My_Account.newInstance();
                    break;


            }
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
    }

    /*
    //Manually displaying the first fragment - one time only
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
    transaction.commit();
    */

}
