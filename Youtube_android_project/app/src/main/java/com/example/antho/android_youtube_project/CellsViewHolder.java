package com.example.antho.android_youtube_project;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by antho on 25/03/2017.
 */

public class CellsViewHolder extends RecyclerView.ViewHolder{
    private TextView author;
    private  TextView title;
    private OnCellsSelectedListener onCellsSelectedListener;

    public CellsViewHolder(View itemView){
        super(itemView);
        author=(TextView)itemView.findViewById(R.id.author);
        title =(TextView) itemView.findViewById(R.id.title);
    }

    public void bind(final Cell cell){
        author.setText(cell.getSnippet().getChannelTitle());
        title.setText(cell.getSnippet().getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCellsSelectedListener == null) {
                    return;
                }
            }});
    }

    public void setOnCellsSelectedListener(OnCellsSelectedListener onCellsSelectedListener){
        this.onCellsSelectedListener=onCellsSelectedListener;
    }

}
