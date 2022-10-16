package com.example.tiktok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktok.databinding.ReelDgBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>
{

    Context context;
    ArrayList<Model> modelArrayList = new ArrayList<>();
    boolean isPlaying = false;

    public Adapter(Context context, ArrayList<Model> modelArrayList)
    {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_dg, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.name.setText(modelArrayList.get(position).getName());
        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
        // for playing video

        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.start();
                isPlaying = true;
            }
        });

        // if stop video then for again playing
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isPlaying = true;
            }
        });

        //for stop and play vieo by clicking
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying)
                {
                    holder.binding.videoView.pause();
                    isPlaying=false;

                }
                else
                {
                    holder.binding.videoView.resume();
                    isPlaying = true;
                }
            }
        });

    }


    @Override
    public int getItemCount()
    {
        return modelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder

    {
        ReelDgBinding binding;

        public viewHolder(@NonNull View itemView)

        {
            super(itemView);
            binding = ReelDgBinding.bind(itemView);
        }
    }
}
