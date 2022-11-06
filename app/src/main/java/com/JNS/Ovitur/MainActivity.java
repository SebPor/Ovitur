package com.JNS.Ovitur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.JNS.Ovitur.Fragments.FragmentListado;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static DrawerLayout drawerLayout;
    private static FragmentListado fragmentListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = new Toolbar(getApplicationContext());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawe_open, R.string.navigation_drawe_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menu_naturales){
            System.out.println("Se selecciona el fragment");
            fragmentListado = new FragmentListado();
            fragmentListado.setDatos(item.getTitle().toString());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentListado, fragmentListado).commit();
            setTitle(item.getTitle().toString());
        }else if(id == R.id.menu_hechas_por_hombre){
            fragmentListado = new FragmentListado();
            fragmentListado.setDatos(item.getTitle().toString());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentListado, fragmentListado).commit();
            setTitle(item.getTitle().toString());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}