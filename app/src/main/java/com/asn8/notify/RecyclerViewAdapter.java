package com.asn8.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList heading,text_ish;
    RecyclerViewAdapter(Context context, ArrayList heading ,ArrayList text_ish){
        this.context = context;
        this.heading = heading;
        this.text_ish = text_ish;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.note_list_card,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.heading.setText(String.valueOf(heading.get(position)));
        holder.text.setText(String.valueOf(text_ish.get(position)));
    }

    @Override
    public int getItemCount() {
        return heading.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading,text;

        public ViewHolder(View itemView){
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            text = itemView.findViewById(R.id.text_ing);
        }

    }

}
