package com.dhruvam.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 25-04-2018.
 */

public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.DataHolder> {
    ArrayList<String> mCategoryList;
    ArrayList<String> mArrayList;
    ArrayList<String> mSubTitleList;
    ArrayList<String> mAuthorList;
    ArrayList<String> mDateList;
    ArrayList<Integer> mResourceList;

    public BottomAdapter(ArrayList<String> category, ArrayList<String> data, ArrayList<String> SubTitleList, ArrayList<String> author, ArrayList<String> date, ArrayList<Integer> resource) {
        mArrayList = data;
        mCategoryList = category;
        mAuthorList = author;
        mDateList = date;
        mResourceList = resource;
        mSubTitleList = SubTitleList;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_card,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataHolder holder, int position) {
        holder.writer.setText(mAuthorList.get(position));
        holder.sub_text.setText(mSubTitleList.get(position));
        holder.primary_text.setText(mArrayList.get(position));
        holder.category.setText(mCategoryList.get(position));
        holder.date.setText(mDateList.get(position));

        holder.bookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
        holder.imageView.setImageResource(mResourceList.get(position));


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView, bookmark;
        TextView category, primary_text, sub_text, writer, date;
        public DataHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category);
            primary_text = itemView.findViewById(R.id.primary_text);
            sub_text = itemView.findViewById(R.id.sub_text);
            writer = itemView.findViewById(R.id.writer);
            date = itemView.findViewById(R.id.date);

            imageView = itemView.findViewById(R.id.media_image);
            bookmark = itemView.findViewById(R.id.bookmark);
            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
                }
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(),DetailedActivity.class);
            intent.putExtra("topic", mArrayList.get(getAdapterPosition()));
            intent.putExtra("sub_topic", mSubTitleList.get(getAdapterPosition()));
            intent.putExtra("main_image", ""+mResourceList.get(getAdapterPosition()));
            intent.putExtra("author", mAuthorList.get(getAdapterPosition()));
            intent.putExtra("category", mCategoryList.get(getAdapterPosition()));
            intent.putExtra("date", mDateList.get(getAdapterPosition()));

            v.getContext().startActivity(intent);
        }
    }
}
