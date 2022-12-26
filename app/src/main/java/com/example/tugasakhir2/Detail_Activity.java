package com.example.tugasakhir2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Detail_Activity extends AppCompatActivity {

    TextView txtNama,txtTotal,txtHasilKaos,txtHasilJeans,txtHasilJaket,txtHasilBedcover;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtHasilKaos = findViewById(R.id.txtTotalKaos);
        txtHasilJeans = findViewById(R.id.txtTotalJeans);
        txtHasilJaket = findViewById(R.id.txtTotalJaket);
        txtHasilBedcover = findViewById(R.id.txtTotalBedcover);
        txtTotal = findViewById(R.id.txtTotal);
        txtNama = findViewById(R.id.txtNamaDet);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        txtNama.setText(firebaseUser.getDisplayName());

        txtHasilKaos.setText(getIntent().getStringExtra("kaos"));
        txtHasilJeans.setText(getIntent().getStringExtra("jeans"));
        txtHasilJaket.setText(getIntent().getStringExtra("jaket"));
        txtHasilBedcover.setText(getIntent().getStringExtra("bedcover"));
        txtTotal.setText(getIntent().getStringExtra("total"));

    }
}