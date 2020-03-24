package com.inhall.rvcedepartments.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.inhall.rvcedepartments.Entity.DepartmentEntity;
import com.inhall.rvcedepartments.R;
import com.inhall.rvcedepartments.ViewHolders.DepartmentsRecyclerViewHolder;
import com.inhall.rvcedepartments.ViewHolders.FacultyListRecyclerViewHolder;

import java.util.ArrayList;

public class FacultyListRecyclerViewAdapter extends RecyclerView.Adapter<FacultyListRecyclerViewHolder> {

    private AppCompatActivity appCompatActivity;
    private ArrayList<DepartmentEntity> facultylistEntities;
    private OnDepartmentClickLister onDepartmentClickLister;
    private LayoutInflater layoutInflater;

    public FacultyListRecyclerViewAdapter(AppCompatActivity appCompatActivity, OnDepartmentClickLister onDepartmentClickLister) {
        this.appCompatActivity = appCompatActivity;
        this.onDepartmentClickLister = onDepartmentClickLister;
        facultylistEntities = new ArrayList<>();
        layoutInflater = appCompatActivity.getLayoutInflater();
    }

    public ArrayList<DepartmentEntity> getDepartmentEntities() {
        return facultylistEntities;
    }

    @NonNull
    @Override
    public FacultyListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.department_recycler_view_arch, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTag() instanceof DepartmentEntity){
                    DepartmentEntity departmentEntity = (DepartmentEntity) v.getTag();
                    onDepartmentClickLister.onDepartmentClicked(departmentEntity);
                }
            }
        });
        return new FacultyListRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyListRecyclerViewHolder holder, int position) {
        holder.polulate(facultylistEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return facultylistEntities.size();
    }

    public interface OnDepartmentClickLister{
        void onDepartmentClicked(DepartmentEntity departmentEntity);
    }
}
