package com.example.theworldhistory.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.theworldhistory.Adapter.AchievementsAdapter;
import com.example.theworldhistory.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class AchievementsFragment extends Fragment {

    TabLayout achievements_top_bar;
    TabItem goals_button, awards_button, collections_button;
    ViewPager2 achievements_main_area;
    AchievementsAdapter achievementsAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_achievements, container, false);

        achievements_top_bar = view.findViewById(R.id.achievementsTopBar);
        goals_button = view.findViewById(R.id.goalsButton);
        awards_button = view.findViewById(R.id.awardsButton);
        collections_button = view.findViewById(R.id.collectionsButton);
        achievements_main_area = view.findViewById(R.id.achievementsMainArea);


//        fm = getSupportFragmentManager();
        achievementsAdapter = new AchievementsAdapter(getChildFragmentManager(), getLifecycle());
        achievements_main_area.setAdapter(achievementsAdapter);
        achievements_main_area.setSaveEnabled(false);

        achievements_top_bar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                achievements_main_area.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        achievements_main_area.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                achievements_top_bar.selectTab(achievements_top_bar.getTabAt(position));

            }
        });

        return view;
    }
}