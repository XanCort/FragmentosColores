package com.example.navegacionfragmentos;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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


        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);
        menu.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.rojo){
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragmentContainerView,
                                RedFragment.class, null)
                        .commit();
            }else if(item.getItemId()==R.id.azul){
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragmentContainerView,
                                BlueFragment.class, null)
                        .commit();
            }else if(item.getItemId()==R.id.verde){
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragmentContainerView,
                                GreenFragment.class, null)
                        .commit();
            }else{
                Log.i("ERROR","Como has hecho esto?");
            }
            return true;
        });

    }
}