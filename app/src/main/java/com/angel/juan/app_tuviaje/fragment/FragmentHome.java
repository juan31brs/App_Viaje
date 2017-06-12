package com.angel.juan.app_tuviaje.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel.juan.app_tuviaje.DetailActivity;
import com.angel.juan.app_tuviaje.DetailActivity2;
import com.angel.juan.app_tuviaje.R;
import com.angel.juan.app_tuviaje.adapter.DestinoAdapter;
import com.angel.juan.app_tuviaje.databinding.FragmentHomeBinding;
import com.angel.juan.app_tuviaje.models.Destino;
import com.angel.juan.app_tuviaje.util.Data;


public class FragmentHome extends Fragment  implements DestinoAdapter.OnDestinoListener{


    FragmentHomeBinding binding;
    DestinoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        adapter = new DestinoAdapter(getLayoutInflater(null), this);//Instancia el adapter, con el constructor van juntos
        //vinculo la lista recycler con el adapter
        binding.recycler.setAdapter(adapter);
        //LayoutManager me organiza los elemtentos de la lista, linearmanager como una lista
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        loadDesti();


        return binding.getRoot();
    }


    private void loadDesti() {

        Data.datade.clear();


        Destino r1 = new Destino();
        r1.setNombre(getString(R.string.nombrepurace));
        r1.setTelefono(getString(R.string.cellparque));
        r1.setCosto(getString(R.string.costopurace));
        r1.setDescripcion(getString(R.string.contenidoparque));
        r1.setDireccion(getString(R.string.direcionpurace));
        r1.setImagen("http://2.bp.blogspot.com/-JIfScqan2l8/VXRWo-XsWLI/AAAAAAAAGwo/nljkjda5Ypk/w1200-h630-p-k-no-nu/AFICHE%2BPARQUE%2BNATURAL%2BDEL%2BPURACE.png");
        r1.setGuia(getString(R.string.guiapurace));

        Destino r2 = new Destino();
        r2.setNombre(getString(R.string.nombrenevado));
        r2.setTelefono(getString(R.string.cellnevado));
        r2.setCosto(getString(R.string.costonevado));
        r2.setDescripcion(getString(R.string.contenidonevado));
        r2.setDireccion(getString(R.string.direcionnevado));
        r2.setImagen(getString(R.string.imgnevado));
        r2.setGuia(getString(R.string.guianevado));

        Destino r3 = new Destino();
        r3.setNombre(getString(R.string.nombrecotopaxi));
        r3.setTelefono(getString(R.string.cellcotopaxi));
        r3.setCosto(getString(R.string.costocotopaxi));
        r3.setDescripcion(getString(R.string.contenidocotopaxi));
        r3.setDireccion(getString(R.string.direcionquito));
        r3.setImagen(getString(R.string.imgcotopaxi));
        r3.setGuia(getString(R.string.guiacotopaxi));

        Destino r4 = new Destino();
        r4.setNombre(getString(R.string.nombrevolcan));
        r4.setTelefono(getString(R.string.cellcotopaxi));
        r4.setCosto(getString(R.string.costovolcan));
        r4.setDescripcion(getString(R.string.contenidocotopaxi));
        r4.setDireccion(getString(R.string.direcionpurace));
        r4.setImagen(getString(R.string.guiavolcan));
        r4.setGuia(getString(R.string.guiavolca));


        Destino r5 = new Destino();
        r5.setNombre(getString(R.string.nombreazufral));
        r5.setTelefono(getString(R.string.cellcotopaxi));
        r5.setCosto(getString(R.string.costoazufral));
        r5.setDescripcion(getString(R.string.contenidoazufral));
        r5.setDireccion(getString(R.string.direciontierra));
        r5.setImagen(getString(R.string.imgazufral));
        r5.setGuia(getString(R.string.guiapurace));


        Destino r6 = new Destino();
        r6.setNombre(getString(R.string.nombrebalboa));
        r6.setTelefono(getString(R.string.cellcotopaxi));
        r6.setCosto(getString(R.string.costobalboa));
        r6.setDescripcion(getString(R.string.contenidoazufral));
        r6.setDireccion(getString(R.string.direcionbalboa));
        r6.setImagen(getString(R.string.imgbalboa));
        r6.setGuia(getString(R.string.guiapurace));


        Destino r7 = new Destino();
        r7.setNombre(getString(R.string.nombrefin));
        r7.setTelefono(getString(R.string.cellcotopaxi));
        r7.setCosto(getString(R.string.costofin));
        r7.setDescripcion(getString(R.string.contenidoazufral));
        r7.setDireccion(getString(R.string.direccionmocoa));
        r7.setImagen(getString(R.string.imgfincho));
        r7.setGuia(getString(R.string.guiapurace));


        Destino r8 = new Destino();
        r8.setNombre(getString(R.string.nombresalento));
        r8.setTelefono(getString(R.string.cellcotopaxi));
        r8.setCosto(getString(R.string.costosalent));
        r8.setDescripcion(getString(R.string.contenidoazufral));
        r8.setDireccion(getString(R.string.direcionsalento));
        r8.setImagen(getString(R.string.imgsalento));
        r8.setGuia(getString(R.string.guiapurace));

        Data.datade.add(r1);
        Data.datade.add(r2);
        Data.datade.add(r3);
        Data.datade.add(r4);
        Data.datade.add(r5);
        Data.datade.add(r6);
        Data.datade.add(r7);
        Data.datade.add(r8);

        adapter.notifyDataSetChanged();


    }

    @Override
    public void onDestino(View v) {
        int pos= binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(getContext(), DetailActivity2.class);
        intent.putExtra(DetailActivity2.EXTRA_POS, pos);//manda la informacion al activity dependiendo de cual se toque
        startActivity(intent);

    }
}