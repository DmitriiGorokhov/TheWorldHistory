package com.example.theworldhistory.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.theworldhistory.R;
import com.example.theworldhistory.Activities.SettingsActivity;

public class ProfileFragment extends Fragment {

    ImageView profile_settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_settings = view.findViewById(R.id.profile_settings);
        profile_settings.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SettingsActivity.class);
            startActivity(intent);
        });
        return view;
    }
}