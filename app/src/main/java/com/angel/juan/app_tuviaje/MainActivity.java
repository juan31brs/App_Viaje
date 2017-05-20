package com.angel.juan.app_tuviaje;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ToggleButton;

import com.angel.juan.app_tuviaje.adapter.ViajeAdapter;
import com.angel.juan.app_tuviaje.databinding.ActivityMainBinding;
import com.angel.juan.app_tuviaje.fragment.ConocenosFragment;
import com.angel.juan.app_tuviaje.fragment.FragmentHome;
import com.angel.juan.app_tuviaje.fragment.MainFragment;
import com.angel.juan.app_tuviaje.models.Viaje;
import com.angel.juan.app_tuviaje.util.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {
    //NavigationView.OnNavigationItemSelectedListener//LO COLOQUE DEL MENU

    ActivityMainBinding binding;
    //ViajeAdapter adapter;
    ActionBarDrawerToggle toggle;//Boton menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//muestra el boton hacia atras
        toggle = new ActionBarDrawerToggle(this
                , binding.drawer
                , R.string.menu_open
                , R.string.menu_close);//instancio el boton, primero el activiy, drawerlayout y dos recurdos, cuando seabre
        //y cuando se acierra

        //con esto se agregarn 4 momentos cuando se abre, cuando el estado empieza a cambair y demas
        //los metodos son los que van con onDrawer
        binding.drawer.addDrawerListener(this);//del menu
        //Data.data = new ArrayList<>();

        binding.nav.setNavigationItemSelectedListener(this);

        putFragment(MainFragment.instace());


    }

    //reemplaza el menu de atras, para que este arriba en pantalla
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {//del boton
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }


    //cuando lo seleciono el menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //con este el ya muestra y oculta el menu
        if (toggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()){
            case R.id.reserva:
                Intent i = new Intent(this, ReservaActivity.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    //cuando le empiezo a mover
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    //cuando se abre
    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    //cuando se cierra
    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    //cuando ele stado empieza a cambiar
    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                putFragment(new MainFragment());
                break;
            case R.id.nav_viaje:
                putFragment(new FragmentHome());
                break;
            case R.id.nav_conocenos:
                putFragment(new ConocenosFragment());
                break;


        }
        binding.drawer.closeDrawers();
        return true;
    }

    void putFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }




}

