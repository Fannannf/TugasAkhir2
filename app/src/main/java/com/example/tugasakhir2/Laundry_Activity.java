package com.example.tugasakhir2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Laundry_Activity extends AppCompatActivity {

    EditText edtKaos,edtJeans,edtJaket,edtBedcover;
    Button btnPesan;
    Database db;
    FirebaseUser firebaseUser;
    int kaos = 1000, jeans = 1200, jaket = 1500, bedcover = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        edtBedcover = findViewById(R.id.edtBedCover);
        edtKaos = findViewById(R.id.edtKaos);
        edtJaket = findViewById(R.id.edtJaket);
        edtJeans = findViewById(R.id.edtJeans);
        btnPesan = findViewById(R.id.btnPesan);
        db = new Database(this);


        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama,kaoss,jeanss,jakett,bedcoverr;
                nama = firebaseUser.getDisplayName();
                kaoss = edtKaos.getText().toString();
                jeanss = edtJeans.getText().toString();
                jakett = edtJaket.getText().toString();
                bedcoverr = edtBedcover.getText().toString();

                int hasilkaos,hasiljeans,hasiljaket,hasilbedcover,hasiltotal;
                hasilkaos = Integer.parseInt(kaoss) * kaos;
                hasiljeans = Integer.parseInt(jeanss) * jeans;
                hasiljaket = Integer.parseInt(jakett) * jaket;
                hasilbedcover = Integer.parseInt(bedcoverr) * bedcover;
                hasiltotal = hasilkaos+hasiljeans+hasiljaket+hasilbedcover;

                Boolean checkinsert = db.insertlaundry(nama,kaoss,jeanss,jakett,bedcoverr,String.valueOf(hasiltotal));
                if (checkinsert == true){
                    Toast.makeText(Laundry_Activity.this,"Data Berhasil Ditambah",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Laundry_Activity.this,Riwayat_Activity.class));
                    finish();
                }else{
                    Toast.makeText(Laundry_Activity.this,"Data Gagal Ditambah",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}