package com.example.retrofitarray;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitarray.databinding.CustomBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Recycleadp extends RecyclerView.Adapter<Recycleadp.MyViewHolder> {
    List<ListResArray> adpdata;
    Context context;
    CustomBinding binding;
    public Recycleadp(MainActivity mainActivity, List<ListResArray> data) {
        context=mainActivity;
        adpdata=data;
    }

    @NonNull
    @Override
    public Recycleadp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.custom,null,false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull Recycleadp.MyViewHolder holder, int position) {
        holder.binding.textView.setText(adpdata.get(position).getId());
        holder.binding.textView2.setText(adpdata.get(position).getAppName());
        holder.binding.textView3.setText(adpdata.get(position).getUrl());

        Picasso.get().load(adpdata.get(position).getPic()).into(holder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return adpdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=DataBindingUtil.getBinding(itemView);
        }
    }
}
