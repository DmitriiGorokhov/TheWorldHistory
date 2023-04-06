package com.example.theworldhistory.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.theworldhistory.Adapter.AwardAdapter;
import com.example.theworldhistory.Models.Award;
import com.example.theworldhistory.R;

import java.util.ArrayList;
import java.util.List;

public class AwardsFragment extends Fragment {

    List<Award> awardList = new ArrayList<>();

    public AwardsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(awardList.isEmpty()) {
            awardList.add(new Award(1, "Первые шаги", "Пройди задание №1 в разделе «Первобытное общество»", "0 / 1", "ic_40_0_first_step_active"));
            awardList.add(new Award(2, "Начинающий коллекционер", "Собери свою первую коллекцию","0 / 1", "ic_40_0_first_stone_active"));
            awardList.add(new Award(1, "Первые шаги", "Пройди задание №1 в разделе «Первобытное общество»", "0 / 1", "ic_40_0_first_step_active"));
            awardList.add(new Award(2, "Начинающий коллекционер", "Собери свою первую коллекцию","0 / 1", "ic_40_0_first_stone_active"));
            awardList.add(new Award(1, "Первые шаги", "Пройди задание №1 в разделе «Первобытное общество»", "0 / 1", "ic_40_0_first_step_active"));
            awardList.add(new Award(2, "Начинающий коллекционер", "Собери свою первую коллекцию","0 / 1", "ic_40_0_first_stone_active"));
            awardList.add(new Award(1, "Первые шаги", "Пройди задание №1 в разделе «Первобытное общество»", "0 / 1", "ic_40_0_first_step_active"));
            awardList.add(new Award(2, "Начинающий коллекционер", "Собери свою первую коллекцию","0 / 1", "ic_40_0_first_stone_active"));
        }

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_awards, container, false);
        RecyclerView award_recycler = view.findViewById(R.id.award_recycler);
        award_recycler.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        award_recycler.setAdapter(new AwardAdapter(this.getContext(), awardList));

        return view;
    }
}