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
        r1.setNombre(getString(R.string.nombrepurace));
        r1.setTelefono(getString(R.string.cellparque));
        r1.setCosto(getString(R.string.costopurace));
        r1.setDescripcion(getString(R.string.contenidoparque));
        r1.setDireccion(getString(R.string.direcionpurace));
        r1.setImagen("http://2.bp.blogspot.com/-JIfScqan2l8/VXRWo-XsWLI/AAAAAAAAGwo/nljkjda5Ypk/w1200-h630-p-k-no-nu/AFICHE%2BPARQUE%2BNATURAL%2BDEL%2BPURACE.png");
        r1.setFecha(getString(R.string.fechapurace));

        Viaje r2 = new Viaje();
        r2.setNombre(getString(R.string.nombrevolcan));
        r2.setTelefono(getString(R.string.cellparque));
        r2.setCosto(getString(R.string.costovolcan));
        r2.setDescripcion(getString(R.string.contenidoparque));
        r2.setDireccion(getString(R.string.direcionpurace));
        r2.setImagen(getString(R.string.guiavolcan));
        r2.setFecha(getString(R.string.fechavolcan));


        Viaje r3 = new Viaje();
        r3.setNombre(getString(R.string.nombretierradentro));
        r3.setTelefono(getString(R.string.cellcotopaxi));
        r3.setCosto(getString(R.string.costoazufral));
        r3.setDescripcion(getString(R.string.contenidoazufral));
        r3.setDireccion(getString(R.string.direciontierra));
        r3.setImagen(getString(R.string.tierradentro));
        r3.setFecha(getString(R.string.fechatierra));


        Viaje r4 = new Viaje();
        r4.setNombre(getString(R.string.nombrebalboa));
        r4.setTelefono(getString(R.string.cellcotopaxi));
        r4.setCosto(getString(R.string.costobalboa));
        r4.setDescripcion(getString(R.string.contenidonevado));
        r4.setDireccion(getString(R.string.direcionbalboa));
        r4.setImagen(getString(R.string.imgbalboa));
        r4.setFecha(getString(R.string.fechabalboa));


        Viaje r5 = new Viaje();
        r5.setNombre(getString(R.string.nombrefin));
        r5.setTelefono(getString(R.string.cellcotopaxi));
        r5.setCosto(getString(R.string.costofin));
        r5.setDescripcion(getString(R.string.contenidonevado));
        r5.setDireccion(getString(R.string.direccionmocoa));
        r5.setImagen(getString(R.string.imgfincho));
        r5.setFecha(getString(R.string.fechafin));


        Viaje r6 = new Viaje();
        r6.setNombre(getString(R.string.nombresalento));
        r6.setTelefono(getString(R.string.cellnevado));
        r6.setCosto(getString(R.string.costosalent));
        r6.setDescripcion(getString(R.string.contenidocotopaxi));
        r6.setDireccion(getString(R.string.direcionsalento));
        r6.setImagen(getString(R.string.imgsalento));
        r6.setFecha(getString(R.string.fechasalento));

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