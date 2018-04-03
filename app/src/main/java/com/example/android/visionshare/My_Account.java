package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class My_Account extends Fragment {


    @Override
    public View onCreateView (LayoutInflater inflater,ViewGroup container,
                              Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_my_account,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.my_account_tabs);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


    }

    public static My_Account newInstance() {
        My_Account fragment = new My_Account();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        //Adding tabs using adapter subclass, then setting viewPager adapter
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(My_Account_Info.newInstance(), "My Info");
        adapter.addFragment(My_Account_Projects.newInstance(), "My Projects");
        viewPager.setAdapter(adapter);

    }

    //Adapter Subclass for adding tabs
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



}
