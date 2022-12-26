package com.example.tugasakhir2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profil_Activity extends AppCompatActivity {
    Button btnLogout;
    FirebaseUser firebaseUser;
    TextView txtnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        btnLogout = findViewById(R.id.btnLogOut);
        txtnama = findViewById(R.id.txtNamaPro);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        txtnama.setText(firebaseUser.getDisplayName());
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Profil_Activity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}