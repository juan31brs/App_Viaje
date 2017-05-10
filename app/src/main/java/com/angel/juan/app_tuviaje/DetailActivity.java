package com.angel.juan.app_tuviaje;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angel.juan.app_tuviaje.databinding.ActivityDetailBinding;
import com.angel.juan.app_tuviaje.models.Viaje;
import com.angel.juan.app_tuviaje.util.Data;

public class DetailActivity extends AppCompatActivity {

    //declaro una constante o ETIQUETA, extra viene por convencion
    //la llave EXTRA_POS que tiene valor pos, ME SIRVE PARA ALMACENAR UN VALOR QUE DESPUES LO RECUPERO EN MAINACTIVITY
    //static para que sea una variable de objeto
    public static final String EXTRA_POS = "pos";

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        //DE ESTA FORMA RECUPERO LA ETQIEUTA, PORQUE YA TENGO LA POSICION
        int pos = getIntent().getExtras().getInt(EXTRA_POS);
        //Ya con esto obtengo el objeto
        Viaje viajes = Data.data.get(pos);
        binding.setViajes(viajes);

    }
}
