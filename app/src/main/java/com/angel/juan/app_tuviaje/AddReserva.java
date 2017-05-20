package com.angel.juan.app_tuviaje;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.angel.juan.app_tuviaje.databinding.ActivityAddBinding;
import com.angel.juan.app_tuviaje.models.Reserva;
import com.angel.juan.app_tuviaje.models.ReservaDao;


public class AddReserva extends AppCompatActivity {

    ActivityAddBinding binding;
    ReservaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setHandler(this);
        dao = ((App)getApplication()).session.getReservaDao();
    }

    public void save(){
        String name =  binding.name.getText().toString();
        String fecha = binding.fecha.getText().toString();
        String costo = binding.costo.getText().toString();
        Reserva reserva = new Reserva();
        reserva.setNombre(name);
        reserva.setFecha(fecha);
        reserva.setCosto(costo);

        dao.insert(reserva);

        finish();
    }

}