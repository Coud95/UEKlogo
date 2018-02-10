package com.example.coud.ueklogo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private ImageView uek;
    private FrameLayout background;
    private Fragment colour, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uek = findViewById(R.id.uek);
        background = findViewById(R.id.background);
        colour = new Colour();
        settings = new Settings();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragments, colour).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.button1) {
                    FragmentTransaction colourTransaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    colourTransaction.replace(R.id.fragments, colour).commit();
                    return true;
                } else if (item.getItemId() == R.id.button2) {
                    FragmentTransaction sizeTransaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    sizeTransaction.replace(R.id.fragments, settings).commit();
                    return true;
                }
                return false;
            }
        });
    }

    public ImageView getImage() {
        return this.uek;
    }

    public FrameLayout getBackground() {
        return background;
    }
}
