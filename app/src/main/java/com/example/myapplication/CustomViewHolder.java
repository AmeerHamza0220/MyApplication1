package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewId;
    TextView textViewDepartment;
    TextView textViewGender;
    TextView textViewSalary;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textViewName = (TextView) itemView.findViewById(R.id.tvName);
        this.textViewId = (TextView) itemView.findViewById(R.id.tvId);
        textViewDepartment = (TextView) itemView.findViewById(R.id.tvDepartment);
        textViewGender = (TextView) itemView.findViewById(R.id.tvGender);
        textViewSalary = (TextView) itemView.findViewById(R.id.tvSalary);
    }
}
