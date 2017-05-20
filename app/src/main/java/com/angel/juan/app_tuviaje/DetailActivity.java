package com.angel.juan.app_tuviaje;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.angel.juan.app_tuviaje.change.AppUtil;
import com.angel.juan.app_tuviaje.databinding.ActivityDetailBinding;
import com.angel.juan.app_tuviaje.models.Reserva;
import com.angel.juan.app_tuviaje.models.Viaje;
import com.angel.juan.app_tuviaje.util.Data;

public class DetailActivity extends AppCompatActivity implements OnClickListener {

    private Button ubicacion, reserva;


    //declaro una constante o ETIQUETA, extra viene por convencion
    //la llave EXTRA_POS que tiene valor pos, ME SIRVE PARA ALMACENAR UN VALOR QUE DESPUES LO RECUPERO EN MAINACTIVITY
    //static para que sea una variable de objeto
    public static final String EXTRA_POS = "pos";

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        ubicacion = (Button) findViewById(R.id.button_ubicacion);
        ubicacion.setOnClickListener(this);

        reserva = (Button) findViewById(R.id.button_reservar);
        reserva.setOnClickListener(this);

        //DE ESTA FORMA RECUPERO LA ETQIEUTA, PORQUE YA TENGO LA POSICION
        int pos = getIntent().getExtras().getInt(EXTRA_POS);
        //Ya con esto obtengo el objeto
        Viaje viajes = Data.data.get(pos);
        binding.setViajes(viajes);

    }
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_ubicacion:

                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.button_reservar:

                Intent I = new Intent(this, AddReserva.class);
                startActivity(I);
                break;

            default:
                break;

        }

    }
}
