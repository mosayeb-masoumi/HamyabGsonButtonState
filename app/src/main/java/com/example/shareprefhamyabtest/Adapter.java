package com.example.shareprefhamyabtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<ViewHolder> {

    List<UserModel> userList;
    Context context;

    public Adapter(List<UserModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserModel model = userList.get(position);
        holder.bindData(model);
        holder.setOnProjectHolderListener(listener, model , position);

    }

    private ProjectItemInteraction listener = null;

    public void setListener(ProjectItemInteraction listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
