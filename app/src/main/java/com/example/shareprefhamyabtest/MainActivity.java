package com.example.shareprefhamyabtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProjectItemInteraction {

    Adapter adapter;
    RecyclerView recyclerView;

    List<UserModel> userList;
    ArrayList<String> idList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setRecyclerView();


    }

    private void setRecyclerView() {

        // to get ArrayList
        Gson gson = new Gson();
        String json = Cache.getJson(this, "OBJECT_KEY");
        Type type = new TypeToken<List<UserModel>>() {
        }.getType();
        userList = gson.fromJson(json, type);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList, this);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void projectListItemOnClick(UserModel model, int position, String state) {

        if (state.equals("run")) {

            for (int i = 0; i < userList.size(); i++) {
                if (i == position) {
                    userList.remove(i);
                    userList.add(i, new UserModel(model.getName(), model.getFamily(), true));
                }
            }
///////////////////////////////////////////////////////////


            Gson gson1 = new Gson();
            String json1 = Cache.getJson(this, "IDLIST_KEY");
            Type type1 = new TypeToken<List<String>>() {
            }.getType();
            idList = gson1.fromJson(json1, type1);

            if (idList == null || idList.size() == 0) {
                idList = new ArrayList<>();
                Toast.makeText(this, "start service", Toast.LENGTH_SHORT).show();
            }


            if (idList.contains(model.getName())) {
                idList.remove(model.getName());
                idList.add(model.getName());
            } else {
                idList.add(model.getName());
            }


            Cache.saveArray(MainActivity.this, "IDLIST_KEY", idList);


            int a = 5;
////////////////////////////////////////////////////////////
        } else if (state.equals("stop")) {
            for (int i = 0; i < userList.size(); i++) {
                if (i == position) {
                    userList.remove(i);
                    userList.add(i, new UserModel(model.getName(), model.getFamily(), false));
                }
            }

//////////////////////////////////////////////////////////////

            if (idList.contains(model.getName())) {
                idList.remove(model.getName());
            }
            if (idList.size() == 0) {
                Toast.makeText(this, "stop service", Toast.LENGTH_SHORT).show();
            }

            Cache.saveArray(MainActivity.this, "IDLIST_KEY", idList);

            int a = 5;
            ////////////////////////////////////////////////////////////
        }

        Cache.saveObject(this, "OBJECT_KEY", userList);

        setRecyclerView();


    }
}