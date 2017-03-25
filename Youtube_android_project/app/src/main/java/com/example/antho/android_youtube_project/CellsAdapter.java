package com.example.antho.android_youtube_project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by antho on 25/03/2017.
 */

public class CellsAdapter extends RecyclerView.Adapter<CellsViewHolder>{

    private final List<Cell> cells;
    private OnCellsSelectedListener onCellsSelectedListener;

    public CellsAdapter(List<Cell> cells){
        this.cells=cells;
    }


    @Override
    public CellsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cell,parent,false);
        return new CellsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CellsViewHolder holder, int position){
        holder.setOnCellsSelectedListener(onCellsSelectedListener);
        holder.bind(cells.get(position));
    }

    @Override
    public int getItemCount(){return cells != null ? cells.size():0;}

    public void setOnCellsSelectedListener(OnCellsSelectedListener onCellsSelectedListener){
        this.onCellsSelectedListener=onCellsSelectedListener;
    }
}
