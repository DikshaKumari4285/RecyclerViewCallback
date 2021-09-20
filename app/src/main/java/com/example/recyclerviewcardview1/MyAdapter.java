package com.example.recyclerviewcardview1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview1.MyViewHolder;
import com.example.recyclerviewcardview1.R;
import com.example.recyclerviewcardview1.activities.DetailFlagActivity;
import com.example.recyclerviewcardview1.model.Model;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {


    String IMAGE = "image";
    String TITLE = "title";
    String DESC = "description";

    Context mContext;
    ArrayList<Model> mList;
    ArrayList<Model> backup;

    public MyAdapter(Context mContext, ArrayList<Model> mList) {
        this.mContext = mContext;
        this.mList = mList;
        backup = new ArrayList<>(mList);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.image.setImageResource(model.getImage());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailFlagActivity.class);
                intent.putExtra(IMAGE, model.getImage());
                intent.putExtra(TITLE, model.getTitle());
                intent.putExtra(DESC, model.getDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override //background
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Model> filteredData = new ArrayList<>();

            if (filteredData.toString().isEmpty()){
                filteredData.addAll(backup);
            }
            else {
                for (Model element : backup){
                    if (element.getTitle().toString().toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        filteredData.add(element);
                    }
                    }
                }

            FilterResults results = new FilterResults();
            results.values = filteredData;
            return results;
        }

        @Override //main UI thread
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mList.clear();
            mList.addAll((ArrayList<Model>)filterResults.values);
            notifyDataSetChanged();
        }
    };
}
