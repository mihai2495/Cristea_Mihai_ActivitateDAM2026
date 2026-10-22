package com.example.damlaborator2_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final int[] valoare1 = {0};
        final int[] valoare2 = {0};

        if (bundle != null) {
            String mesaj = bundle.getString("mesaj");
            valoare1[0] = bundle.getInt("valoare1");
            valoare2[0] = bundle.getInt("valoare2");

            Log.d(TAG, "Mesaj primit: " + mesaj);
            Log.d(TAG, "Valoare 1: " + valoare1[0]);
            Log.d(TAG, "Valoare 2: " + valoare2[0]);

            String rezultat = mesaj + "\nValoare 1: " + valoare1 + "\nValoare 2: " + valoare2[0];
            Toast.makeText(this, rezultat, Toast.LENGTH_LONG).show();

            Button buttonReturn = findViewById(R.id.buttonReturn);
            buttonReturn.setOnClickListener(v->{
                int suma = valoare1[0] + valoare2[0];
                Intent resultIntent = new Intent();
                resultIntent.putExtra("mesajReturnat", "Calculul efectuat cu succes!");
                resultIntent.putExtra("suma", suma);

                setResult(RESULT_OK, resultIntent);
                finish();
            });

        }
    }
}