package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    ArrayList<Employee> employeeArrayList = null;
    Context context;
    CustomAdapter(Context context, ArrayList<Employee> employeeArrayList){
        this.employeeArrayList = employeeArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);
        CustomViewHolder viewHolderObj = new CustomViewHolder(view);
        return viewHolderObj;
    }
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
   //     holder.textViewName.setText("Name: "+
     //           employeeArrayList.get(position).name);
       // holder.textViewId.setText("Id: " +employeeArrayList.get(position).eid+"");
     //   holder.textViewDepartment.setText("Department: "+employeeArrayList.get(position).department);
       //         holder.textViewGender.setText("Gender: "+employeeArrayList.get(position).gender);
         //               holder.textViewSalary.setText("Salary: "+employeeArrayList.get(position).salary+"");
    }
    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }
}