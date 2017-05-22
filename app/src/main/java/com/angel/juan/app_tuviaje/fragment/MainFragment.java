package com.angel.juan.app_tuviaje.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel.juan.app_tuviaje.DetailActivity;
import com.angel.juan.app_tuviaje.MainActivity;
import com.angel.juan.app_tuviaje.R;
import com.angel.juan.app_tuviaje.adapter.ViajeAdapter;
import com.angel.juan.app_tuviaje.databinding.FragmentMainBinding;
import com.angel.juan.app_tuviaje.models.Viaje;
import com.angel.juan.app_tuviaje.util.Data;


public class MainFragment extends Fragment implements ViajeAdapter.OnViajeListener{

    public static MainFragment instace(){
        return new MainFragment();
    }

    FragmentMainBinding binding;
    ViajeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapter = new ViajeAdapter(getLayoutInflater(null), this);//Instancia el adapter, con el constructor van juntos
        //vinculo la lista recycler con el adapter
        binding.recycler.setAdapter(adapter);
        //LayoutManager me organiza los elemtentos de la lista, linearmanager como una lista
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadData();


        return binding.getRoot();
    }


    private void loadData() {

        Data.data.clear();

        Viaje r1 = new Viaje();
        r1.setNombre("Parque Nacional Puracé");
        r1.setTelefono("3217927944");
        r1.setCosto("30.000");
        r1.setDescripcion(getString(R.string.contenido));
        r1.setDireccion("Parque Puracé");
        r1.setImagen("http://2.bp.blogspot.com/-JIfScqan2l8/VXRWo-XsWLI/AAAAAAAAGwo/nljkjda5Ypk/w1200-h630-p-k-no-nu/AFICHE%2BPARQUE%2BNATURAL%2BDEL%2BPURACE.png");
        r1.setFecha("20 de Mayo del 2017");

        Viaje r2 = new Viaje();
        r2.setNombre("Volcán Puracé");
        r2.setTelefono("3217927944");
        r2.setCosto("30.000");
        r2.setDescripcion(getString(R.string.contenido));
        r2.setDireccion("Parque Puracé");
        r2.setImagen("https://img.absolutviajes.com/wp-content/uploads/2012/05/Purace.jpg");
        r2.setFecha("10 de Noviembre del 2017");


        Viaje r3 = new Viaje();
        r3.setNombre("Tierradentro");
        r3.setTelefono("3217927944");
        r3.setCosto("30.000");
        r3.setDescripcion(getString(R.string.contenido));
        r3.setDireccion("Inza");
        r3.setImagen("http://cdn.colombia.com/images/colombia-info/historia-de-colombia/cc-tierradentro.jpg");
        r3.setFecha("31 de Octubre del 2017");


        Viaje r4 = new Viaje();
        r4.setNombre("Parapente en Balboa");
        r4.setTelefono("3217927944");
        r4.setCosto("30.000");
        r4.setDescripcion(getString(R.string.contenido));
        r4.setDireccion("Balboa");
        r4.setImagen("http://www.barilochexcursiones.com/images/sistema/actividades/galeria/parapente%20copia.jpg");
        r4.setFecha("10 de Diciembre del 2017");


        Viaje r5 = new Viaje();
        r5.setNombre("Fin del Mundo");
        r5.setTelefono("3217927944");
        r5.setCosto("30.000");
        r5.setDescripcion(getString(R.string.contenido));
        r5.setDireccion("Mocoa");
        r5.setImagen("http://viajesvivex.com/wp-content/uploads/2016/08/cascadas-fin-del-mundo-putumayo-03.jpg");
        r5.setFecha("10 de Junio del 2017");


        Viaje r6 = new Viaje();
        r6.setNombre("Salento");
        r6.setTelefono("3217927944");
        r6.setCosto("30.000");
        r6.setDescripcion(getString(R.string.contenido));
        r6.setDireccion("Salento");
        r6.setImagen("http://www.armeniahotel.com.co/wp-content/uploads/2013/01/14140055773_8f50a48dc3_b.jpg");
        r6.setFecha("03 de Marzo del 2017");

        Data.data.add(r1);
        Data.data.add(r2);
        Data.data.add(r3);
        Data.data.add(r4);
        Data.data.add(r5);
        Data.data.add(r6);

        adapter.notifyDataSetChanged();


    }

    @Override
    public void onViaje(View v) {
        int pos= binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POS, pos);//manda la informacion al activity dependiendo de cual se toque
        startActivity(intent);

    }
}