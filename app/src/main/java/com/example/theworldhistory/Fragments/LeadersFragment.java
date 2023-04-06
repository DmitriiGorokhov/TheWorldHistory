package com.example.theworldhistory.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.theworldhistory.Adapter.LeagueAdapter;
import com.example.theworldhistory.Models.League;
import com.example.theworldhistory.R;

import java.util.ArrayList;
import java.util.List;

public class LeadersFragment extends Fragment {

    List<League> leagueList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(leagueList.isEmpty()) {
            leagueList.add(new League(1, "Пещера", "ic_20_0_cave_active"));
            leagueList.add(new League(2, "Хижина", "ic_20_0_hut_active"));
            leagueList.add(new League(3, "Деревня", "ic_20_0_village_active"));
            leagueList.add(new League(4, "Поселок", "ic_20_0_settlement_active"));
            leagueList.add(new League(5, "Город", "ic_20_0_city_active"));
            leagueList.add(new League(6, "Мегаполис", "ic_20_0_metropolis_active"));
            leagueList.add(new League(7, "Космополис", "ic_20_0_cosmopolis_active"));
        }

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_leaders, container, false);
        RecyclerView league_recycler = view.findViewById(R.id.league_recycler);
        league_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        league_recycler.setAdapter(new LeagueAdapter(this.getContext(), leagueList));

        return view;
    }
}