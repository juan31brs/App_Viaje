package com.angel.juan.app_tuviaje;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.angel.juan.app_tuviaje.databinding.ActivityDetail2Binding;
import com.angel.juan.app_tuviaje.databinding.ActivityDetailBinding;
import com.angel.juan.app_tuviaje.models.Destino;
import com.angel.juan.app_tuviaje.models.Viaje;
import com.angel.juan.app_tuviaje.util.Data;
import android.view.View.OnClickListener;



public class DetailActivity2 extends AppCompatActivity implements OnClickListener {

    private Button ubicacion;

    //declaro una constante o ETIQUETA, extra viene por convencion
    //la llave EXTRA_POS que tiene valor pos, ME SIRVE PARA ALMACENAR UN VALOR QUE DESPUES LO RECUPERO EN MAINACTIVITY
    //static para que sea una variable de objeto
    public static final String EXTRA_POS = "pos";

    ActivityDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail2);

        ubicacion = (Button) findViewById(R.id.button_ubicacion);
        ubicacion.setOnClickListener(this);

        //DE ESTA FORMA RECUPERO LA ETQIEUTA, PORQUE YA TENGO LA POSICION
        int pos = getIntent().getExtras().getInt(EXTRA_POS);
        //Ya con esto obtengo el objeto
        Destino destinos = Data.datade.get(pos);
        binding.setDestinos(destinos);

    }


    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_ubicacion:

                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;

            default:
                break;

        }

    }
}


