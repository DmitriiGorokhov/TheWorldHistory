package com.example.theworldhistory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theworldhistory.Models.Collection;
import com.example.theworldhistory.R;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>{

    Context context;
    List<Collection> collections;

    public CollectionAdapter(Context context, List<Collection> collections) {
        this.context = context;
        this.collections = collections;
    }

    @NonNull
    @Override
    public CollectionAdapter.CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View collection_items = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new CollectionAdapter.CollectionViewHolder(collection_items);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionAdapter.CollectionViewHolder holder, int position) {
        holder.collection_title.setText(collections.get(position).getTitle());
        holder.collection_status_number.setText(collections.get(position).getStatus_number());

        int status_1_1 = context.getResources().getIdentifier(collections.get(position).getStatus_1_1(), "drawable", context.getPackageName());
        holder.collection_status_1_1.setImageResource(status_1_1);
        int status_1_2 = context.getResources().getIdentifier(collections.get(position).getStatus_1_2(), "drawable", context.getPackageName());
        holder.collection_status_1_2.setImageResource(status_1_2);
        int status_1_3 = context.getResources().getIdentifier(collections.get(position).getStatus_1_3(), "drawable", context.getPackageName());
        holder.collection_status_1_3.setImageResource(status_1_3);
        int status_2_1 = context.getResources().getIdentifier(collections.get(position).getStatus_2_1(), "drawable", context.getPackageName());
        holder.collection_status_2_1.setImageResource(status_2_1);
        int status_2_2 = context.getResources().getIdentifier(collections.get(position).getStatus_2_2(), "drawable", context.getPackageName());
        holder.collection_status_2_2.setImageResource(status_2_2);
        int status_2_3 = context.getResources().getIdentifier(collections.get(position).getStatus_2_3(), "drawable", context.getPackageName());
        holder.collection_status_2_3.setImageResource(status_2_3);

        int image_1_1 = context.getResources().getIdentifier(collections.get(position).getImage_1_1(), "drawable", context.getPackageName());
        holder.collection_image_1_1.setImageResource(image_1_1);
        int image_1_2 = context.getResources().getIdentifier(collections.get(position).getImage_1_2(), "drawable", context.getPackageName());
        holder.collection_image_1_2.setImageResource(image_1_2);
        int image_1_3 = context.getResources().getIdentifier(collections.get(position).getImage_1_3(), "drawable", context.getPackageName());
        holder.collection_image_1_3.setImageResource(image_1_3);
        int image_2_1 = context.getResources().getIdentifier(collections.get(position).getImage_2_1(), "drawable", context.getPackageName());
        holder.collection_image_2_1.setImageResource(image_2_1);
        int image_2_2 = context.getResources().getIdentifier(collections.get(position).getImage_2_2(), "drawable", context.getPackageName());
        holder.collection_image_2_2.setImageResource(image_2_2);
        int image_2_3 = context.getResources().getIdentifier(collections.get(position).getImage_2_3(), "drawable", context.getPackageName());
        holder.collection_image_2_3.setImageResource(image_2_3);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    public static final class CollectionViewHolder extends RecyclerView.ViewHolder {

        TextView collection_title, collection_status_number;
        ImageView collection_status_1_1, collection_status_1_2, collection_status_1_3,
                collection_status_2_1, collection_status_2_2, collection_status_2_3,
                collection_image_1_1, collection_image_1_2, collection_image_1_3,
                collection_image_2_1, collection_image_2_2, collection_image_2_3;

        public CollectionViewHolder(@NonNull View itemView) {
            super(itemView);

            collection_title = itemView.findViewById(R.id.collection_title);
            collection_status_number = itemView.findViewById(R.id.collection_status_number);

            collection_status_1_1 = itemView.findViewById(R.id.collection_status_1_1);
            collection_status_1_2 = itemView.findViewById(R.id.collection_status_1_2);
            collection_status_1_3 = itemView.findViewById(R.id.collection_status_1_3);
            collection_status_2_1 = itemView.findViewById(R.id.collection_status_2_1);
            collection_status_2_2 = itemView.findViewById(R.id.collection_status_2_2);
            collection_status_2_3 = itemView.findViewById(R.id.collection_status_2_3);

            collection_image_1_1 = itemView.findViewById(R.id.collection_image_1_1);
            collection_image_1_2 = itemView.findViewById(R.id.collection_image_1_2);
            collection_image_1_3 = itemView.findViewById(R.id.collection_image_1_3);
            collection_image_2_1 = itemView.findViewById(R.id.collection_image_2_1);
            collection_image_2_2 = itemView.findViewById(R.id.collection_image_2_2);
            collection_image_2_3 = itemView.findViewById(R.id.collection_image_2_3);
        }
    }


}
