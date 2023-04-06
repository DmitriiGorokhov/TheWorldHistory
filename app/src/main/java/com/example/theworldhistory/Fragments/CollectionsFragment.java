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
import com.example.theworldhistory.Adapter.CollectionAdapter;
import com.example.theworldhistory.Models.Award;
import com.example.theworldhistory.Models.Collection;
import com.example.theworldhistory.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFragment extends Fragment {

    List<Collection> collectionList = new ArrayList<>();

    public CollectionsFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(collectionList.isEmpty()) {
            collectionList.add(new Collection(1, "Памятники Древнего Египта", "2 / 6",
                "@drawable/sample_achievement_collection_circle",
                "@drawable/ic_30_0_dishes_2",
                "@drawable/ic_50_0_collection_check",
                "@drawable/ic_30_0_animal",
                "@drawable/sample_achievement_collection_circle",
                "@drawable/ic_30_0_mask",
                "@drawable/sample_achievement_collection_circle",
                "@drawable/ic_30_0_weapon",
                "@drawable/sample_achievement_collection_circle",
                "@drawable/ic_30_0_stone_4",
                "@drawable/ic_50_0_collection_check",
                "@drawable/ic_30_0_paper"));

            collectionList.add(new Collection(2, "Экспонаты Египетского музея в Берлине", "1 / 5",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_dishes_2",
                    "@drawable/ic_50_0_collection_check",
                    "@drawable/ic_30_0_animal",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_mask",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_weapon",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_stone_4",
                    "",
                    ""));

            collectionList.add(new Collection(3, "Набор солдатиков Димы", "3 / 4",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_dishes_2",
                    "@drawable/ic_50_0_collection_check",
                    "@drawable/ic_30_0_animal",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_mask",
                    "@drawable/sample_achievement_collection_circle",
                    "@drawable/ic_30_0_weapon",
                    "",
                    "",
                    "",
                    ""));

        }

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_collections, container, false);
        RecyclerView collection_recycler = view.findViewById(R.id.collection_recycler);
        collection_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        collection_recycler.setAdapter(new CollectionAdapter(this.getContext(), collectionList));

        return view;

    }
}