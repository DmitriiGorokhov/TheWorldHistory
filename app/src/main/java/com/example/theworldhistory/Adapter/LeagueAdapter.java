package com.example.theworldhistory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theworldhistory.Models.League;
import com.example.theworldhistory.R;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {

    Context context;
    List<League> leagues;

    public LeagueAdapter(Context context, List<League> leagues) {
        this.context = context;
        this.leagues = leagues;
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View league_items = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_league, parent, false);
        return new LeagueAdapter.LeagueViewHolder(league_items);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueAdapter.LeagueViewHolder holder, int position) {
        holder.league_title.setText(leagues.get(position).getTitle());
        int imageId = context.getResources().getIdentifier(leagues.get(position).getImageView(), "drawable", context.getPackageName());
        holder.league_image.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    public static final class LeagueViewHolder extends RecyclerView.ViewHolder {
        ImageView league_image;
        TextView league_title;

        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);
            league_image = itemView.findViewById(R.id.league_image);
            league_title = itemView.findViewById(R.id.league_title);
        }
    }
}
