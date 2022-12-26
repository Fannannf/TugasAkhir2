package com.example.tugasakhir2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Halaman_Utama extends AppCompatActivity {

    ImageView profil,laundry,riwayat;
    TextView nama;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        laundry = findViewById(R.id.imageView4);
        riwayat = findViewById(R.id.imageView6);
        nama = findViewById(R.id.txtNama);
        profil = findViewById(R.id.profil);

        nama.setText(firebaseUser.getDisplayName());
        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Halaman_Utama.this,Riwayat_Activity.class);
                startActivity(intent);
            }
        });

        laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Halaman_Utama.this,Laundry_Activity.class);
                startActivity(intent);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Halaman_Utama.this,Profil_Activity.class);
                startActivity(intent);
            }
        });
    }
}