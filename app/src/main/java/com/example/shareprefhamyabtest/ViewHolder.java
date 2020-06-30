package com.example.shareprefhamyabtest;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    LinearLayout ll_background;
    private TextView txt_name;
    private TextView txt_family;

    Button btn_run;
    Button btn_stop;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_name = itemView.findViewById(R.id.txt_name);
        txt_family = itemView.findViewById(R.id.txt_family);
        ll_background = itemView.findViewById(R.id.ll_background);
        btn_run = itemView.findViewById(R.id.btn_run);
        btn_stop = itemView.findViewById(R.id.btn_stop);
    }

    public void bindData(UserModel model) {
        txt_name.setText(model.getName());
        txt_family.setText(model.getFamily());
        if(model.getRun()){
            ll_background.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorPrimary));
        }else if(!model.getRun()){
            ll_background.setBackground(null);
        }
    }

    public void setOnProjectHolderListener(final ProjectItemInteraction listener, final UserModel model, final int position) {


        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.projectListItemOnClick(model,position , "run" );
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.projectListItemOnClick(model,position, "stop");
            }
        });

    }
}
