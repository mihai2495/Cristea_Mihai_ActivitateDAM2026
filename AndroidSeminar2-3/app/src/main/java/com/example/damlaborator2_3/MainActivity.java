package com.example.damlaborator2_3;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleDemo";

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
        Log.i(TAG, "onCreate a fost apelata");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart o fost apelata");
        /*
        Se apelează când activitatea devine vizibilă pe ecran.
        Pregateste activitatea pentru a ajunge in prim-plan
         */
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v(TAG, "onResume a fost apelata");
        /*
        Se activeaza cand aplicatia apare in prim-plan
        In aceasta stare utilizatorul poate interactiona direct cu aplicatia
         */
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.w(TAG, "onPause a fost apelata");
        /*
        Se activeaza cand activitatea isi pierde ficalizarea dar ramane partial vizibila
        Indica faptul ca utilizatorul paraseste activitatea. Se foloseste pentru a optimiza utilizarea de resurse
         */
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.w(TAG, "onStop a fost apelata");
        /*
        Se apeleaza cand activitatea nu mai este deloc vizibila pe ecran
        Se executa cand alta activitate acopera complet ecranul sau cand aplicatia este minimizata
        si are tot rol de optimizare a folosirii de resurse.
         */
    }


}