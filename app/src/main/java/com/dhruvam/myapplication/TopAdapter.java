package com.dhruvam.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 12-04-2018.
 */

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.DataHolder> {
    ArrayList<String> mArrayList;
    ArrayList<String> mAuthorList;
    ArrayList<String> mDateList;
    ArrayList<Integer> mResourceList;

    public TopAdapter(ArrayList<String> arrayList, ArrayList<String> authorList, ArrayList<String> dateList, ArrayList<Integer> resourceList) {
        mArrayList = arrayList;
        mAuthorList = authorList;
        mDateList = dateList;
        mResourceList = resourceList;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_card,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position) {
        holder.title.setText(mArrayList.get(position));
        holder.subTitle.setText(mAuthorList.get(position));
        holder.firstLine.setText(mDateList.get(position));
        holder.imageView.setImageResource(mResourceList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, subTitle, firstLine;

        public DataHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.media_image_top);


            title = itemView.findViewById(R.id.primary_text_top);
            subTitle = itemView.findViewById(R.id.sub_text_top);
            firstLine = itemView.findViewById(R.id.supporting_text_top);
        }
    }
}
