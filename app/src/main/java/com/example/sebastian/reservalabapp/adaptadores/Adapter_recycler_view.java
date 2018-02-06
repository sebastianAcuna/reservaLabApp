package com.example.sebastian.reservalabapp.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastian.reservalabapp.R;

import java.util.List;

/**
 * Created by sebastian on 06-02-2018.
 */

public class Adapter_recycler_view extends RecyclerView.Adapter<Adapter_recycler_view.ViewHolder>{
    private List<String> nombres;
    private int layout;
    private OnItemClickListener listener;


    public Adapter_recycler_view(List<String> nombres, int layout, OnItemClickListener listener){
        this.nombres = nombres;
        this.layout = layout;
        this.listener = listener;

    }

    //
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(nombres.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvname;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvname = itemView.findViewById(R.id.rv_name);
        }

        public void bind(final String name, final OnItemClickListener listener){
            tvname.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }


    public interface  OnItemClickListener{
        void onItemClick(String name, int position);
    }
}
