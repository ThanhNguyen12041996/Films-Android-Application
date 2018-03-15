package com.example.minhthanh.listview_lab3_androidth;

/**
 * Created by minh thanh on 3/11/2018.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity2 extends AppCompatActivity {

    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //   Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recycler_view);


                GsonBuilder buider = new GsonBuilder();
        Gson gson = buider.create();
        Type listType = new TypeToken<List<Profile>>(){}.getType();
        List<Profile> chapters = (List<Profile>) gson.fromJson(MyApp.msgMovie, listType);


        ContactsAdapter adapter = new ContactsAdapter(this, chapters);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));




    }
}