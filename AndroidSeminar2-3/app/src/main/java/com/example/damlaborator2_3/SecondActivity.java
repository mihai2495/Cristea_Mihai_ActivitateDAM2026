package com.example.damlaborator2_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_THIRD = 1;
    private static final String TAG = "LifecycleDemo";

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

        Log.i(TAG, "onCreate a fost apelata");

        Button btnOpenThird = findViewById(R.id.btnOpenThird);

        btnOpenThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("mesaj", "Salut din Activity 2!");
                bundle.putInt("valoare1", 10);
                bundle.putInt("valoare2", 20);

                intent.putExtras(bundle);


                startActivityForResult(intent, REQUEST_CODE_THIRD);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_THIRD && resultCode == RESULT_OK) {
            if (data != null) {
                String mesajReturnat = data.getStringExtra("mesajReturnat");
                int suma = data.getIntExtra("suma", 0);

                // Afișăm în Logcat folosind același tag
                Log.d(TAG, "Mesaj returnat: " + mesajReturnat);
                Log.d(TAG, "Suma calculată: " + suma);

                // Afișăm și pe ecran printr-un Toast
                String rezultatToast = mesajReturnat + "\nSumă: " + suma;
                Toast.makeText(this, rezultatToast, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart o fost apelata");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume a fost apelata");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause a fost apelata");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "onStop a fost apelata");
    }
}