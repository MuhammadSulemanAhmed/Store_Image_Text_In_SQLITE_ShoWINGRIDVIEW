package com.example.suleman_pc.myapplication7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class TripsActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private GridView lv;
    private dataAdapter data;
    private TripModel dataModel;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        db = new DatabaseHandler(this);

        lv = (GridView) findViewById(R.id.list1);
        btn=findViewById(R.id.addnew);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TripsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ShowRecords();
    }
    private void ShowRecords() {
        final ArrayList<TripModel> tripModels = new ArrayList<>(db.getAllContacts());
        data = new dataAdapter(this, tripModels);

        lv.setAdapter(data);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = tripModels.get(position);

                Toast.makeText(getApplicationContext(), String.valueOf(dataModel.getID()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
