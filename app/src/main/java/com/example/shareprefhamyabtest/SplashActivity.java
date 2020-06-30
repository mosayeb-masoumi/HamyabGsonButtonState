package com.example.shareprefhamyabtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    List<UserModel> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        // to get ArrayList
        Gson gson = new Gson();
        String json = Cache.getJson(this, "OBJECT_KEY");
        Type type = new TypeToken<List<UserModel>>() {
        }.getType();
        userList= gson.fromJson(json, type);

        if(userList == null || userList.size()==0) {


            List<ServiceModel> serviceList = new ArrayList<>();
            serviceList.add(new ServiceModel("reza", "rezai"));
            serviceList.add(new ServiceModel("safa", "safai"));
            serviceList.add(new ServiceModel("iman", "imani"));


            userList = new ArrayList<>();
            for (int i = 0; i < serviceList.size(); i++) {
                userList.add(new UserModel(serviceList.get(i).getName(), serviceList.get(i).getFamily(), false));
            }

            Cache.saveObject(this, "OBJECT_KEY", userList);

        }

        startActivity(new Intent(SplashActivity.this,MainActivity.class));

    }
}