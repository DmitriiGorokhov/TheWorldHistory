package com.example.theworldhistory.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.theworldhistory.Fragments.AwardsFragment;
import com.example.theworldhistory.Fragments.CollectionsFragment;
import com.example.theworldhistory.Fragments.GoalsFragment;

public class AchievementsAdapter extends FragmentStateAdapter {

    public AchievementsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new GoalsFragment();
            case 1:
                return new AwardsFragment();
            case 2:
                return new CollectionsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
