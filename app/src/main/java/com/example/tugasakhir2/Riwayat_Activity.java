package com.example.tugasakhir2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Riwayat_Activity extends AppCompatActivity {
    RecyclerView myRey;
    Database db;
    OrderAdapter myAdapter;
    ArrayList<ModelLaundry> mylist;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
        db = new Database(this);
        btndelete = findViewById(R.id.btndelete);
        myRey = findViewById(R.id.tampilRiwayat);
        mylist = new ArrayList<>();
        myAdapter = new OrderAdapter(this,mylist);
        myRey.setAdapter(myAdapter);
        myRey.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer var = db.delete();
                if (var > 0){
                    Toast.makeText(Riwayat_Activity.this,"Data Tidak Ada",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Riwayat_Activity.this,"Semua Data Berhasil Dihapus",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void displaydata(){
        Cursor cursor = db.getData();
        if (cursor.getCount() == 0){
            Toast.makeText(Riwayat_Activity.this, "Tidak Ada data", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(cursor.moveToNext()){
                ModelLaundry m = new ModelLaundry(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
                mylist.add(m);
            }
        }
    }
}