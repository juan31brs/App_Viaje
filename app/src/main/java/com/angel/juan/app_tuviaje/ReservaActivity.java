package com.angel.juan.app_tuviaje;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.angel.juan.app_tuviaje.adapter.ReservaAdapter;
import com.angel.juan.app_tuviaje.databinding.ActivityReservaBinding;
import com.angel.juan.app_tuviaje.models.Reserva;
import com.angel.juan.app_tuviaje.models.ReservaDao;

import java.util.ArrayList;
import java.util.List;

public class ReservaActivity extends AppCompatActivity{

    ActivityReservaBinding binding;
    ReservaAdapter adapter;

    ReservaDao dao;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reserva);
        List<Reserva> data = new ArrayList<>();
        adapter = new ReservaAdapter(getLayoutInflater(), data);
        binding.list.setAdapter(adapter);

        dao = ((App)getApplication()).session.getReservaDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Reserva>data = dao.loadAll();
        adapter.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddReserva.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

}
