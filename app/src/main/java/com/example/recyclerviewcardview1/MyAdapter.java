package com.example.recyclerviewcardview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewcardview1.model.Model;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    Context mContext;
    ArrayList<Model> mList;
    CallbackListener callbackListener;


    public MyAdapter(Context mContext, ArrayList<Model> mList) {
        this.mContext = mContext;
        this.mList = mList;
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
                callbackListener.callBack(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void filterList(ArrayList<Model> filteredList) {
        this.mList = filteredList;
        notifyDataSetChanged();
    }

    public void callBack(CallbackListener l){
        this.callbackListener = l;
    }
}
