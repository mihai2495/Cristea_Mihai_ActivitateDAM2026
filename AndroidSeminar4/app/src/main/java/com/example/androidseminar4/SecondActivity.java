package com.example.androidseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    EditText etMarca;
    EditText etPret;
    Spinner spTip;
    RadioGroup rgStare;
    CheckBox cbWifi;
    SwitchCompat swBlitz;
    RatingBar ratingBar;
    Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etMarca = findViewById(R.id.etMarca);
        etPret = findViewById(R.id.etPret);
        spTip = findViewById(R.id.spTip);
        rgStare = findViewById(R.id.rgStare);
        cbWifi = findViewById(R.id.cbWifi);
        swBlitz = findViewById(R.id.swBlitz);
        ratingBar = findViewById(R.id.ratingBar);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marca = etMarca.getText().toString();
                String pretText = etPret.getText().toString();

                if (marca.isEmpty() || pretText.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Completeaza marca si pretul", Toast.LENGTH_SHORT).show();
                    return;
                }

                double pret = Double.parseDouble(pretText);
                String tip = spTip.getSelectedItem().toString();
                String denumire = marca + " " + tip;

                String stare;
                if (rgStare.getCheckedRadioButtonId() == R.id.rbNoua) {
                    stare = "Noua";
                } else {
                    stare = "Folosita";
                }

                boolean areWifi = cbWifi.isChecked();
                boolean areBlitz = swBlitz.isChecked();
                float rating = ratingBar.getRating();

                cameraFoto camera = new cameraFoto(denumire, pret, areWifi, stare, rating, areBlitz);

                Intent intent = new Intent();
                intent.putExtra("denumire", camera.denumire);
                intent.putExtra("pret", camera.pret);
                intent.putExtra("areWifi", camera.areWifi);
                intent.putExtra("stare", camera.stare);
                intent.putExtra("rating", camera.rating);
                intent.putExtra("areBlitz", camera.areBlitz);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}