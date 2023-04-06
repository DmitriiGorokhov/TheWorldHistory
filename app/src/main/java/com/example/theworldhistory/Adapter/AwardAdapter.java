package com.example.theworldhistory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theworldhistory.Models.Award;
import com.example.theworldhistory.R;

import java.util.List;

public class AwardAdapter extends RecyclerView.Adapter<AwardAdapter.AwardViewHolder> {

    Context context;
    List<Award> awards;

    public AwardAdapter(Context context, List<Award> awards) {
        this.context = context;
        this.awards = awards;
    }

    @NonNull
    @Override
    public AwardAdapter.AwardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View award_items = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_award, parent, false);
        return new AwardAdapter.AwardViewHolder(award_items);
    }

    @Override
    public void onBindViewHolder(@NonNull AwardAdapter.AwardViewHolder holder, int position) {
        holder.award_title.setText(awards.get(position).getTitle());
        holder.award_description.setText(awards.get(position).getDescription());
        holder.award_status_number.setText(awards.get(position).getStatusNumber());
        int imageId = context.getResources().getIdentifier(awards.get(position).getImageView(), "drawable", context.getPackageName());
        holder.award_image.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return awards.size();
    }

    public static final class AwardViewHolder extends RecyclerView.ViewHolder {
        ImageView award_image;
        TextView award_title;
        TextView award_description;
        TextView award_status_number;

        public AwardViewHolder(@NonNull View itemView) {
            super(itemView);
            award_image = itemView.findViewById(R.id.award_image);
            award_title = itemView.findViewById(R.id.award_title);
            award_description = itemView.findViewById(R.id.award_description);
            award_status_number = itemView.findViewById(R.id.award_status_number);
        }
    }

}
