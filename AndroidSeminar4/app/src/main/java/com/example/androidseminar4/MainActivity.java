package com.example.androidseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvRezultat;
    Button btnAdauga;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();

                    String denumire = data.getStringExtra("denumire");
                    double pret = data.getDoubleExtra("pret", 0);
                    boolean areWifi = data.getBooleanExtra("areWifi", false);
                    String stare = data.getStringExtra("stare");
                    float rating = data.getFloatExtra("rating", 0);
                    boolean areBlitz = data.getBooleanExtra("areBlitz", false);

                    cameraFoto camera = new cameraFoto(denumire, pret, areWifi, stare, rating, areBlitz);

                    String wifi;
                    if (camera.areWifi) {
                        wifi = "da";
                    } else {
                        wifi = "nu";
                    }

                    String blitz;
                    if (camera.areBlitz) {
                        blitz = "da";
                    } else {
                        blitz = "nu";
                    }

                    String text = "Denumire: " + camera.denumire + "\n"
                            + "Pret: " + camera.pret + " RON\n"
                            + "Wi-Fi: " + wifi + "\n"
                            + "Stare: " + camera.stare + "\n"
                            + "Rating: " + camera.rating + "\n"
                            + "Blitz: " + blitz;

                    tvRezultat.setText(text);
                    Toast.makeText(MainActivity.this, "Camera a fost adaugata", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRezultat = findViewById(R.id.tvRezultat);
        btnAdauga = findViewById(R.id.btnAdauga);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                launcher.launch(intent);
            }
        });
    }
}