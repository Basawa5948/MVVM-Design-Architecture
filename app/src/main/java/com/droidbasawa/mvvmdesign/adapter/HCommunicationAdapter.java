package com.droidbasawa.mvvmdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.droidbasawa.mvvmdesign.R;
import com.droidbasawa.mvvmdesign.response.HCommunicationResponseModel;
import com.droidbasawa.mvvmdesign.ui.HCommunication;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HCommunicationAdapter extends RecyclerView.Adapter<HCommunicationAdapter.ViewHolder> {

    private ArrayList<HCommunicationResponseModel> responseList;
    private Context context;

    public HCommunicationAdapter
            (ArrayList<HCommunicationResponseModel> response, HCommunication hCommunication) {
    this.responseList = response;
    this.context = hCommunication;
    }

    @NonNull
    @Override
    public HCommunicationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hcommunication_list,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HCommunicationAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(responseList.get(position).getLargeImageURL()).fit().centerCrop().into(holder.thumb);
        holder.title.setText(responseList.get(position).getUser());
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumb;
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);

            thumb = (ImageView) itemView.findViewById(R.id.thumb);
            title = (TextView) itemView.findViewById(R.id.user);
        }
    }
}
