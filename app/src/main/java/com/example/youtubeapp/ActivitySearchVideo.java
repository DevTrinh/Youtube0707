package com.example.youtubeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youtubeapp.adapter.AdapterHistorySearch;
import com.example.youtubeapp.interfacee.InterfaceDefaultValue;
import com.example.youtubeapp.item.ItemSearch;
import com.example.youtubeapp.preferences.PrefConfig;
import com.example.youtubeapp.preferences.PrefListSearch;

import java.util.ArrayList;

public class ActivitySearchVideo extends AppCompatActivity implements InterfaceDefaultValue {
    private RecyclerView rvHistorySearch;
    private AdapterHistorySearch adapterHistorySearch;
    private EditText etSearch;
    private ArrayList<ItemSearch> listItemSearch = new ArrayList<>();
    private ArrayList<String> listHi = new ArrayList<>();
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_video);
        mapping();

        if (listItemSearch == null){
            listItemSearch = new ArrayList<>();
        }
        else{
            listItemSearch = PrefListSearch.getArrayList(this);
        }
        //get data Preferences

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvHistorySearch.setLayoutManager(linearLayoutManager);
        adapterHistorySearch = new AdapterHistorySearch(listItemSearch);
        rvHistorySearch.setAdapter(adapterHistorySearch);
        adapterHistorySearch.notifyDataSetChanged();

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    listItemSearch.add(new ItemSearch(etSearch.getText().toString()+""));
                    PrefListSearch.saveArrayList(listItemSearch, getApplicationContext());
                    Intent returnMain = new Intent(ActivitySearchVideo.this, MainActivity.class);
                    returnMain.putExtra(VALUE_SEARCH, etSearch.getText().toString()+"");
                    startActivity(returnMain);
                }
                return false;
            }
        });
    }

    public ArrayList<ItemSearch> listSearch(){
        ArrayList<ItemSearch> list = new ArrayList<>();
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("instagram"));
        list.add(new ItemSearch("Twister"));
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("Face Book"));
        list.add(new ItemSearch("Face Book"));

        return list;
    }

    public void mapping(){
        rvHistorySearch = findViewById(R.id.rv_history_search);
        etSearch = findViewById(R.id.et_search_video);
    }
}